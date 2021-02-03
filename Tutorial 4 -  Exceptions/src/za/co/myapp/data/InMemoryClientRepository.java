package za.co.myapp.data;

import za.co.myapp.domain.client.Client;
import za.co.myapp.domain.policy.DisabilityPolicy;
import za.co.myapp.domain.policy.LifePolicy;
import za.co.myapp.domain.policy.PolicyBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import za.co.myapp.domain.exception.ClientCreationException;
import za.co.myapp.domain.exception.ValidationException;

public class InMemoryClientRepository implements ClientRepository {

    List<Client> clientList;


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
        return new Client("1234562344",
                "Monty",
                "Carlo",
                65, 
                true);
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
        return new Client("1234562344",
                "Ty",
                "Tanic",
                24,
                false
        );
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeClient(Client client) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Client getClientByIdNumber(String idNumber) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
