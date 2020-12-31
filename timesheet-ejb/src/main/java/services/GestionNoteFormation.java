package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.FormationComment;
import entities.FormationNote;

/**
 * Session Bean implementation class GestionNoteFormation
 */
@Stateless
@LocalBean
public class GestionNoteFormation {

	@PersistenceContext
	EntityManager em;
	
	

	public void ajouterFormationCommentaire (FormationNote f) {
		em.persist(f);
		System.out.println("1"+"ajout avec succes");
	}
	public void supprimerFormationNote (int id_note) {
		FormationNote f = em.find(FormationNote.class, id_note);
		System.out.println("2"+f);
		em.remove(f);
		
	}
	
    public List <FormationNote> getAllFormationNotes(){
    	TypedQuery<FormationNote> query = em.createQuery("SELECT f FROM FormationNote f",FormationNote.class);  
 	   try {
 		 return query.getResultList();
 	   }
 	   catch (Exception e){
 		   System.out.println("erreur");	   
 	   }
 	   return null;
    }
    
	
	
    public GestionNoteFormation() {
        // TODO Auto-generated constructor stub
    }

}
