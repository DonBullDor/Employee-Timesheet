package FormationBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.DragDropEvent;

@ManagedBean
@ViewScoped
public class ItemsBean {
	static Connection connecttion = null;
	static PreparedStatement prepareStatement = null;
	private List<String> items;
	private List<String> selectedItems = new ArrayList<>();

	@PostConstruct
	public void postConstruct() {
		makeJDBCConnection();
		try {
			// MySQL Select Query Tutorial
			String getQueryStatement = "SELECT * FROM timesheet";

			prepareStatement = connecttion.prepareStatement(getQueryStatement);

			// Execute the Query, and get a java ResultSet
			ResultSet rs = prepareStatement.executeQuery();
			items = new ArrayList<>();
			// Let's iterate through the java ResultSet
			while (rs.next()) {
				String tasks = rs.getString("task");
				
				// Simply Print the results
				System.out.format("%s\n", tasks);
				items.add(tasks);
				System.out.println(items);
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		}  
		
		
		//items = new ArrayList<>(Arrays.asList("Shane", "Amber", "Kiley"));
		
		
		
	}

	public List<String> getItems() {
		return items;
	}

	public void onItemDropped(DragDropEvent event) {
		String item = (String) event.getData();
		selectedItems.add(item);
		items.remove(item);
	}

	public List<String> getSelectedItems() {
		return selectedItems;
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
			connecttion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pidevjee", "root", "");
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
}