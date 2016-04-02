package se.david.labs;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
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
        final HelloWorldResource helloWorldResource = new HelloWorldResource();
        final HelloWorldHealthCheck helloWorldHealthCheck = new HelloWorldHealthCheck();
        environment.healthChecks().register("template", helloWorldHealthCheck);
        environment.jersey().register(helloWorldResource);
    }
}
