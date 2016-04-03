package se.david.cv.dropwizard.cv;

import com.codahale.metrics.annotation.Timed;
import se.david.cv.dropwizard.Resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cv")
@Produces(MediaType.APPLICATION_JSON)
public class CVResource implements Resource {
    @GET
    @Timed
    @Path("/ping")
    public String ping() {
        return "pong";
    }
}
