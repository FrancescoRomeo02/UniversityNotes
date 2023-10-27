package it.unimib.finalproject.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;
// importo le librerie per permettere la creazione di una hashtable
import java.util.ArrayList;
import java.util.Hashtable;

// classe database
public class Database extends Thread {
        // recupera il path del file csv
        private static final Path PcsvFilePath = Paths.get("server-web/Eventi.csv");
        String csvFilePath = PcsvFilePath.toAbsolutePath().toString();

        private static Hashtable<String, ArrayList<String>> Database;

        public Database() {
                Database = new Hashtable<String, ArrayList<String>>();
        }

        public synchronized String getItem(String id) {
                String item = "";
                ArrayList<String> list = Database.get(id);
                if (list != null) {
                        for (String s : list) {
                                item += ";" + s;
                        }
                        return item.substring(1);
                }
                return null;

        }

        public synchronized String getAllItems(String id) {
                String item = "";
                for (int i = 1; i < Database.size() + 1; i++) {
                        if (Database.containsKey(id + i)) {
                                item += "\n" + getItem(id + i);
                        }
                }
                return item.substring(1);
        }

        public synchronized void putItem(String key, ArrayList<String> values) {
                Database.put(key, values);
        }

        // leggo CVS fino a capo e aggiugno al db
        public void readCSV() throws IOException {
                try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                                String[] values = line.split(";");
                                ArrayList<String> row = new ArrayList<>();
                                for (String value : values) {
                                        row.add(value);
                                }
                                String key = row.get(0);
                                row.remove(0);
                                Database.put(key, row);
                        }
                }
        }

        public synchronized int getSize() {
                return Database.size();
        }

        public synchronized void deleteItem(String key) {
                Database.remove(key);
        }

        public synchronized void deleteValue(String key, String value) {
                Database.get(key).remove(Database.get(key).indexOf(value));
        }

        public static void main(String[] args) {
                Database db = new Database();
                try {
                        db.readCSV();
                        System.out.println(db.getItem("P1"));
                } catch (IOException e) {
                        e.printStackTrace();
                }       
        }

}
