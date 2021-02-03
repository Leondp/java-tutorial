package za.co.myapp.web;

import org.codehaus.jackson.map.ObjectMapper;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import za.co.myapp.data.ClientRepository;
import za.co.myapp.data.InMemoryClientRepository;
import za.co.myapp.domain.client.Client;
import za.co.myapp.domain.exception.ClientNotFoundException;


@WebServlet({"/client", "/client/*"})
public class ClientServlet  extends HttpServlet {

    private ClientRepository clientRepository;

    public ClientServlet() {
        super();
        clientRepository = new InMemoryClientRepository();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer requestURL = request.getRequestURL();
        ObjectMapper objectMapper = new ObjectMapper();

        if (requestURL.toString().endsWith("client/html")) {
                request.getRequestDispatcher("/client.jsp").forward(request,response);
        }
        else if (requestURL.toString().endsWith("client") || requestURL.toString().endsWith("client/")) {
                String clientString = objectMapper.writeValueAsString(clientRepository.getClients());
                response.setContentType("application/json");
                response.getWriter().print(clientString);     
        }
        else {
            try {
                String id = requestURL.substring(requestURL.indexOf("/client/") + 8);
                Client client = clientRepository.getClientById(Integer.valueOf(id));

                String clientString = objectMapper.writeValueAsString(client);
                response.setContentType("application/json");
                response.getWriter().print(clientString);                
            } catch (ClientNotFoundException ex) {
                response.setStatus(404);
                response.setContentType("application/json");
                response.getWriter().print(ex.getMessage());                
            }
        }
    }
    
}
