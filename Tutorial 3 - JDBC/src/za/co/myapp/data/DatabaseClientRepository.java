package za.co.myapp.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import za.co.myapp.domain.client.Client;
import za.co.myapp.domain.policy.LifePolicy;
import za.co.myapp.domain.policy.PolicyBuilder;

public class DatabaseClientRepository extends InMemoryClientRepository {

    Connection conn;
    
    public DatabaseClientRepository(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public List<Client> getClients() {
        List<Client> clients = loadClientsFromDatabase();
        
        for (Client client : clients) {
            if (client.getName().equals("Monty")) {
                client.addPolicy(getMontyLifePolicy(client), getMontyDisabilityPolicy(client));
            } else if (client.getName().equals("Ty"))  {
                client.addPolicy(getTyLifePolicy(client), getTyDisabilityPolicy(client));                
            } else {
                client.addPolicy(getDefaultLifePolicy(client));
            }
        }
        
        return clients;
    }
    
    
    public LifePolicy getDefaultLifePolicy(Client client) {
        return PolicyBuilder.life("Li", ThreadLocalRandom.current().nextInt(1000000, 9999999 + 1))
                .client(client)
                .build();
    }
    
    
    private List<Client> loadClientsFromDatabase() {
        List<Client> clientList = new ArrayList<>();
        Statement stmt;
        try {
            String sql = "SELECT * FROM Client";
            stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                int id = rs.getInt("id");
                String idNumber = rs.getString("idNumber");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                int smoker = rs.getInt("smoker");

                Client client = new Client(idNumber, name, surname, age, smoker == 1 ? true : false);
                clientList.add(client);
            }
            stmt.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return clientList;
       
    }
    
}
