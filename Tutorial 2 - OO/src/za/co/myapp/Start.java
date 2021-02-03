package za.co.myapp;

import java.util.Iterator;
import za.co.myapp.data.ClientRepository;
import za.co.myapp.data.InMemoryClientRepository;
import za.co.myapp.domain.client.Client;

import java.util.List;

public class Start {

    public static void main(String[] args) {
        ClientRepository clientRepository = new InMemoryClientRepository();
        List<Client> clients = clientRepository.getClients();

        for (Client client : clients) {
            System.out.println(client);
        }
      
    }
    
    private void loop(List<Client> clients) {
        
        //Method 1 - Classic for loop
        for (int i = 0; i < clients.size(); i++) {
            System.out.println(clients.get(i));
        }

        //Method 2 - Runs on Collecion Interface
        for (Client client : clients) {
            System.out.println(client);
        
        }

        //Method 3 - forEach with arrow function (lambda)
        clients.forEach(client -> {
            System.out.println(client);
        });
        
        //Method 4 - forEach lambda method reference
        clients.forEach(System.out::println);

        
        //Method 5 - Classic For loop with Iterator
        for (Iterator<Client> it = clients.iterator(); it.hasNext();) {
            Client client = it.next();
            System.out.println(client);
        }

        //Method 6 -  while loop
        int i = 0;
        while(i < clients.size()){  
            System.out.println(clients.get(i));  
            i++;  
        }  
        
        //Method 7 -  do while loop
        i = 0;  
        do {  
            System.out.println(clients.get(i));  
            i++;  
        } while(i < clients.size()); 

        
        //Method 8 - Iterator with While loop
        Iterator<Client> it = clients.iterator();
        while (it.hasNext()) {
            Client client = it.next();
            System.out.println(client);
        }        
        
    }
    
    
}
