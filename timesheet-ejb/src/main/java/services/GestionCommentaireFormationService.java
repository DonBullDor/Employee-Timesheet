package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Formation;
import entities.FormationComment;

/**
 * Session Bean implementation class GestionCommentaireFormationService
 */
@Stateless
@LocalBean
public class GestionCommentaireFormationService {
	
	@PersistenceContext
	EntityManager em;
	
	

	public void ajouterFormationCommentaire (FormationComment f) {
		em.persist(f);
		System.out.println("1"+"ajout avec succes");
	}
	public void supprimerFormationCommentaire (int id_comment) {
		FormationComment f = em.find(FormationComment.class, id_comment);
		System.out.println("2"+f);
		em.remove(f);
		
	}
	
    public List <FormationComment> getAllFormationComments(){
    	TypedQuery<FormationComment> query = em.createQuery("SELECT f FROM FormationComment f",FormationComment.class);  
 	   try {
 		 return query.getResultList();
 	   }
 	   catch (Exception e){
 		   System.out.println("erreur");	   
 	   }
 	   return null;
    }
    
	
    public GestionCommentaireFormationService() {
        
    }

}
