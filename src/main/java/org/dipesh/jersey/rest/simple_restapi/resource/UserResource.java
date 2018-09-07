package org.dipesh.jersey.rest.simple_restapi.resource;

import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dipesh.jersey.rest.simple_restapi.dao.GenericDao;
import org.dipesh.jersey.rest.simple_restapi.dao.UserDao;
import org.dipesh.jersey.rest.simple_restapi.model.User;


@Path("secured")
public class UserResource {
	
	private GenericDao<User> dao = UserDao.getInstance();
	
	 /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("user")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll() {
    	return dao.getAll();
    }
    
}
