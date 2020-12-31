package FormationBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.timeline.TimelineEvent;
import org.primefaces.model.timeline.TimelineModel;

@ManagedBean
@ViewScoped
public class TimelineBean {
	
	static Connection connecttion = null;
	static PreparedStatement prepareStatement = null;
	
	private TimelineModel model;
	private Date startDate;
	private Date endDate;

	@PostConstruct
	protected void init() {
		makeJDBCConnection();
		model = new TimelineModel();
		
		try {
			// MySQL Select Query Tutorial
			String getQueryStatement = "SELECT * FROM timesheet";

			prepareStatement = connecttion.prepareStatement(getQueryStatement);

			// Execute the Query, and get a java ResultSet
			ResultSet rs = prepareStatement.executeQuery();

			// Let's iterate through the java ResultSet
			while (rs.next()) {
				int year = rs.getInt("year");
				int timelineDay = rs.getInt("timelineDay");
				int month = rs.getInt("month");
				String task = rs.getString("task");
				// Simply Print the results
				System.out.format("%s, %s, %s, %s\n", year, timelineDay, month, task);
				addVersion(year, month, timelineDay, task);
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		}
		startDate = getDate(2018, 1, 1);
		endDate = getDate(2022, 1, 1);
	}

	private void addVersion(int year, int month, int day, String desc) {
		model.add(new TimelineEvent(desc, getDate(year, month, day)));
	}

	private Date getDate(int year, int month, int day) {
		Instant instant = LocalDate.of(year, month, day).atStartOfDay(ZoneId.systemDefault()).toInstant();
		return Date.from(instant);
	}

	public TimelineModel getModel() {
		return model;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
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
