package za.co.myapp.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.co.myapp.domain.client.Client;
import za.co.myapp.domain.exception.ClientCreationException;
import za.co.myapp.domain.exception.ValidationException;
import za.co.myapp.domain.policy.LifePolicy;
import za.co.myapp.domain.policy.PolicyBuilder;

public class DatabaseClientRepository extends InMemoryClientRepository {

    private final static Logger LOGGER = Logger.getLogger(DatabaseClientRepository.class.getName());
    
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
    
    @Override
    public Client createClient(Client client) throws ClientCreationException, ValidationException {
        PreparedStatement stmt = null;

        validateClient(client);
        
        try {
            stmt = this.conn.prepareStatement("INSERT INTO Client (idnumber, name, surname, age, smoker) VALUES (?, ?, ?, ?, ?)", new String[] {"ID"});
            
            stmt.setString(1, client.getIdNumber());
            stmt.setString(2, client.getName());
            stmt.setString(3, client.getSurname());
            stmt.setInt(4, client.getAge());
            stmt.setBoolean(5, client.isSmoking());
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
            {
                client.setId(rs.getInt(1));
            }

            stmt.close();
            LOGGER.log(Level.INFO, "Could insert client.");
        } catch(SQLException ex) {
            LOGGER.log(Level.SEVERE, "statement could not be closed.", ex);
            throw new ClientCreationException("Unable to create client in database.", ex);
        } 
        
        return client;
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

    @Override
    public void removeClient(Client client) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Client getClientByIdNumber(String idNumber) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
