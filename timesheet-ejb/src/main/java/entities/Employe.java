package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity

public class Employe implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String email;

	@Temporal(TemporalType.DATE)
	private Date date_de_naissance_user;
	private String password_user;
	private String role;
	private static final long serialVersionUID = 1L;

	public Employe() {
	}

	public Employe(int id, String nom, String prenom, String email, Date date_de_naissance_user, String password_user,
			String role) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.date_de_naissance_user = date_de_naissance_user;
		this.password_user = password_user;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
