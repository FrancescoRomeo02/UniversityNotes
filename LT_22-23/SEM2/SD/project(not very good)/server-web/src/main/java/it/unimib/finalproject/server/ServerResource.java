package it.unimib.finalproject.server;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

// import com.fasterxml.jackson.databind.*;
// import com.fasterxml.jackson.core.*;

// import java.util.*;
import java.io.*;
import java.net.*;

@Path("/home")
public class ServerResource {

	// socket per la comunicazione su localhost:8080
	private static final String SERVER_IP = "localhost";
	private static final int SERVER_PORT = 8080;

	public static PrintWriter out = null;
	public static BufferedReader in = null;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static List<String> getListaProiezioni(@QueryParam("events") String toGet, @QueryParam("x") String evento) {
		List<String> lista = new ArrayList<String>();

		try {
			Socket socket = new Socket(SERVER_IP, SERVER_PORT);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// chiedo lista film al database
			out.println("get:" + toGet);

			// ricevo la lista dei film e creo apposita lista
			String line = in.readLine();
			while (line != null) {
				lista.add(line);
				line = in.readLine();
			}
			in.close();
			out.close();
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static Response postPrenotazione(String body) {

		try {
			var mapper = new ObjectMapper();
			var prenotazione = mapper.readValue(body, String.class);

			Socket socket = new Socket(SERVER_IP, SERVER_PORT);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// chiedo posti a una proiezione
			out.println("post:" + prenotazione);
			in.close();
			out.close();
			socket.close();
			return Response.ok().build();
		} catch (IOException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public static Response deletePrenotazione(@QueryParam("id") String toDelete) {

		try {
			Socket socket = new Socket(SERVER_IP, SERVER_PORT);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


			out.println("delete:" + toDelete);


			in.close();
			out.close();
			socket.close();
			return Response.ok().build();
		} catch (IOException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

}