package FormationBean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import entities.Formation;
import services.GestionFormationService;

@ManagedBean
@ViewScoped
public class GestionFormationBean implements Serializable{

	private String nom_formation;
	private String description_formation;
	private String niveau_formation;
	private String duree_formation;
	private Date dateDeb_formation;
	private float prix_formation;
	private Formation formation;
	private List<Formation> formations;
	private Formation selectedFormation;
	public GestionFormationBean() {
		formation = new Formation();
        formations = new ArrayList();
        selectedFormation = new Formation();
	}
	
	
	@EJB
	private GestionFormationService gs;
	@PostConstruct
	public void init() {
		formations=gs.getAllFormation();
	}
	public List<Formation> getFormations() {
		
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public void ajoutFormation() {
		Formation formation = new Formation ();
		formation.setDescription_formation(description_formation);
		formation.setNiveau_formation(niveau_formation);
		formation.setNom_formation(nom_formation);
		formation.setDuree_formation(duree_formation);
		formation.setDateDeb_formation(dateDeb_formation);
		formation.setPrix_formation(prix_formation);
		gs.ajouterFormation(formation);
		System.out.println("ajout avec succes");
		formations=gs.getAllFormation();
		//dsadsadsad
	}
	public void supprimerFormation(){
        if(selectedFormation==null){
            FacesMessage msg = new FacesMessage("Veuillez selectionner un élément");
            FacesContext.getCurrentInstance().addMessage("Alerte", msg);
        }
        else{
            System.out.println(selectedFormation.getId_formation());
        gs.supprimerFormation(selectedFormation.getId_formation());
        FacesMessage msg = new FacesMessage("Suppression réussie");
        FacesContext.getCurrentInstance().addMessage(null, msg);
                selectedFormation = new Formation();
        }
    }
	public void modifierFormation(){
        
        gs.updateFormation(selectedFormation);
        FacesMessage msg = new FacesMessage("Elément modifié!");
         FacesContext.getCurrentInstance().addMessage(null, msg);
         selectedFormation = new Formation();
 }
	public String detail() {
		String navigateTo ="null";
		
		if (selectedFormation !=null) {
			navigateTo ="/View/formation.xhtml";
			System.out.println("ahla wasahla");
		}
		else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("erreur"));
		}
		return navigateTo;
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
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	public Formation getSelectedFormation() {
		return selectedFormation;
	}
	public void setSelectedFormation(Formation selectedFormation) {
		this.selectedFormation = selectedFormation;
	}


}
