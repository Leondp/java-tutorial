package za.co.myapp.web.resource;

import org.glassfish.jersey.server.ResourceConfig;



import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(ClientResource.class);
        register(GenericExceptionMapper.class);
    }

}
