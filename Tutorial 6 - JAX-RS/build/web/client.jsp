<%-- 
    Document   : person.jsp
    Created on : 19 Mar 2019, 3:58:06 PM
    Author     : leon
--%>

<%@page import="za.co.myapp.domain.client.Client"%>
<%@page import="za.co.myapp.data.InMemoryClientRepository"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client Page</title>
    </head>
    <style>
table {
  border-collapse: collapse;
  border-radius: 1em;
  overflow: hidden;
  margin-left:auto; 
  margin-right:auto;
  margin-top:40px;
}

th {
    background-color: #34495e;
    color:#fff;
    text-transform: uppercase;
}
td {
    background-color: #3498db;
    color:#fff;    
}
th, td {
    padding: 1em;
    border-bottom: 2px solid white; 
}

.css-mine {
    margin-top: 2em;
    clear: both;
}

body {
    /*margin: 1.5em;*/
    font-family: Helvetica;
}
</style>
    <body>
        <div>
            
            <h1 style="text-align:center;margin-top:50px;">Welcome to the Java Training</h1>
            
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Age</th>
                        <th>Premium</th>
                    </tr>
                </thead>
                <tbody>
<%
    InMemoryClientRepository repository = new InMemoryClientRepository();
    List<Client> clientList = repository.getClients();
    for (Client client : clientList) {
 %>
                <tr>       
                   <td><%=client.getId()%></td>
                   <td><%=client.getName()%></td>
                   <td><%=client.getSurname()%></td>
                   <td><%=client.getAge()%></td>
                   <td>R <%=client.getPremium()%></td>
                </tr>
 <%
    }
 %>
            </tbody>
        </table>   
        </div>
    </body>
</html>
