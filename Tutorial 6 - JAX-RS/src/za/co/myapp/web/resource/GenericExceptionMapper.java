package za.co.myapp.web.resource;

import javax.ws.rs.core.*;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.logging.Logger;
import za.co.myapp.domain.exception.ClientNotFoundException;
import za.co.myapp.domain.exception.ValidationException;

public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    private static final Logger LOGGER = Logger.getLogger( GenericExceptionMapper.class.getName() );

    @Context
    private Request request;


    @Override
    public Response toResponse( Throwable exception ) {

        ExceptionTo to = new ExceptionTo();
        Response.ResponseBuilder builder;
        
        if ( exception instanceof ClientNotFoundException ) {
            
            to.setMessage( exception.getMessage() );
            to.setType( "entity" );
            builder = Response.status( 404 ).entity( to );
            
        } else if ( exception instanceof ValidationException ) {
            
            to.setMessage( exception.getMessage() );
            to.setType( "validation" );
            builder = Response.status( 422 ).entity( to );
                    
        } else {
            to.setMessage( exception.getMessage() );
            to.setType( "error" );
            builder = Response.status( 500 ).entity( to );
        }            
        
        builder.type( MediaType.APPLICATION_JSON );
        return builder.build();   

    }

}
