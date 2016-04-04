package se.david.cv.jersey;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import se.david.cv.jersey.Main;
import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        server = Main.startServer();
        Client c = ClientBuilder.newClient();

//        c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    public void testGetIt() {
        String responseMsg = target.path("ping").request().get(String.class);
        assertEquals("pong", responseMsg);
    }
}
