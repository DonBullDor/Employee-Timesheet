package FormationBean;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class Navigations implements Serializable {

	private static final long serialVersionUID = 1L;

	public Navigations() {};
	
	public String goToTaskFilling() {
		String navigateTo = null;
		navigateTo = "/View/TaskFill?faces-redirect=true";
		return navigateTo;
	}
	
	public String goToTimeSheetHome() {
		String navigateTo = null;
		navigateTo = "/View/TimesheetShow?faces-redirect=true";
		return navigateTo;
	}

	public String goToStatistics() {
		String navigateTo = null;
		navigateTo = "/View/TimesheetStatistics?faces-redirect=true";
		return navigateTo;
	}
	
	public String goToKanbanBoard() {
		String navigateTo = null;
		navigateTo = "/View/KanbanBoard?faces-redirect=true";
		return navigateTo;
	}
}
