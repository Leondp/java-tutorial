package za.co.myapp.data;

import za.co.myapp.domain.client.Client;
import za.co.myapp.domain.policy.DisabilityPolicy;
import za.co.myapp.domain.policy.LifePolicy;
import za.co.myapp.domain.policy.PolicyBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import za.co.myapp.domain.exception.ClientCreationException;
import za.co.myapp.domain.exception.ClientNotFoundException;
import za.co.myapp.domain.exception.ValidationException;

public class InMemoryClientRepository implements ClientRepository {


    private static InMemoryClientRepository single_instance = null;
    
    List<Client> clientList;


    public static InMemoryClientRepository getInstance() 
    { 
        if (single_instance == null) {
            single_instance = new InMemoryClientRepository(); 
        }
        return single_instance; 
    } 
    
    public InMemoryClientRepository() {
        clientList = new ArrayList<>();
        Client monty = getMonty();
        monty.addPolicy(getMontyLifePolicy(monty), getMontyDisabilityPolicy(monty));
        clientList.add(monty);
        
        Client ty = getTy();
        ty.addPolicy(getTyLifePolicy(ty), getTyDisabilityPolicy(ty));
        clientList.add(ty);
        
    }
    
    @Override
    public List<Client> getClients() {
        return this.clientList;
    }


    private Client getMonty() {
        Client client = new Client("1234562344",
                "Monty",
                "Carlo",
                65, 
                true);
        client.setId(1);
        return client;
    }

    public LifePolicy getMontyLifePolicy(Client client) {
        return PolicyBuilder.life("Li", 9057423)
                .client(client)
                .build();
    }

    public DisabilityPolicy getMontyDisabilityPolicy(Client client) {
        return PolicyBuilder.disablity("Di", 4057333)
                .addTheDog()
                .addTheWheelChair()
                .build();
    }

    private Client getTy() {
        Client client = new Client("1234562344",
                "Ty",
                "Tanic",
                24,
                false
        );
        client.setId(2);
        return client;

    }

    public LifePolicy getTyLifePolicy(Client client) {
        return PolicyBuilder.life("Li", 7937493)
                .client(client)
                .premiumCalculator(() -> BigDecimal.ZERO) //functional Interface
                .build();
    }

    public DisabilityPolicy getTyDisabilityPolicy(Client client) {
        return PolicyBuilder.disablity("Di", 2662823)
                .build();
    }

    @Override
    public Client createClient(Client client) throws ClientCreationException, ValidationException {
        validateClient(client);
        client.setId(clientList.size()+2);
        clientList.add(client);
        return client;
    }

    @Override
    public void removeClient(Client client) {
        Iterator<Client> i = clientList.iterator();
        while (i.hasNext()) {
            Client item = i.next();
            if (item.getId() == client.getId()) {
                i.remove();
            }
        }
    }

    @Override
    public Client getClientByIdNumber(String idNumber) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Client getClientById(int id) throws ClientNotFoundException{
        for (Client client : getClients()) {
            if (client.getId() == id) {
                return client;
            }
        }
        throw new ClientNotFoundException("Client with id:" + id + " not found.");
    }


    private void validateClient(Client client) throws ValidationException {
        
        ValidationException validationException = new ValidationException();
        
        if (client == null) {            
            validationException.addError("Client cannot be null");
            throw validationException;
        }
        
        if ("".equals(client.getIdNumber())) {
            validationException.addError("Client's id number cannot be blank");
        }
        
        if ("".equals(client.getName())) {
            validationException.addError("Client's name cannot be blank");
        }
        
        if ("".equals(client.getSurname())) {
            validationException.addError("Client's surname cannot be blank");
        }
        
        if (client.getAge() == 0) {
            validationException.addError("Client's age cannot be blank");
        }
        
        if (validationException.hasErrors()) throw validationException; 
    }
}
