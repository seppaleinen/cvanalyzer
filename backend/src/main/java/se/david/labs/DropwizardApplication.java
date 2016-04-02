package se.david.labs;

import com.codahale.metrics.health.HealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import se.david.labs.cv.CVResource;
import se.david.labs.cv.healthchecks.CVHealthCheck;
import se.david.labs.helloworld.HelloWorldResource;
import se.david.labs.helloworld.healthchecks.HelloWorldHealthCheck;

public class DropwizardApplication extends Application<DropwizardConfiguration> {
    public static void main(String[] args) throws Exception {
        new DropwizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "cv";
    }

    @Override
    public void initialize(Bootstrap<DropwizardConfiguration> bootstrap) {

    }

    public void run(DropwizardConfiguration dropwizardConfiguration, Environment environment) throws Exception {
        registerResource(environment, new HelloWorldResource(), new HelloWorldHealthCheck(), "helloWorld");
        registerResource(environment, new CVResource(), new CVHealthCheck(), "CV");
    }

    private void registerResource(Environment environment, final Resource resource, final HealthCheck healthCheck, final String name) {
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }
}
