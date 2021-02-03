package za.co.myapp.data;

import za.co.myapp.domain.client.Client;

import java.util.List;
import za.co.myapp.domain.exception.ClientCreationException;
import za.co.myapp.domain.exception.ValidationException;

public interface ClientRepository {
    List<Client> getClients();
    Client createClient(Client client) throws ClientCreationException, ValidationException;
    void removeClient(Client client);
    Client getClientByIdNumber(String idNumber);
}
