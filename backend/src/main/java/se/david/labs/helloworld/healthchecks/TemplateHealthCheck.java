package se.david.labs.helloworld.healthchecks;

import com.codahale.metrics.health.HealthCheck;

public class TemplateHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        final String saying = "TEST";
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return HealthCheck.Result.healthy();
    }
}
