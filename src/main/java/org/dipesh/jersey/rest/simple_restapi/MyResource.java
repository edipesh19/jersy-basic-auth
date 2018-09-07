package org.dipesh.jersey.rest.simple_restapi;

//import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*import org.dipesh.jersey.rest.simple_restapi.model.User;
import org.dipesh.jersey.rest.simple_restapi.resource.UserResource;*/

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        return "Got it!";
    }
	
	/*public static void main(String[] args) {
		UserResource ur = new UserResource();
		
		List<User> users = ur.getAll();
		for(User u : users) {
			System.out.println(u);
		}
	}*/
}
