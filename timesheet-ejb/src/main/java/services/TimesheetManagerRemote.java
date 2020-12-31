package services;

import javax.ejb.Remote;

import entities.Timesheet;

@Remote
public interface TimesheetManagerRemote {
	public void addTimesheet(Timesheet timesheet);

}
