package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import beans.Materiel;

public class MaterielDAO implements IMateriel {

	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Transactional
	public List<Materiel> findAllMateriel() {
		return entityManager.createQuery("FROM Materiel", Materiel.class).getResultList();
	}

	@Transactional
	public Materiel find(int id) {
		return entityManager.find(Materiel.class, id);
	}

	@Transactional
	public Materiel addMateriel(Materiel mat) {
		if(mat == null) return mat;
		if(mat.getId() != 0){
			entityManager.merge(mat);
		}
		else entityManager.persist(mat);
		return mat;
	}

	@Transactional
	public Materiel save(Materiel mat) {
		if(mat.getId() == 0){
			entityManager.persist(mat);
			return mat;
		}else{
			mat = entityManager.merge(mat);
			return mat;
		}
	}

}
