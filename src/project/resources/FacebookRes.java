package project.resources;


import getfacebookinfo.FacebookService;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/auth")
public class FacebookRes {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	@GET
	@Produces({"application/javascript"})
	public String getFacebookProfile(@QueryParam("token") String token,
			@QueryParam("callback") String callback) 
			throws MalformedURLException, JSONException, IOException {
            
            FacebookService fs = new FacebookService();
            return callback + "(" + fs.authenticateUser(token) + ")";
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON})
	public JSONObject getUserToken(@QueryParam("token") String token)
			throws MalformedURLException, JSONException, IOException {
		
		FacebookService fs = new FacebookService();
		return fs.getInfoByToken(token);
	}
}