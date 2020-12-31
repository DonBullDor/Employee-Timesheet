package services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Formation;

@Stateless
@LocalBean
public class GestionFormationService {

	

		@PersistenceContext
		EntityManager em;
		
		public void ajouterFormation (Formation f) {
			em.persist(f);
			System.out.println("1"+"ajout avec succes");
		}
		public void supprimerFormation (int id_formation) {
			Formation f = em.find(Formation.class, id_formation);
			System.out.println("2"+f);
			em.remove(f);
			
		}
		
	    public List <Formation> getAllFormation(){
	    	TypedQuery<Formation> query = em.createQuery("SELECT f FROM Formation f",Formation.class);  
	 	   try {
	 		 return query.getResultList();
	 	   }
	 	   catch (Exception e){
	 		   System.out.println("erreur");	   
	 	   }
	 	   return null;
	    }
	    
	    public Formation getFormationById (int formationId) {
	    	return em.find(Formation.class, formationId);
	    }
		public void updateFormationById(int formationId,String description,String nom,String niveau,String duree,Date dateDeb,String image_formation,float prix) {
			Formation formation = em.find(Formation.class, formationId);
			formation.setDescription_formation(description);
			formation.setNom_formation(nom);
			formation.setNiveau_formation(niveau);
			formation.setDuree_formation(duree);
			formation.setDateDeb_formation(dateDeb);
			formation.setPrix_formation(prix);
		}
		public void updateFormation(Formation f) {
			em.merge(f);
		}


    public GestionFormationService() {
        // TODO Auto-generated constructor stub
    }

}
