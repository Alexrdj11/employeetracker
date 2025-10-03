import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProjectDAO {

    // Adds a new project (auto-creates table if it doesn't exist)
    public void addProject(String name, String startDate, int empId) throws SQLException {
        // SQL creates table if it doesn't exist
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Project ("
                + "proj_id INT PRIMARY KEY AUTO_INCREMENT, "
                + "proj_name VARCHAR(50) NOT NULL, "
                + "start_date DATE, "
                + "emp_id INT, "
                + "FOREIGN KEY (emp_id) REFERENCES Employee(emp_id) ON DELETE CASCADE"
                + ")";

        // SQL inserts project
        String insertSQL = "INSERT INTO Project(proj_name, start_date, emp_id) VALUES(?, ?, ?)";

        // try-with-resources to auto-close connection/statements
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            // Creates table first (safe even if already exists)
            stmt.executeUpdate(createTableSQL);

            // Set parameters for insert
            pstmt.setString(1, name);                   
            pstmt.setDate(2, Date.valueOf(startDate));
            pstmt.setInt(3, empId);

            // Executes insert
            pstmt.executeUpdate();
            System.out.println("Project added successfully!");
        }
    }

    // Retrieves and displays all projects with employee names
    public void getProjects() throws SQLException {
        String sql = "SELECT p.proj_id, p.proj_name, p.start_date, e.emp_name "
                   + "FROM Project p JOIN Employee e ON p.emp_id = e.emp_id";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Proj_ID | Proj_Name | Start_Date | Assigned_To");
            System.out.println("-----------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("proj_id");
                String name = rs.getString("proj_name");
                Date date = rs.getDate("start_date");
                String empName = rs.getString("emp_name");

                System.out.println(id + " | " + name + " | " + date + " | " + empName);
            }
        }
    }
}
