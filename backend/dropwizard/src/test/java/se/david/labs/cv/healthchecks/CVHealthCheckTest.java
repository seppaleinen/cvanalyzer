package se.david.labs.cv.healthchecks;

import com.codahale.metrics.health.HealthCheck;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CVHealthCheckTest {
    private CVHealthCheck cvHealthCheck;

    @Before
    public void setup() {
        cvHealthCheck = new CVHealthCheck();
    }

    @Test
    public void testHealthCheck_OK() throws Exception {
        HealthCheck.Result result = cvHealthCheck.check();

        assertNotNull(result);
        assertTrue(result.isHealthy());
    }
}
