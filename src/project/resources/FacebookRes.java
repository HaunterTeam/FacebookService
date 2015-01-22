package project.resources;


import beans.ErrorRaise;
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
	
//	@GET
//	@Produces({"application/javascript"})
//	public String getFacebookProfile(@QueryParam("token") String token,
//			@QueryParam("callback") String callback) 
//			throws MalformedURLException, JSONException, IOException {
//            
//            FacebookService fs = new FacebookService();
//            return callback + "(" + fs.authenticateUser(token) + ")";
//	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON})
	public String getUserToken(@QueryParam("token") String token)
			throws MalformedURLException, JSONException, IOException {
		
            FacebookService fs = new FacebookService();
            JSONObject a = new JSONObject();
            ErrorRaise err = null;
            try {
                JSONObject obj = fs.getInfoByToken(token);
                a = obj;
                err = new ErrorRaise(ErrorRaise.GOOD_REQ,ErrorRaise.GOOD_MESSAGE );
                JSONObject es = new JSONObject(err);
                a.put("status", es);
            } catch (Exception e) {
                e.printStackTrace();
                err = new ErrorRaise(ErrorRaise.BAD_REQ,ErrorRaise.BAD_MESSAGE);
                JSONObject es = new JSONObject(err);
                a.put("status", es);
            }
                
		return a.toString();
	}
}