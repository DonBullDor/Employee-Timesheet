package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_user;
	private String nom_user;
	private String prenom_user;
	private String email_user;
	private String cin_user;
	private String address_user;	
	@Temporal(TemporalType.DATE)
	private Date date_de_naissance_user;
	private String password_user;
	private boolean isActif_user;
	private String sexe;
	
	public User(String sexe) {
		super();
		this.sexe = sexe;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getNom_user() {
		return nom_user;
	}
	public void setNom_user(String nom_user) {
		this.nom_user = nom_user;
	}
	public String getPrenom_user() {
		return prenom_user;
	}
	public void setPrenom_user(String prenom_user) {
		this.prenom_user = prenom_user;
	}
	public String getEmail_user() {
		return email_user;
	}
	public void setEmail_user(String email_user) {
		this.email_user = email_user;
	}
	public String getCin_user() {
		return cin_user;
	}
	public void setCin_user(String cin_user) {
		this.cin_user = cin_user;
	}
	public String getAddress_user() {
		return address_user;
	}
	public void setAddress_user(String address_user) {
		this.address_user = address_user;
	}
	public Date getDate_de_naissance_user() {
		return date_de_naissance_user;
	}
	public void setDate_de_naissance_user(Date date_de_naissance_user) {
		this.date_de_naissance_user = date_de_naissance_user;
	}
	public String getPassword_user() {
		return password_user;
	}
	public void setPassword_user(String password_user) {
		this.password_user = password_user;
	}
	public boolean isActif_user() {
		return isActif_user;
	}
	public void setActif_user(boolean isActif_user) {
		this.isActif_user = isActif_user;
	}
	public User(int id_user, String nom_user, String prenom_user, String email_user, String cin_user,
			String address_user, Date date_de_naissance_user, String password_user, boolean isActif_user) {
		super();
		this.id_user = id_user;
		this.nom_user = nom_user;
		this.prenom_user = prenom_user;
		this.email_user = email_user;
		this.cin_user = cin_user;
		this.address_user = address_user;
		this.date_de_naissance_user = date_de_naissance_user;
		this.password_user = password_user;
		this.isActif_user = isActif_user;
	}
	public User() {
		super();
	}
	
	
	
	

}
