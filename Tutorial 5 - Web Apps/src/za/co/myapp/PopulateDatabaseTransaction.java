package za.co.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PopulateDatabaseTransaction {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            String workingDirectory = System.getProperty("user.dir");
            conn = DriverManager.getConnection("jdbc:h2:" + workingDirectory+ "/db/db", "sa", "");
            conn.setAutoCommit(false);
            
            stmt = conn.prepareStatement("INSERT INTO Client (idnumber, name, surname, age, smoker) VALUES (?, ?, ?, ?, ?)");
                        
            stmt.setString(1, "42362772341");
            stmt.setString(2, "Allie ");
            stmt.setString(3, "Gator");
            stmt.setInt(4, 18);
            stmt.setBoolean(5, true);
            stmt.executeUpdate();
            
            stmt.setString(1, "27345345632");
            stmt.setString(2, "Barry");
            stmt.setString(3, "Kade");
            stmt.setInt(4, 57);
            stmt.setBoolean(5, false);
            stmt.executeUpdate();

//            conn.rollback();
//            System.out.println("Rolled back");

            conn.commit();            
            System.out.println("Commited");
            
            conn.setAutoCommit(true);
            stmt.close();
            conn.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

    }
}
