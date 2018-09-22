package org.freifeld.extremebenchmark.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Path("/tests")
public class TestResources {

    @Inject
    private Client httpClient;

    @GET
    @Path("/test-1-simple")
    public String fetchSite() {
        WebTarget target = this.httpClient.target("https://www.google.com");
        Invocation.Builder request = target.request();
        Response response = request.get();

        return response.getEntity().toString();
    }

}
