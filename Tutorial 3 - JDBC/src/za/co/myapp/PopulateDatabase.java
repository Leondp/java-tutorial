package za.co.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PopulateDatabase {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
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
//            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost" + workingDirectory+ "/db/db", "sa", "");

            stmt = conn.createStatement();

            StringBuilder sbCreateClientTable = new StringBuilder();
            
            sbCreateClientTable.append("CREATE TABLE Client(");
            sbCreateClientTable.append("id int auto_increment primary key,");
            sbCreateClientTable.append("idnumber varchar(20),");
            sbCreateClientTable.append("name varchar(100),");
            sbCreateClientTable.append("surname varchar(100),");
            sbCreateClientTable.append("age tinyint,");
            sbCreateClientTable.append("smoker bit");
            sbCreateClientTable.append(");");
            
            stmt.executeUpdate("DROP table IF EXISTS Client");
            stmt.executeUpdate(sbCreateClientTable.toString());

            stmt.executeUpdate("INSERT INTO Client (idnumber, name, surname, age, smoker) VALUES ('7463784934522', 'Monty', 'Carlo', 65, 1)");
            stmt.executeUpdate("INSERT INTO Client (idnumber, name, surname, age, smoker) VALUES ('7563744934521', 'Ty', 'Tanic', 24, 0)");

            stmt.close();
            conn.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

    }
}
