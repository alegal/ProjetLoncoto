package jsf2;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
	
	/*** METHODE D'APPEL POUR FILTRE ARTICLE ***/
	
	private List<Famille> famille;

	public List<Famille> getFamille() {

		this.famille = getFamilleDAO().findAllFamille();
		System.out.println(famille.size());
		
		return famille;
	}

	public void setFamille(List<Famille> famille) {
		this.famille = famille;
	}

}
