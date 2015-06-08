package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import beans.Article;
import beans.Famille;
import beans.Materiel;
import beans.SousFamille;

public class DAOFiltreArticle implements IFamille {

	@PersistenceContext
	private EntityManager em;
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	@Transactional
	public List<Famille> findAllFamille() {
		System.out.println("TEST DAO FAMILLE");
		return em.createQuery("from Famille", Famille.class).getResultList();
		
	}

	@Transactional
	public List<SousFamille> findBySousFamille(int idFamille) {
		
		return null;
	}

	@Transactional
	public List<Article> findByArticle(int idSousFamille) {
		
		return null;
	}

	@Transactional
	public List<Materiel> findByMateriel(int idArticle) {
		
		return null;
	}

}
