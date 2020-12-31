package FormationBean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import entities.Timesheet;
import services.TimesheetManager;
import services.TimmesheetService;

@ManagedBean
@ViewScoped
public class TimesheetBean implements Serializable {

	private String day;
	private Date date;
	private String inTime;
	private String outTime;
	private String task;
	private Timesheet t = new Timesheet();

	private static final long serialVersionUID = 1L;
	
	private List<Timesheet> timesheets;
	@PostConstruct
	public void init () {
		 timesheets = timesheetService.loadAll();
	}
	
	public TimesheetBean() {
	}

	private Timesheet timesheet = new Timesheet();

	@EJB
	private TimesheetManager timesheetManager;

	@EJB
	private TimmesheetService timesheetService;
	
	public void delete(Timesheet timesheet) {
        timesheetManager.delete(timesheet);
        timesheets.remove(timesheet);
    }

	
    public void add() {
    	t.setTask(task);
    	t.setDate(new Date());
    	t.setDay(day);
    	t.setInTime(inTime);
    	t.setOutTime(outTime);
    	
    	System.out.println("add simple "+t);
    	timesheetService.addNewTimesheet(t);
       
    }
    
    @EJB
    TimesheetManager service;
    public void addTimesheet() {
    	service.addTimesheet(new Timesheet(day, date, inTime, outTime, task));
    }

    public void update() {
        timesheetManager.update(timesheets);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update successful"));
    }

	public List<Timesheet> getTimesheets() {
		return timesheets;
	}
	
	
	
	public Timesheet getT() {
		return t;
	}
	public void setT(Timesheet t) {
		this.t = t;
	}

	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}

	public Timesheet getTimesheet() {
		return timesheet;
	}

	public void setTimesheet(Timesheet timesheet) {
		this.timesheet = timesheet;
	}

	public TimesheetManager getTimesheetManager() {
		return timesheetManager;
	}

	public void setTimesheetManager(TimesheetManager timesheetManager) {
		this.timesheetManager = timesheetManager;
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
    
}
