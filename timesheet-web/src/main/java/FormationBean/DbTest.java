package FormationBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DbTest {

	static Connection connecttion = null;
	static PreparedStatement prepareStatement = null;

	public static void main(String[] argv) {
		makeJDBCConnection();
		getDataFromDB();
		//addDataToDB("Monday", "08:00", "16:00", "TestDB");
	}

	private static void makeJDBCConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Congrats - Seems your MySQL JDBC Driver Registered!");
		} catch (ClassNotFoundException e) {
			System.out.println(
					"Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
			e.printStackTrace();
			return;
		}

		try {
			// DriverManager: The basic service for managing a set of JDBC drivers.
			connecttion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pidevds", "root", "");
			if (connecttion != null) {
				System.out.println("Connection Successful!");
			} else {
				System.out.println("Failed to make connection!");
			}
		} catch (SQLException e) {
			System.out.println("MySQL Connection Failed!");
			e.printStackTrace();
			return;
		}

	}

	private static void getDataFromDB() {

		try {
			// MySQL Select Query Tutorial
			String getQueryStatement = "SELECT * FROM timesheet";

			prepareStatement = connecttion.prepareStatement(getQueryStatement);

			// Execute the Query, and get a java ResultSet
			ResultSet rs = prepareStatement.executeQuery();

			// Let's iterate through the java ResultSet
			while (rs.next()) {
				Date date = rs.getDate("date");
				String day = rs.getString("day");
				String inTime = rs.getString("inTime");
				String outTime = rs.getString("outTime");
				String task = rs.getString("task");
				// Simply Print the results
				System.out.format("%s, %s, %s, %s, %s\n", date, day, inTime, outTime, task);
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		}

	}

	private static void addDataToDB(String day, String inTime, String outTime, String task) {

		
		try {
			String insertQueryStatement = "INSERT  INTO  timesheet  VALUES  (?,?,?,?)";

			prepareStatement = connecttion.prepareStatement(insertQueryStatement);
			//prepareStatement.setByte(1, date);
			prepareStatement.setString(1, day);
			
			prepareStatement.setString(2, inTime);
			prepareStatement.setString(3, outTime);
			prepareStatement.setString(4, task);
			
			// execute insert SQL statement
			prepareStatement.executeUpdate();
			System.out.println("you are here : prepareStatement.executeUpdate();");
			System.out.println(task + " added successfully");
		} catch (

		SQLException e) {
			e.printStackTrace();
			System.out.println("Error in adding ");
		}
	}
}