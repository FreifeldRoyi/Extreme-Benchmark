package org.freifeld.extremebenchmark.boundary;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/tests")
public class TestResources {

    @Inject
    private Client httpClient;

    @GET
    @Path("/test-1-simple")
    @Produces(MediaType.APPLICATION_JSON)
    public String simpleString() {
        return "Hello World!";
    }

    @GET
    @Path("/test-2-site-fetch")
    @Produces(MediaType.TEXT_HTML)
    public Response fetchSite() {
        WebTarget target = this.httpClient.target("https://www.google.com");
        Invocation.Builder request = target.request();
        Response response = request.get();
        return response;
    }

}
