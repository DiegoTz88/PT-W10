import java.sql.*;
import java.util.Scanner;

public class NFLTester {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to the database access Panel.\n"
				+ "Please enter your username");
		String username = kb.nextLine();
		System.out.println("Please enter your password");
		String pw = kb.nextLine();
		

		String DBConn = "jdbc:mysql://localhost:3306/employees";
		String Read = "SELECT * FROM player";
		try {
			Connection access = DriverManager.getConnection(DBConn, username, pw);
			PreparedStatement statement = access.prepareStatement(Read);
			statement.setString(1, num);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				System.out.println("Player ID: " + results.getInt(1) + "| Name: " + results.getString(3) + results.getString(4));
			}
			
			System.out.println("Access granted");
		} catch(SQLException e) {
			System.out.println("Access denied");
			e.printStackTrace();
		}
	}

}
