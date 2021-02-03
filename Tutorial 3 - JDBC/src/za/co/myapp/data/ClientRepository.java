package za.co.myapp.data;

import za.co.myapp.domain.client.Client;

import java.util.List;

public interface ClientRepository {
    List<Client> getClients();
}
