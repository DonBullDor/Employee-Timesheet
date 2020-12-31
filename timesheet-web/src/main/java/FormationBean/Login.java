package FormationBean;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Login() {
	}
	
	public String doLogin() {
		String navigateTo = null;
		navigateTo = "/View/TimesheetShow?faces-redirect=true";
		return navigateTo;
	}
	
	

}
