import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
     // JDBC URL: points to  database
    private static final String URL = "jdbc:mysql://localhost:3306/EmployeeDB";

    // Database credentials
    private static final String USER = "root";          
    private static final String PASSWORD = "Kerbalspaceprogram@11";      

    // Method to get a connection object
    public static Connection getConnection() throws SQLException {
        // DriverManager manages JDBC drivers and connections
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
