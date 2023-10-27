package it.unimib.finalproject.server;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;

import java.net.URI;

public class Main {

    // URL HTTP di base in cui Grizzly si pone in ascolto. (client web)
    public static final String BASE_URI = "http://localhost:3030/";

    public static HttpServer startServer() {
        final var rc = new ResourceConfig().packages(Main.class.getPackageName());
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws IOException {
        // clinet web
        final var server = startServer();
        System.out.println(String.format("Jersey app started with endpoints available at "
                + "%s%nHit Ctrl-C to stop it...", BASE_URI));
        server.start();

    }
}
