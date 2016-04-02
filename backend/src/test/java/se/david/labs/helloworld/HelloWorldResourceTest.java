package se.david.labs.helloworld;

import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.ClassRule;
import org.junit.Test;
import se.david.labs.DropwizardApplication;
import se.david.labs.DropwizardConfiguration;
import se.david.labs.helloworld.domain.Saying;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class HelloWorldResourceTest {
    @ClassRule
    public static final DropwizardAppRule<DropwizardConfiguration> RULE =
            new DropwizardAppRule<DropwizardConfiguration>(DropwizardApplication.class, ResourceHelpers.resourceFilePath("hello-world.yml"));

    @Test
    public void checkHelloWorld_ExpectParameterAsResult() {
        Client client = new JerseyClientBuilder().build();

        Response response = client.target(
                String.format("http://localhost:%d/hello-world?name=Hello", RULE.getLocalPort()))
                .request()
                .get();


        assertEquals(200, response.getStatus());
        assertEquals("Hello", response.readEntity(Saying.class).getContent());
    }
}
