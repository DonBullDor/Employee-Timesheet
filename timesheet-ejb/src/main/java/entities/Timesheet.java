package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity

public class Timesheet implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String day;
	private int numberOfTheDay;
	@Temporal(TemporalType.DATE)
	private Date date;
	private int year;
	private int month;
	private int timelineDay;
	private String inTime;
	private String outTime;
	private String task;
	private double workedHoursOnTask;
	
	
	public Timesheet() {}

	public Timesheet(int id, String day, Date date, String inTime, String outTime, String task) {
		super();
		this.id = id;
		this.day = day;
		this.date = date;
		this.inTime = inTime;
		this.outTime = outTime;
		this.task = task;
	}


	public Timesheet(String day, Date date, String inTime, String outTime, String task) {
		super();
		this.day = day;
		this.date = date;
		this.inTime = inTime;
		this.outTime = outTime;
		this.task = task;
	}
	
	

	public int getNumberOfTheDay() {
		return numberOfTheDay;
	}

	public void setNumberOfTheDay(int numberOfTheDay) {
		this.numberOfTheDay = numberOfTheDay;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getTimelineDay() {
		return timelineDay;
	}

	public void setTimelineDay(int timelineDay) {
		this.timelineDay = timelineDay;
	}

	public double getWorkedHoursOnTask() {
		return workedHoursOnTask;
	}

	public void setWorkedHoursOnTask(double workedHoursOnTask) {
		this.workedHoursOnTask = workedHoursOnTask;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "Timesheet [id=" + id + ", day=" + day + ", numberOfTheDay=" + numberOfTheDay + ", date=" + date
				+ ", month=" + month + ", timelineDay=" + timelineDay + ", inTime=" + inTime + ", outTime=" + outTime
				+ ", task=" + task + ", workedHoursOnTask=" + workedHoursOnTask + "]";
	}
	
	
   
}
