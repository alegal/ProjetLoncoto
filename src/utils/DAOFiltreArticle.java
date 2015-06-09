package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
		
		Query q = em.createQuery("SELECT sf from SousFamille as sf WHERE famille_id = :idFamille", SousFamille.class);
		
		q.setParameter("idFamille", idFamille);
		
		return q.getResultList();
	}

	@Transactional
	public List<Article> findByArticle(int idSousFamille) {
		
		Query q = em.createQuery("SELECT art from Article as art WHERE sousfamille_id = :idSousFamille", Article.class);
		
		q.setParameter("idSousFamille", idSousFamille);
		
		return q.getResultList();
	}

	@Transactional
	public List<Materiel> findByMateriel(int idArticle) {
		
		return null;
	}

}
