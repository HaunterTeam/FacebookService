package getfacebookinfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import project.Settings;

/**
*
* @author roberto
*/
public class FacebookService {
    
    public FacebookService() { }
    
    public JSONObject getInfoByToken(String token) {
    	
    	// Facebook Request url
    	String url = Settings.FB_BASE_URL + Settings.FB_API_VERSION + Settings.FB_QUERY_INFO + token;
    	
		JSONObject result_json = new JSONObject();
    	JSONObject status_json = new JSONObject();
        
        try {
        	
        	System.out.println("Facebook Request:" + url);
            URL obj = new URL(url);
        	
	        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	        con.setRequestMethod(Settings.REQ_TYPE);
	        
	        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        String inputLine;
	        StringBuilder response = new StringBuilder();
	        while ((inputLine = in.readLine()) != null) {
	                response.append(inputLine);
	        }
	        in.close();
	        
	        // Facebook Response to JSONObject
	        JSONObject fb_json_response = new JSONObject(response.toString());
	        System.out.println("Facebook Response:" + fb_json_response);
	        
	        // Facebook Response is parsed
	        result_json.put(Settings.FB_JSON_OUT_ID_ATTR, fb_json_response.get(Settings.FB_JSON_IN_ID_ATTR));
        	result_json.put(Settings.FB_JSON_OUT_NAME_ATTR, fb_json_response.get(Settings.FB_JSON_IN_NAME_ATTR));
        	result_json.put(Settings.FB_JSON_OUT_LOCATION_ATTR, 
        		(fb_json_response.getJSONObject(Settings.FB_JSON_IN_LOCATION_OBJ)
        				.getString(Settings.FB_JSON_IN_LOCATION_ATTR)));
        	
        	// If everything goes right, code = 200 and message = "Valid Request" 
        	status_json.put(Settings.FB_JSON_OUT_STATUS_CODE_ATTR, Settings.FB_OK_REQ);
        	status_json.put(Settings.FB_JSON_OUT_STATUS_MESSAGE_ATTR, Settings.FB_OK_MESSAGE);
	        
        } catch (IOException io_excep) {
        	
        	System.err.println("Exception raised by IOException, " + io_excep.toString());
        	status_json.put(Settings.FB_JSON_OUT_STATUS_CODE_ATTR, Settings.FB_ERR_REQ);
        	status_json.put(Settings.FB_JSON_OUT_STATUS_MESSAGE_ATTR, Settings.FB_ERR_MESSAGE);
        	
        } catch (JSONException exp) {
        	
        	System.err.println("Exception raised parsing fb_json_response, " + exp.toString());
        	status_json.put(Settings.FB_JSON_OUT_STATUS_CODE_ATTR, Settings.FB_OK_REQ);
        	status_json.put(Settings.FB_JSON_OUT_STATUS_MESSAGE_ATTR, Settings.FB_OK_MESSAGE);

        } finally {
        	
        	result_json.put(Settings.FB_JSON_OUT_STATUS_OBJ, status_json);
        	System.out.println("RESTinFacebookService Response:" + result_json.toString());
        }
        return result_json;
    }
}