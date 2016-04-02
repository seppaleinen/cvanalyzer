package se.david.labs.helloworld;

import com.codahale.metrics.annotation.Timed;
import se.david.labs.helloworld.domain.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") String name) {
        return new Saying(name);
    }
}