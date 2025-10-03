import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDAO {

    // Adds a new employee (auto-creates table if it doesn't exist)
    public void addEmployee(String name, String role) throws SQLException {
        //  SQL to create table if it doesn't exist
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Employee ("
                + "emp_id INT PRIMARY KEY AUTO_INCREMENT, "
                + "emp_name VARCHAR(50) NOT NULL, "
                + "emp_role VARCHAR(50) NOT NULL"
                + ")";

        //  SQL to insert employee
        String insertSQL = "INSERT INTO Employee(emp_name, emp_role) VALUES(?, ?)";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();   // for table creation
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            // Create table first
            stmt.executeUpdate(createTableSQL);

            // Insert employee
            pstmt.setString(1, name);  // emp_name
            pstmt.setString(2, role);  // emp_role
            pstmt.executeUpdate();

            System.out.println("Employee added successfully!");
        }
    }

    // Retrieve and display all employees
    public void getEmployees() throws SQLException {
        String sql = "SELECT * FROM Employee";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Emp_ID | Emp_Name | Emp_Role");
            System.out.println("-----------------------------");

            while (rs.next()) {
                int id = rs.getInt("emp_id");
                String name = rs.getString("emp_name");
                String role = rs.getString("emp_role");
                System.out.println(id + " | " + name + " | " + role);
            }
        }
    }
}
