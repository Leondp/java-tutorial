JDBC Tutorial
=============

Run Java Class to create and populate database with 2 clients:
za.co.myapp.PopulateDatabase

Run the application, it will throw a ValidationException because of the id number on the client that is too long:
za.co.myapp.Start

H2 server:
java -cp libs/h2*.jar org.h2.tools.Server
