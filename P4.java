import java.sql.*;

public class P4 {
    public static void main(String[] args) {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/P4", "root", "");
            
            Statement statement = connection.createStatement();
            
            String query = "SELECT EnrollNo, Name, Address, MobileNo, EmailID FROM StuRec";
            ResultSet resultSet = statement.executeQuery(query);
            
            System.out.println("Student Records:");
            System.out.println("-----------------------------");
            while (resultSet.next()) {
                String enrollNo = resultSet.getString("EnrollNo");
                String name = resultSet.getString("Name");
                String address = resultSet.getString("Address");
                String mobileNo = resultSet.getString("MobileNo");
                String emailID = resultSet.getString("EmailID");
                
                System.out.println("Enroll No: " + enrollNo);
                System.out.println("Name: " + name);
                System.out.println("Address: " + address);
                System.out.println("Mobile No: " + mobileNo);
                System.out.println("Email ID: " + emailID);
                System.out.println("-----------------------------");
            }
            
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}