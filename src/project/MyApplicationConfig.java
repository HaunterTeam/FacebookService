package project;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("project")
public class MyApplicationConfig extends ResourceConfig {
    public MyApplicationConfig () {
        packages("project");
    }
}