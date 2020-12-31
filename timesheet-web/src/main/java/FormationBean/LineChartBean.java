package FormationBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class LineChartBean {
	static Connection connecttion = null;
	static PreparedStatement prepareStatement = null;
    private LineChartModel lineModel;

    @PostConstruct
    public void init() {
    	makeJDBCConnection();
        lineModel = new LineChartModel();
        LineChartSeries s = new LineChartSeries();
        s.setLabel("hours");

        try {
			// MySQL Select Query Tutorial
			String getQueryStatement = "SELECT * FROM timesheet";

			prepareStatement = connecttion.prepareStatement(getQueryStatement);

			// Execute the Query, and get a java ResultSet
			ResultSet rs = prepareStatement.executeQuery();

			// Let's iterate through the java ResultSet
			while (rs.next()) {
				int numberOfTheDay = rs.getInt("numberOfTheDay");
				int workedHoursOnTask = rs.getInt("workedHoursOnTask");
				
				// Simply Print the results
				System.out.format("%s, %s\n", numberOfTheDay, workedHoursOnTask);
				
				s.set(numberOfTheDay, workedHoursOnTask);
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		}  
        
		/*
		 * s.set(1, 2); s.set(2, 4); s.set(3, 5); s.set(4, 1); s.set(5, 4); s.set(6, 1);
		 */

        lineModel.addSeries(s);
        lineModel.setLegendPosition("e");
        Axis y = lineModel.getAxis(AxisType.Y);
        y.setMin(0);
        y.setMax(8);
        y.setLabel("Hours");

        Axis x = lineModel.getAxis(AxisType.X);
        x.setMin(1);
        x.setMax(7);
        x.setTickInterval("1");
        x.setLabel("Number of Day");

    }

    public LineChartModel getLineModel() {
        return lineModel;
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

