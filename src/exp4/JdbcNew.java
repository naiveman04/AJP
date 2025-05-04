package exp4;

import java.sql.*;
import java.util.Scanner;

class InputHandler {

    public Scanner scanner;

    InputHandler() {
        scanner = new Scanner(System.in);
    }

    // Method to get student details for adding a student
    public String[] getStudentDetails() {
        System.out.println("Enter Roll No:");
        String rollNo = scanner.nextLine();
        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Department Name:");
        String deptName = scanner.nextLine();
        return new String[]{rollNo, name, deptName};
    }

    // Method to get roll number for updating, deleting, or searching a student
    public String getRollNo() {
        System.out.println("Enter Roll No:");
        return scanner.nextLine();
    }

    // Method to get updated student details
    public String[] getUpdatedStudentDetails() {
        System.out.println("Enter New Name:");
        String name = scanner.nextLine();
        System.out.println("Enter New Department Name:");
        String deptName = scanner.nextLine();
        return new String[]{name, deptName};
    }
}

public class JdbcNew {

    private Connection con;
    private InputHandler inputHandler;

    public JdbcNew() throws Exception {
        // Load and register the driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the connection
        String url = "jdbc:mysql://localhost:3306/student1";
        String uName = "root";
        String password = "vedant632952#";
        con = DriverManager.getConnection(url, uName, password);
        System.out.println("Connection established successfully.");

        // Initialize InputHandler
        inputHandler = new InputHandler();
    }

    public static void main(String[] args) throws Exception {
        JdbcNew jdbc = new JdbcNew();
        jdbc.showMenu();
    }

    public void showMenu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu");
            System.out.println("1. Create Table");
            System.out.println("2. Add Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Fetch Data");
            System.out.println("6. Search Data");
            System.out.println("7. Close Connection");
            System.out.println("0. Exit");
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            System.out.println("");

            switch (choice) {
                case 1:
                    createTable();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    fetchData();
                    break;
                case 6:
                    searchData();
                    break;
                case 7:
                    closeConnection();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

    }

    public void createTable() throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS StudentInfo (roll_no INT PRIMARY KEY, name VARCHAR(50), dept_name VARCHAR(50))";
        Statement st = con.createStatement();
        st.executeUpdate(query);
        System.out.println("Table created successfully.");
    }

    public void addStudent() throws SQLException {
        String[] details = inputHandler.getStudentDetails();
        String query = "INSERT INTO StudentInfo (roll_no, name, dept_name) VALUES (?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, Integer.parseInt(details[0]));
        pst.setString(2, details[1]);
        pst.setString(3, details[2]);
        pst.executeUpdate();
        System.out.println("Student added successfully.");
    }

    public void updateStudent() throws SQLException {
        String rollNo = inputHandler.getRollNo();
        String[] details = inputHandler.getUpdatedStudentDetails();
        String query = "UPDATE StudentInfo SET name = ?, dept_name = ? WHERE roll_no = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, details[0]);
        pst.setString(2, details[1]);
        pst.setInt(3, Integer.parseInt(rollNo));
        pst.executeUpdate();
        System.out.println("Student updated successfully.");
    }

    public void deleteStudent() throws SQLException {
        String rollNo = inputHandler.getRollNo();
        String query = "DELETE FROM StudentInfo WHERE roll_no = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, Integer.parseInt(rollNo));
        pst.executeUpdate();
        System.out.println("Student deleted successfully.");
    }

    public void fetchData() throws SQLException {
        String query = "SELECT * FROM StudentInfo";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
        	System.out.printf("%-10d %-20s %-20s%n", rs.getInt("roll_no"), rs.getString("name"), rs.getString("dept_name")); 
        }
    }

    public void searchData() throws SQLException {
        String rollNo = inputHandler.getRollNo();
        String query = "SELECT * FROM StudentInfo WHERE roll_no = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, Integer.parseInt(rollNo));
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            System.out.println("Roll No: " + rs.getInt("roll_no") + ", Name: " + rs.getString("name") + ", Department: " + rs.getString("dept_name"));
        } else {
            System.out.println("No student found with the given roll number.");
        }
    }

    public void closeConnection() throws SQLException {
        if (con != null) {
            con.close();
            System.out.println("Connection closed successfully.");
        }
    }
}