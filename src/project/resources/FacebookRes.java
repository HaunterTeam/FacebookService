package project.resources;

import getfacebookinfo.FacebookService;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
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
		
//		System.out.println("here");
//		System.out.println("callback=" + callback);
//		System.out.println("token=" + token);
            
            FacebookService fs = new FacebookService();
//            System.err.println(fs.authenticateUser(token).toString());
            return callback + "(" + fs.authenticateUser(token) + ")";
	}
}