import java.sql.*;

public class P5 {

    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/P5";
    private static final String username = "root";
    private static final String password = "";

    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Perform static insert, update, and delete operations
            insertStudent();
            updateStudent();
            deleteStudent();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertStudent() {
        try (
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement ps = connection.prepareStatement("INSERT INTO StuRec (EnrollNo, Name, Address, MobileNo, EmailID) VALUES (?, ?, ?, ?, ?)")) {

            // Static data for insertion
            int enrollNo = 101;
            String name = "John Doe";
            String address = "123 Elm Street";
            String mobileNo = "1234567890";
            String emailID = "johndoe@example.com";

            // Set parameters and execute the query
            ps.setInt(1, enrollNo);
            ps.setString(2, name);
            ps.setString(3, address);
            ps.setString(4, mobileNo);
            ps.setString(5, emailID);

            int rowsAffected = ps.executeUpdate();
            System.out.println("Insert operation: " + rowsAffected + " row(s) inserted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Static method to update an existing student profile
    public static void updateStudent() {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement ps = connection.prepareStatement("UPDATE StuRec SET Name = ?, Address = ?, MobileNo = ?, EmailID = ? WHERE EnrollNo = ?")) {

            // Static data for updating
            String name = "John Smith";
            String address = "456 Oak Street";
            String mobileNo = "0987654321";
            String emailID = "johnsmith@example.com";
            int enrollNo = 101;

            // Set parameters and execute the query
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, mobileNo);
            ps.setString(4, emailID);
            ps.setInt(5, enrollNo);

            int rowsAffected = ps.executeUpdate();
            System.out.println("Update operation: " + rowsAffected + " row(s) updated.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Static method to delete a student profile
    public static void deleteStudent() {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement ps = connection.prepareStatement("DELETE FROM StuRec WHERE EnrollNo = ?")) {

            // Static data for deletion
            int enrollNo = 101;

            // Set parameters and execute the query
            ps.setInt(1, enrollNo);

            int rowsAffected = ps.executeUpdate();
            System.out.println("Delete operation: " + rowsAffected + " row(s) deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
