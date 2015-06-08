package utils;

import java.util.List;

import beans.*;

public interface IFamille {

	public List<Famille> findAllFamille();
	
	public List<SousFamille> findBySousFamille(int idFamille);
	public List<Article> findByArticle(int idSousFamille);
	public List<Materiel> findByMateriel(int idArticle);
	
}
