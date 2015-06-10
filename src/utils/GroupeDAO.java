package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import beans.Groupe;

public class GroupeDAO implements IGroupe
{
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public List<Groupe> findAllGroupe() {
		return entityManager.createQuery("FROM Groupe", Groupe.class).getResultList();
	}

	@Transactional
	public Groupe findById(int id) {
		return entityManager.find(Groupe.class, id);
	}

	@Transactional
	public Groupe editGroupe(Groupe g) {
		if(g == null) return g;
		if(g.getId() != 0){
			entityManager.merge(g);
		}
		else entityManager.persist(g);
		return g;
	}

	@Transactional
	public void deleteGroupe(Groupe g) {
		entityManager.remove(g);
	}
}
