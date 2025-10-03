public class Main {
    public static void main(String[] args) {
        try {
            // Create DAO objects
            EmployeeDAO empDao = new EmployeeDAO();
            ProjectDAO projDao = new ProjectDAO();

            //  Add employees
            empDao.addEmployee("harsha", "Developer");
            empDao.addEmployee("varsha", "Manager");

            //  Display employees
            System.out.println("\n--- Employees ---");
            empDao.getEmployees();

            //  Add projects
            projDao.addProject("Banking System", "2025-10-01", 1);
            projDao.addProject("E-commerce App", "2025-10-02", 2);

            //  Display projects
            System.out.println("\n--- Projects ---");
            projDao.getProjects();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
