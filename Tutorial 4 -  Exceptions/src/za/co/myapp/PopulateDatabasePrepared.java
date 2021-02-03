package za.co.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PopulateDatabasePrepared {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try
        {
            Class.forName("org.h2.Driver");
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println(ex.toString());
        }
        
        try {
            String workingDirectory = System.getProperty("user.dir");
            conn = DriverManager.getConnection("jdbc:h2:" + workingDirectory+ "/db/db", "sa", "");

            stmt = conn.prepareStatement("INSERT INTO Client (idnumber, name, surname, age, smoker) VALUES (?, ?, ?, ?, ?)");
            
            stmt.setString(1, "62362372346");
            stmt.setString(2, "Sam");
            stmt.setString(3, "Sandwitch");
            stmt.setInt(4, 33);
            stmt.setBoolean(5, true);
            stmt.executeUpdate();
            
            stmt.setString(1, "37345345634");
            stmt.setString(2, "Max");
            stmt.setString(3, "Maddison");
            stmt.setInt(4, 96);
            stmt.setBoolean(5, false);
            stmt.executeUpdate();

            stmt.close();
            conn.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

    }
}
