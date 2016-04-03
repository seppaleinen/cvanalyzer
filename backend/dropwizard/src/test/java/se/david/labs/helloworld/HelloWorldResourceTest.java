package se.david.labs.helloworld;

import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import se.david.labs.DropwizardApplication;
import se.david.labs.DropwizardConfiguration;
import se.david.labs.helloworld.domain.Saying;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class HelloWorldResourceTest {
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
    public void checkHelloWorld_ExpectParameterAsResult() {
        Response response = client.target(
                String.format("http://localhost:%d/hello-world?name=Hello", RULE.getLocalPort()))
                .request()
                .get();


        assertEquals(200, response.getStatus());
        assertEquals("Hello", response.readEntity(Saying.class).getContent());
    }
}
