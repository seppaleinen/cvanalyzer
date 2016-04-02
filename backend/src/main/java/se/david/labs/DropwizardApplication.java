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
        String command = "server";
        String configuration = DropwizardApplication.class.getResource("cv.yml") != null ?
            DropwizardApplication.class.getResource("cv.yml").getPath() : null;

        if(args.length > 0) {
            command = args[0];
        } if(args.length > 1) {
            configuration = args[1];
        }

        new DropwizardApplication().run(command, configuration);
    }

    @Override
    public void initialize(Bootstrap<DropwizardConfiguration> bootstrap) {
    }

    public void run(DropwizardConfiguration dropwizardConfiguration, Environment environment) throws Exception {
        registerResource(environment, new HelloWorldResource(), new HelloWorldHealthCheck(), "helloWorld");
        registerResource(environment, new CVResource(), new CVHealthCheck(), "CV");
    }

    private void registerResource(Environment environment, final Resource resource, final HealthCheck healthCheck, final String name) {
        environment.healthChecks().register(name, healthCheck);
        environment.jersey().register(resource);
    }
}
