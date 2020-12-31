package FormationBean;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import entities.Formation;
import services.GestionFormationService;

@ManagedBean
@ViewScoped
public class FormationBean {
	
	private String nom_formation;
	private String description_formation;
	private String niveau_formation;
	private String duree_formation;
	private Date dateDeb_formation;
	private float prix_formation;
	@ManagedProperty(value="#{GestionFormationBean}")
	private GestionFormationBean gestionFormationBean;
	
	
	public GestionFormationBean getGestionFormationBean() {
		return gestionFormationBean;
	}


	@EJB
	GestionFormationService gs;
	@PostConstruct
	public void init () {
		Formation f = gestionFormationBean.getSelectedFormation();
	}
	
	
	public String getNom_formation() {
		return nom_formation;
	}
	public void setNom_formation(String nom_formation) {
		this.nom_formation = nom_formation;
	}
	public String getDescription_formation() {
		return description_formation;
	}
	public void setDescription_formation(String description_formation) {
		this.description_formation = description_formation;
	}
	public String getNiveau_formation() {
		return niveau_formation;
	}
	public void setNiveau_formation(String niveau_formation) {
		this.niveau_formation = niveau_formation;
	}
	public String getDuree_formation() {
		return duree_formation;
	}
	public void setDuree_formation(String duree_formation) {
		this.duree_formation = duree_formation;
	}
	public Date getDateDeb_formation() {
		return dateDeb_formation;
	}
	public void setDateDeb_formation(Date dateDeb_formation) {
		this.dateDeb_formation = dateDeb_formation;
	}
	public float getPrix_formation() {
		return prix_formation;
	}
	public void setPrix_formation(float prix_formation) {
		this.prix_formation = prix_formation;
	}
	
	

}
