package za.co.myapp.web.resource;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import za.co.myapp.data.ClientRepository;
import za.co.myapp.data.InMemoryClientRepository;
import za.co.myapp.domain.client.Client;
import za.co.myapp.domain.exception.ClientCreationException;
import za.co.myapp.domain.exception.ClientNotFoundException;
import za.co.myapp.domain.exception.ValidationException;

@Path("/clients")
public class ClientResource {
    
    //ClientRepository clientRepository = new InMemoryClientRepository();
    ClientRepository clientRepository = InMemoryClientRepository.getInstance();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> getAllClients() {
        return clientRepository.getClients();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Client getClient(@PathParam("id") int personId) throws ClientNotFoundException {
        return clientRepository.getClientById(personId);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Client addPerson(Client client) throws ValidationException, ClientCreationException {
        return clientRepository.createClient(client);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON) 
    public void removePerson(@PathParam("id") int personId) throws ClientNotFoundException {
        Client client = clientRepository.getClientById(personId);
        clientRepository.removeClient(client);
    }
    

}
