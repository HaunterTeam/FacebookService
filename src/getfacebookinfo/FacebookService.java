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
    
    public JSONObject authenticateUser(String token) throws MalformedURLException, JSONException, IOException {
    	JSONObject facebook_result = new JSONObject();
    	facebook_result.put(Settings.FB_JSON_OUT_INFO_OBJ, getInfoByToken(token));
    	return facebook_result;
    }
    
    public JSONObject getInfoByToken(String token) throws MalformedURLException, IOException, JSONException {
    	
    	String url = Settings.FB_BASE_URL + Settings.FB_API_VERSION + Settings.FB_QUERY_INFO + token;
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
        
        JSONObject json_in = new JSONObject(response.toString());
        
        JSONObject json_out = new JSONObject();
        json_out.put(Settings.FB_JSON_OUT_ID_ATTR, json_in.get(Settings.FB_JSON_IN_ID_ATTR));
        json_out.put(Settings.FB_JSON_OUT_NAME_ATTR, json_in.get(Settings.FB_JSON_IN_NAME_ATTR));
        json_out.put(Settings.FB_JSON_OUT_LOCATION_ATTR, 
        		(json_in.getJSONObject(Settings.FB_JSON_IN_LOCATION_OBJ)
        				.getString(Settings.FB_JSON_IN_LOCATION_ATTR)));
        
        System.err.println(json_out);
        return json_out;
    }
    
//    public JSONObject getProfileImageByToken(String token) throws MalformedURLException, IOException, JSONException {
//    	
//    	String url = Settings.FB_BASE_URL + Settings.FB_API_VERSION + Settings.FB_QUERY_PHOTO + token;
//    	
//    	URL obj = new URL(url);
//        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//
//        con.setRequestMethod(Settings.REQ_TYPE);
//        
//        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        StringBuilder response = new StringBuilder();
//
//        while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//        }
//        in.close();
//        
//        JSONObject jo = new JSONObject(response.toString());
//        JSONObject data = jo.getJSONObject(Settings.FB_JSON_IN_DATA_OBJ);
//        
//        JSONObject o = new JSONObject();
//        o.put(Settings.FB_JSON_OUT_IMAGE_OBJ, data.getString(Settings.FB_JSON_IN_IMAGE_URL_ATTR));
//        
//        System.err.println(o.toString());
//        return o;
//    }
}