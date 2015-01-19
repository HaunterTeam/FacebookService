package project;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class App
{
    public static void main(String[] args) throws IllegalArgumentException, IOException, URISyntaxException
    {    	
    	String protocol = Settings.BASE_PROTOCOL;
        String port = ":" + Settings.BASE_PORT;
        String hostname = InetAddress.getLocalHost().getHostAddress();
        String path = Settings.SERVICE_PATH;
        if (hostname.equals(Settings.BASE_URL))
        {
            hostname = "localhost";
        }

        URI baseUrl = new URI(protocol + hostname + port + path);
        System.out.println("Starting sdelab standalone HTTP server..");
        JdkHttpServerFactory.createHttpServer(baseUrl, createApp());
        System.out.println("server starts on " + baseUrl + "\n [kill the process to exit]");
    }

    public static ResourceConfig createApp() {
    	System.out.println("Starting SDE assignment REST services..");
        return new MyApplicationConfig();
    }
}