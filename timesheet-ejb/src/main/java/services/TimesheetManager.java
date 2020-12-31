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
public class TimesheetManager implements TimesheetManagerRemote, TimesheetManagerLocal {

	public TimesheetManager() {
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

	public void addNewTimesheet(List<Timesheet> timesheets) {
		timesheets.forEach(entityManager::merge);;
	}

	public void update(List<Timesheet> timesheets) {
		entityManager.merge(timesheets);
	}

	@Override
	public void addTimesheet(Timesheet timesheet) {
		System.out.println("add timesheet test : " + timesheet);
		entityManager.persist(timesheet);
	}

}
