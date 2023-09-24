package it.unimib.finalproject.database;

import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;

public class Main {

    public static final int PORT = 8080;
    public static Database db = new Database();

    public static void startServer() {
        try {
            try (var server = new ServerSocket(PORT)) {
                System.out.println("Database listening at localhost:" + PORT);
                while (true)
                    new Handler(server.accept()).start();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void populateDatabase() throws IOException {
        try {
            db.readCSV();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private Socket client;

        public Handler(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                var out = new PrintWriter(client.getOutputStream(), true);
                var in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                String line = in.readLine();
                String response = "";

                // get:F1,F,...
                if (line != null && line.startsWith("get:") && line.length() > 4) {
                    List<String> paramList = getParametersAsList(line, 4);
                    for (String item : paramList) {
                        if (item.length() == 1 && !checkIfNumber(item)) {
                            response += "," + (db.getAllItems(item));
                        } else if (item.length() > 1 && checkIfNumber(item.substring(1))) {
                            String temp = db.getItem(item);
                            if (temp != null) {
                                response += "," + temp;
                            }
                        }
                        if (response.length() > 1) {
                            out.println(response.substring(1));
                        } else {
                            out.println("null");
                        }
                    }
                } else if (line != null && line.startsWith("post:") && line.length() > 5) {
                    List<String> paramList = getParametersAsList(line, 5);
                    String key = paramList.get(0);

                    ArrayList<String> value = new ArrayList<String>();
                    // salta il primo elemento
                    for (int i = 1; i < paramList.size(); i++) {
                        value.add(paramList.get(i));
                    }
                    db.putItem(key, value);
                    out.println("post done.");

                } else if (line != null && line.startsWith("delete:") && line.length() > 7) {
                    List<String> paramList = getParametersAsList(line, 7);
                    String key = paramList.get(0);
                    if (paramList.size() == 1) {
                        db.deleteItem(key);
                    } else if (paramList.size() > 1) {
                        for (String item : paramList) {
                            if (!item.equals(key)) {
                                db.deleteValue(key, item);
                            }
                        }
                    }

                } else
                    out.println("ERROR");

                in.close();
                out.close();
                client.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }

    }

    public static ArrayList<String> getListaFilm() {
        ArrayList<String> lista = new ArrayList<String>();
        for (int i = 1; i < db.getSize() + 1; i++) {
            try {
                lista.add(db.getItem("Film" + Integer.toString(i)));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return lista;
    }

    public static List<String> getParametersAsList(String s, int baseCallLength) {
        List<String> paramList = new ArrayList<String>();
        paramList = Arrays.asList(s.substring(baseCallLength).split(";"));
        return paramList;
    }

    public static boolean checkIfNumber(String s) {
        if (s == null) {
            return false;
        }
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        populateDatabase();
        startServer();
    }

}
