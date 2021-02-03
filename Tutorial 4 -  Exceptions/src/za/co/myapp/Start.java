package za.co.myapp;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import za.co.myapp.data.ClientRepository;
import za.co.myapp.domain.client.Client;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import za.co.myapp.data.DatabaseClientRepository;
import za.co.myapp.domain.exception.ClientCreationException;
import za.co.myapp.domain.exception.ValidationException;

public class Start {

    private static Logger LOGGER = null; 
    private Connection conn;
    
    static {
      InputStream stream = Start.class.getClassLoader().
              getResourceAsStream("logging.properties");
      try {
          LogManager.getLogManager().readConfiguration(stream);
          LOGGER= Logger.getLogger(Start.class.getName());
      } catch (IOException e) {
          e.printStackTrace();
      }
    }
    
    public static void main(String[] args) {
        
        Connection conn = null;
        try {
            String workingDirectory = System.getProperty("user.dir");
            conn = DriverManager.getConnection("jdbc:h2:" + workingDirectory + "/db/db", "sa", "");
            LOGGER.log(Level.INFO, "Connection to database created.");
            Start start = new Start(conn);
            start.showClients();
        } catch (Exception ex) {
            System.out.println("Sorry, some error occured - " + ex.getMessage());
            LOGGER.log(Level.SEVERE, null,ex);
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                }
                catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Could not close database connection", ex);
                }
            }
        }
        
    }
    
    public Start(Connection conn) throws Exception {
        this.conn = conn;
    }
    
    public void showClients()  {
        ClientRepository clientRepository = new DatabaseClientRepository(this.getConnection());

        try {
            // TODO Shorten ID number to under 20 characters.
            Client newClient = clientRepository.createClient(new Client("8768337342346234623462363246432634", "Teri", "Dactyl", 19, false));
            System.out.println("newClient->id:" + newClient.getId());
//            clientRepository.createClient(new Client("", "", "Dactyl", 19, false));
//            clientRepository.createClient(null);
        
            List<Client> clients = clientRepository.getClients();

            for (Client client : clients) {
                System.out.println(client);
            } 
        } catch (ClientCreationException|ValidationException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            ex.printStackTrace();
            LOGGER.log(Level.SEVERE, "Client creation failed", ex);
        }

    }
    
    private Connection getConnection() {
        return this.conn;
    }
    
}
