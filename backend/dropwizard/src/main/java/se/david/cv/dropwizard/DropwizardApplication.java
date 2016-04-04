package se.david.cv.dropwizard;

import com.codahale.metrics.health.HealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import se.david.cv.dropwizard.cv.CVResource;
import se.david.cv.dropwizard.cv.healthchecks.CVHealthCheck;

public class DropwizardApplication extends Application<DropwizardConfiguration> {
    public static void main(String[] args) throws Exception {
        new DropwizardApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<DropwizardConfiguration> bootstrap) {
    }

    public void run(DropwizardConfiguration dropwizardConfiguration, Environment environment) throws Exception {
        registerResource(environment, new CVResource(), new CVHealthCheck(), "CV");
    }

    private void registerResource(Environment environment, final Resource resource, final HealthCheck healthCheck, final String name) {
        environment.healthChecks().register(name, healthCheck);
        environment.jersey().register(resource);
    }
}
