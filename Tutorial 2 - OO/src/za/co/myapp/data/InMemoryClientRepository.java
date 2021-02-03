package za.co.myapp.data;

import za.co.myapp.domain.client.Client;
import za.co.myapp.domain.policy.DisabilityPolicy;
import za.co.myapp.domain.policy.LifePolicy;
import za.co.myapp.domain.policy.PolicyBuilder;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class InMemoryClientRepository implements ClientRepository {

    @Override
    public List<Client> getClients() {
        Client monty = getMonty();
        monty.addPolicy(getMontyLifePolicy(monty), getMontyDisabilityPolicy(monty));

        Client ty = getTy();
        ty.addPolicy(getTyLifePolicy(ty), getTyDisabilityPolicy(ty));

        return Arrays.asList(monty, ty);
    }


    private Client getMonty() {
        return new Client("1234562344",
                "Monty",
                "Carlo",
                true,
                65);
    }

    public LifePolicy getMontyLifePolicy(Client client) {
        return PolicyBuilder.life("Li", 905743323)
                .client(client)
                .build();
    }

    public DisabilityPolicy getMontyDisabilityPolicy(Client client) {
        return PolicyBuilder.disablity("Di", 405743323)
                .addTheDog()
                .addTheWheelChair()
                .build();
    }

    private Client getTy() {
        return new Client("1234562344",
                "Ty",
                "Tanic",
                false,
                24);
    }

    public LifePolicy getTyLifePolicy(Client client) {
        return PolicyBuilder.life("Li", 79374893)
                .client(client)
                .premiumCalculator(() -> BigDecimal.ZERO) //functional Interface
                .build();
    }

    public DisabilityPolicy getTyDisabilityPolicy(Client client) {
        return PolicyBuilder.disablity("Di", 2662823)
                .build();
    }


}
