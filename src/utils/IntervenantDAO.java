package utils;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import beans.Groupe;
import beans.Intervenant;
import beans.Intervention;

public class IntervenantDAO implements IIntervenant
{
	private EntityManager entityManager;
	//private HashMap<K, V> tabsearch
	
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public List<Intervenant> findAllIntervenant() {
		return entityManager.createQuery("FROM Intervenant").getResultList();
	}
	
	// Fonction de contrôle d'un utilisateur par son id
	@Transactional
	public Intervenant find(int id) {
		return entityManager.find(Intervenant.class, id);
	}
	
	// // Fonction de contrôle lors de la connexion
	@Transactional
	public Intervenant find(String login,String pass) {
		Query q = entityManager.createQuery("SELECT it FROM Intervenant as it WHERE it.login = :cid AND it.mdp = :cpass ");
		q.setParameter("cid", login);
		q.setParameter("cpass", pass);
		
		if(q.getResultList().size() > 0){
			return (Intervenant)q.getResultList().get(0);
		}
		return null;
	}
	
	@Transactional
	public List<Intervention> findAllIntervention() {
		return entityManager.createQuery("FROM Intervention").getResultList();
	}
	
	@Transactional
	public Intervention findInterventionBYId(int id){
		if (id > 0){
			return entityManager.find(Intervention.class, id);
		}
		return null;
	}

	@Transactional
	public List<Groupe> findAllGroupe() {
		return entityManager.createQuery("FROM Groupe", Groupe.class).getResultList();
	}

	@Transactional
	public Intervenant addIntervenant(Intervenant iv){
		if(iv == null) return iv;
		if(iv.getId() != 0){
			entityManager.merge(iv);
		}
		else entityManager.persist(iv);
		return iv;
	}
	

	/**
	 * function permettant ajouter une intervention
	 * @param intervention
	 * @return intervention
	 */
	@Transactional
	public Intervention addIntervention(Intervention iv) {
		if(iv == null) return iv;
		if(iv.getId() != 0){
			entityManager.merge(iv);
		}
		else entityManager.persist(iv);
		return iv;
	}
	
	
	// Fonction de rechercher
	@Transactional
	public List<Intervention> findInterventionbyStatut(int statut){
		Query q;
		if(statut != -1){
			q = entityManager.createQuery("Select iterv FROM Intervention as iterv  WHERE iterv.statut = :statut");
			q.setParameter("statut", statut);
			return q.getResultList();
		}
		return null;
			
	}
	
	@Transactional
	public List<Intervention> findInterventionbySite(int site){
		Query q;
		if(site != -1){
			q = entityManager.createQuery("SELECT iterv FROM Intervention as iterv  WHERE iterv.site = :site");
			q.setParameter("site", site);
			return q.getResultList();
		}
		return null;
			
	}

	
	@Transactional
	public List<Intervention> findInterventionbyClient(int client){
		Query q;
		if(client != -1){
			q = entityManager.createQuery("SELECT iterv FROM Intervention as iterv  WHERE iterv.client = :client");
			q.setParameter("client", client);
			return q.getResultList();
		}
		return null;
			
	}
	
	@Transactional
	public List<Intervention> findInterventionbyDateCreation(Date dateCreation){
		Query q;
		if(dateCreation != null){
			q = entityManager.createQuery("SELECT iterv FROM Intervention as iterv  WHERE iterv.dateRealisation = :dateCreation");
			q.setParameter("dateCreation", dateCreation);
			return q.getResultList();
		}
		return null;
			
	}
	
	
	
	
	// Fonction de sauvegarde de l'intervention
	@Transactional
	public Intervention save(Intervention interV){
		
		/*if(interV == null){
			return interV;
		}*/
		
		if(interV.getId() == 0){
			entityManager.persist(interV);
			return interV;
		}else{
			System.out.println("vous etes ici"+ interV.getCommentaire());
			interV = entityManager.merge(interV);
			return interV;
		}
		
	}
}
