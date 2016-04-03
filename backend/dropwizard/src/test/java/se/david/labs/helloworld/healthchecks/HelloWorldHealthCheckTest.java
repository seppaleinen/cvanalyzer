package se.david.labs.helloworld.healthchecks;

import com.codahale.metrics.health.HealthCheck;
import org.junit.Before;
import org.junit.Test;
import se.david.labs.cv.healthchecks.CVHealthCheck;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class HelloWorldHealthCheckTest {
    private HelloWorldHealthCheck cvHealthCheck;

    @Before
    public void setup() {
        cvHealthCheck = new HelloWorldHealthCheck();
    }
    
    @Test
    public void testHealthCheck_OK() throws Exception {
        HealthCheck.Result result = cvHealthCheck.check();

        assertNotNull(result);
        assertTrue(result.isHealthy());
    }
}