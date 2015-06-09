package jsf2;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

import beans.*;
import utils.*;

@Component
@ManagedBean
@RequestScoped
public class ListeBean {

	/*** INSTANCIATION DAO ***/
	
	private IFamille familleDAO;

	public IFamille getFamilleDAO() {
		System.out.println("injection familleDAO");
		return familleDAO;
	}

	public void setFamilleDAO(IFamille familleDAO) {
		this.familleDAO = familleDAO;
	}
	
	/*** VARIABLE DE CLASS ***/
	
	//Famille
	private int fid;
	//SousFamille
	private int sfid;
	//Article
	private int articleid;
	
	public int getFid() {return fid;}
	public void setFid(int fid) {this.fid = fid;}
	public int getSfid() {return sfid;}
	public void setSfid(int sfid) {this.sfid = sfid;}
	public int getArticleid() {return articleid;}
	public void setArticleid(int articleid) {this.articleid = articleid;}

	/*** METHODE D'APPEL POUR FILTRE ARTICLE ***/
	
	/* Famille */
	private List<Famille> famille;

	public List<Famille> getFamille() {

		this.famille = getFamilleDAO().findAllFamille();
		System.out.println(famille.size());
		
		return famille;
	}

	public void setFamille(List<Famille> famille) {
		this.famille = famille;
	}
	
	/* Sous Famille */
	private List<SousFamille> sousFamille;

	public List<SousFamille> getSousFamille() {
		
		Map<String,String> params = FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap();
		
		if(params.get("fid") != null){
			fid = Integer.parseInt(params.get("fid"));
		}else{
			fid = 0;
			
		}
		
		sousFamille = getFamilleDAO().findBySousFamille(fid);
		
		return sousFamille;
	}

	public void setSousFamille(List<SousFamille> sousFamille) {
		this.sousFamille = sousFamille;
	}
	
	// Recupere les sous famille
	public String recupSousFamille() {
		
		this.getSousFamille();
		
		this.setSousFamille(sousFamille);
		
		return "sous_famille";
	}
	
	/* Article */
	private List<Article> article;

	public List<Article> getArticle() {
		
		Map<String,String> params = FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap();
		
		if(params.get("sfid") != null){
			sfid = Integer.parseInt(params.get("sfid"));
		}else{
			sfid = 0;	
		}
		
		System.out.println("SOUS FAMILLE ID " + sfid);
		
		article = getFamilleDAO().findByArticle(sfid);
		return article;
	}

	public void setArticle(List<Article> article) {
		this.article = article;
	}
	
	// Recupere les articles
	public String recupArticle() {
		
		this.getArticle();
		
		this.setArticle(article);
		
		return "article";
	}
	

}
