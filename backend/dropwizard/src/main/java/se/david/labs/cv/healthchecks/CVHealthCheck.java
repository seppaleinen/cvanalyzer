package se.david.labs.cv.healthchecks;

import com.codahale.metrics.health.HealthCheck;

public class CVHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        final String saying = "TEST";
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}
