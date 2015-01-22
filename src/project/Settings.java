package project;

public final class Settings {

	//	Server Settings
	public static final String BASE_PROTOCOL = "http://";
	public static final String BASE_URL = "localhost";
	public static final String BASE_PORT = "8020";
	public static final String SERVICE_PATH = "/project-facebook/";
	
	// Requests Settings
	public static final String REQ_TYPE = "GET";
	
	// Facebook url
	public static final String FB_BASE_URL = "https://graph.facebook.com/";
    public static final String FB_API_VERSION = "v2.2";
    public static final String FB_QUERY_INFO = "/me?fields=id,first_name,location&access_token=";
    public static final String FB_QUERY_PHOTO = "/me/picture?type=normal&height=120&width=120&redirect=false&fields=url&access_token=";
    
    // JSON Input Settings
    public static final String FB_JSON_IN_DATA_OBJ = "data";
    public static final String FB_JSON_IN_ID_ATTR = "id";
    public static final String FB_JSON_IN_NAME_ATTR = "first_name";
    public static final String FB_JSON_IN_LOCATION_OBJ = "location";
    public static final String FB_JSON_IN_LOCATION_ATTR = "name";
    public static final String FB_JSON_IN_IMAGE_URL_ATTR = "url";
    
    // JSON Ouput Settings
    public static final String FB_JSON_OUT_ID_ATTR = "id";
    public static final String FB_JSON_OUT_NAME_ATTR = "first_name";
    public static final String FB_JSON_OUT_LOCATION_ATTR = "location";
    public static final String FB_JSON_OUT_STATUS_OBJ = "status";
    public static final String FB_JSON_OUT_STATUS_CODE_ATTR = "code";
    public static final String FB_JSON_OUT_STATUS_MESSAGE_ATTR = "message";
    
    public final static int FB_OK_REQ = 200;
    public final static int FB_ERR_REQ = 1;
    public final static String FB_OK_MESSAGE = "Valid Request";
    public final static String FB_ERR_MESSAGE = "Invalid OAuth access token";
}