package services;

import java.util.List;
import java.util.UUID;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Formation;
import entities.Timesheet;

@Stateless
@LocalBean
public class TimmesheetService{

	public TimmesheetService() {
	}

	@PersistenceContext
	private EntityManager entityManager;

	public List<Timesheet> loadAll() {
		TypedQuery<Timesheet> query = entityManager.createQuery("SELECT t FROM Timesheet t", Timesheet.class);
		try {
			return query.getResultList();
		} catch (Exception e) {
			System.out.println("erreur");
		}
		return null;
	}

	public void delete(Timesheet timesheet) {
		if (entityManager.contains(timesheet)) {
			entityManager.remove(timesheet);
		} else {
			Timesheet managedCustomer = entityManager.find(Timesheet.class, timesheet.getId());
			if (managedCustomer != null) {
				entityManager.remove(managedCustomer);
			}
		}
	}

	public void addNewTimesheet(Timesheet timesheet) {
		entityManager.persist(timesheet);
	}

	public void update(List<Timesheet> timesheets) {
		entityManager.merge(timesheets);
	}

	public void addTimesheet(Timesheet timesheet) {
		System.out.println("add timesheet test : " + timesheet);
		entityManager.persist(timesheet);
	}
	
	public void TimesheetAdd(Timesheet timesheet) {
		 
		Timesheet newTimeSheet = new Timesheet();
		newTimeSheet.setDay(timesheet.getDay());
		newTimeSheet.setDate(timesheet.getDate());
		newTimeSheet.setInTime(timesheet.getInTime());
		newTimeSheet.setOutTime(timesheet.getOutTime());
		newTimeSheet.setTask(timesheet.getTask());
		//newTimeSheet.setId(UUID.randomUUID().toString().substring(0, 8));
 
        this.entityManager.persist(newTimeSheet);
    }

}
