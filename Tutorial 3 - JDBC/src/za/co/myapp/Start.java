package za.co.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import za.co.myapp.data.ClientRepository;
import za.co.myapp.domain.client.Client;

import java.util.List;
import za.co.myapp.data.DatabaseClientRepository;

public class Start {

    private Connection conn;
    
    public static void main(String[] args) {
        
        Connection conn = null;
        try {
            String workingDirectory = System.getProperty("user.dir");
            conn = DriverManager.getConnection("jdbc:h2:" + workingDirectory + "/db/db", "sa", "");

            Start start = new Start(conn);
            start.showClients();
        } catch (Exception ex) {
            System.out.println("Sorry, some error occured - " + ex.getMessage());
            ex.printStackTrace();
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                }
                catch (SQLException ex) {
                    System.out.println("Could not close database connection - " + ex.getMessage());
                    ex.printStackTrace();                    
                }
            }
        }
        
    }
    
    public Start(Connection conn) throws Exception {
        this.conn = conn;
    }
    
    public void showClients() {
//        ClientRepository clientRepository = new InMemoryClientRepository();
        ClientRepository clientRepository = new DatabaseClientRepository(this.getConnection());
        
        List<Client> clients = clientRepository.getClients();
        
        for (Client client : clients) {
            System.out.println(client);
        }

    }
    
    private Connection getConnection() {
        return this.conn;
    }
    
}
