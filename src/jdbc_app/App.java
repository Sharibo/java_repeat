package jdbc_app;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

public class App {
    public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/?user=root&password=root&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    public static void main(String[] args) {

        

        Enumeration<Driver> drivers = DriverManager.getDrivers();

        while (drivers.hasMoreElements()) {
            System.out.println(drivers.nextElement());
        }

        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL driver not found!");
            return;
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
        } catch (SQLException e) {
            System.out.println("Cannot open connection! " + e.getMessage());
            return;
        }

        
            try {
                Statement st = connection.createStatement();
                // st.executeUpdate("DROP DATABASE db");
                // st.executeUpdate("CREATE DATABASE IF NOT EXISTS db");
                st.executeUpdate("USE db");
                // st.executeUpdate("DROP TABLE persons");
                // st.executeUpdate("CREATE TABLE persons (name varchar(32),age int(3))");
                // st.executeUpdate("INSERT INTO persons (name,age) VALUES ('Eugen',16)");
                // st.executeUpdate("INSERT INTO persons (name,age) VALUES ('Valera',32)");
                // st.executeUpdate("INSERT INTO persons (name,age) VALUES ('Aliaksei',16)");
                // st.executeUpdate("INSERT INTO persons (name,age) VALUES ('Misha',25)");
                
                ResultSet rs = st.executeQuery("SELECT * FROM persons WHERE age=16 ORDER BY name");
                while (rs.next()) {
                    System.out.println( rs.getString("name") + " - " + rs.getString("age") );
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

    }

}
