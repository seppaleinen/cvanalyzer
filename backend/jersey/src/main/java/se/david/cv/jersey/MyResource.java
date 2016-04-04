package se.david.cv.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ping")
public class MyResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        return "pong";
    }
}
