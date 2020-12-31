package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Formation implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_formation;
	private String description_formation;
	private String nom_formation;
	private String niveau_formation;
	private String duree_formation;
	private Date dateDeb_formation;
	private float prix_formation;
	@OneToOne(mappedBy = "formation",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
	private FormationNote formationNote;
	@OneToMany(mappedBy="formation",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
	private List<FormationComment> formationComments=new ArrayList<FormationComment>();
	
	
	public List<FormationComment> getFormationComments() {
		return formationComments;
	}
	public void setFormationComments(List<FormationComment> formationComments) {
		this.formationComments = formationComments;
	}
	public FormationNote getFormationNote() {
		return formationNote;
	}
	public void setFormationNote(FormationNote formationNote) {
		this.formationNote = formationNote;
	}
	public int getId_formation() {
		return id_formation;
	}
	public void setId_formation(int id_formation) {
		this.id_formation = id_formation;
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
	
	public String getNom_formation() {
		return nom_formation;
	}
	public void setNom_formation(String nom_formation) {
		this.nom_formation = nom_formation;
	}
	

	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Formation(int id_formation, String description_formation, String nom_formation, String niveau_formation,
			String duree_formation, Date dateDeb_formation, float prix_formation) {
		super();
		this.id_formation = id_formation;
		this.description_formation = description_formation;
		this.nom_formation = nom_formation;
		this.niveau_formation = niveau_formation;
		this.duree_formation = duree_formation;
		this.dateDeb_formation = dateDeb_formation;
		this.prix_formation = prix_formation;
	}
	
	
	

	public Formation(int id_formation, String description_formation, String nom_formation, String niveau_formation,
			String duree_formation, float prix_formation) {
		super();
		this.id_formation = id_formation;
		this.description_formation = description_formation;
		this.nom_formation = nom_formation;
		this.niveau_formation = niveau_formation;
		this.duree_formation = duree_formation;
		this.prix_formation = prix_formation;
	}
	@Override
	public String toString() {
		return "Formation [id_formation=" + id_formation + ", description_formation=" + description_formation
				+ ", nom_formation=" + nom_formation + ", niveau_formation=" + niveau_formation + ", duree_formation="
				+ duree_formation + ", dateDeb_formation=" + dateDeb_formation + ", prix_formation=" + prix_formation
				+ ", formationNote=" + formationNote + ", formationComments=" + formationComments + "]";
	}
	public Formation(int id_formation, String description_formation, String nom_formation, String niveau_formation,
			String duree_formation, Date dateDeb_formation, float prix_formation, FormationNote formationNote,
			List<FormationComment> formationComments) {
		super();
		this.id_formation = id_formation;
		this.description_formation = description_formation;
		this.nom_formation = nom_formation;
		this.niveau_formation = niveau_formation;
		this.duree_formation = duree_formation;
		this.dateDeb_formation = dateDeb_formation;
		this.prix_formation = prix_formation;
		this.formationNote = formationNote;
		this.formationComments = formationComments;
	}
	public Formation(String description_formation, String nom_formation, String niveau_formation,
			String duree_formation, Date dateDeb_formation, float prix_formation) {
		
		this.description_formation = description_formation;
		this.nom_formation = nom_formation;
		this.niveau_formation = niveau_formation;
		this.duree_formation = duree_formation;
		this.dateDeb_formation = dateDeb_formation;
		this.prix_formation = prix_formation;
	}
	
	
	
	
}
