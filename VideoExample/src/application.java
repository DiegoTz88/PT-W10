import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class application {
	
	public static void main(String[] args) {
		//jdbc:mysql://hostname:port/databasename
		String connectionString = "jdbc:mysql://localhost:3306/employees"; //localhost is an alias to 127.0.0.1, which is your actual computer
		String SELECT_QUERY = "SELECT * FROM employees WHERE emp_no = ?";
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			Connection conn = DriverManager.getConnection(connectionString, "root", "Acmilan#1");
			System.out.println("Connected successfully!");
			System.out.print("Enter employee number: ");
			String empNo = scanner.nextLine();
			PreparedStatement ps = conn.prepareStatement(SELECT_QUERY);
			ps.setString(1, empNo);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.println("emp no: " + rs.getInt(1) + " dob: " + rs.getString(2) + " first Name: " + rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("Error connecting to the database.");
			e.printStackTrace();
		}
	}
}
