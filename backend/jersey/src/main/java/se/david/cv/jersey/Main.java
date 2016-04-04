package se.david.cv.jersey;

import lombok.extern.java.Log;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

@Log
public class Main {
    public static final String BASE_URI = "http://localhost:8080/cv/";

    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages("se.david.cv.jersey");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws IOException {
        startServer();
        log.info(String.format("Jersey app started with WADL available at %sapplication.wadl", BASE_URI));
    }
}

