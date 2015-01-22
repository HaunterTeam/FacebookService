package project.resources;

import getfacebookinfo.FacebookService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/auth")
public class FacebookRes {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON})
	public String getUserToken(@QueryParam("token") String token) {
		
		// FacebookService service is called
        FacebookService fs = new FacebookService();
        return fs.getInfoByToken(token).toString();
	}
}