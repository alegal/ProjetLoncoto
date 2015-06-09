package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import beans.Batiment;
import beans.Etage;
import beans.Materiel;
import beans.Salle;
import beans.Site;

public class EmplacementMaterielDAO implements IEmplacementMateriel
{
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Site> findAllSite() {
		return entityManager.createQuery("FROM Site", Site.class).getResultList();
	}
	
	public Site find(int id) {
		return entityManager.find(Site.class, id);
	}
	
	public List<Site> findByBatiment() {
		return entityManager.createQuery("SELECT st FROM Site as st WHERE st.batiment.id=:pid", Site.class).getResultList();
	}
	
	public Site findByBatiment(int id) {
		return entityManager.find(Site.class, id);
	}
		
	public List<Batiment> findAllBatiments() {
		return entityManager.createQuery("FROM Batiment", Batiment.class).getResultList();
	}
	
	public Batiment findById(int id, int id2) {
		return entityManager.find(Batiment.class, id);
	}
	 
	public List<Etage> findAllEtage() {
		return entityManager.createQuery("FROM Etage", Etage.class).getResultList();
	}
	
	public Etage findById(int id) {
		return entityManager.find(Etage.class, id);
	}
	
	public List<Etage> findEtageBySalle() {
		return entityManager.createQuery("SELECT e FROM Etage as e WHERE e.salle.id=:pid", Etage.class).getResultList();
	}
	
	public List<Salle> findAllSalle() {
		return entityManager.createQuery("FROM Salle", Salle.class).getResultList();
	}
	
	public Salle findID(int id) {
		return entityManager.find(Salle.class, id);
	}
	/*
	public List<Salle> findEtageBySalle1() {
		return entityManager.createQuery("select e from Etage as e WHERE e.salle.id=:pid").getResultList();
	}*/
	
	
	public Materiel findMaterielById(int id){
		if (id > 0){
			return entityManager.find(Materiel.class, id);
		}
		return null;
	}

}
