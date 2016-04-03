package se.david.cv.dropwizard.cv;

import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import se.david.cv.dropwizard.DropwizardApplication;
import se.david.cv.dropwizard.DropwizardConfiguration;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class CVResourceTest {
    @ClassRule
    public static final DropwizardAppRule<DropwizardConfiguration> RULE =
            new DropwizardAppRule<DropwizardConfiguration>(DropwizardApplication.class, ResourceHelpers.resourceFilePath("cv.yml"));

    private Client client;

    @Before
    public void setup() {
        client = ClientBuilder.newClient();
    }

    @After
    public void tearDown() {
        client.close();
    }

    @Test
    public void ping_expects_pong() {
        Response response = client.target(
                String.format("http://localhost:%d/cv/ping", RULE.getLocalPort()))
                .request()
                .get();

        assertEquals(200, response.getStatus());
        assertEquals("pong", response.readEntity(String.class));
    }
}
