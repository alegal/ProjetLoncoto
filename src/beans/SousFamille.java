package beans;

import java.util.List;

import javax.persistence.*;

@Entity
public class SousFamille 
{
	private int id;
	private String libelle;
	private List<Article> articles;
	private Famille famille;
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@OneToMany(mappedBy="sousfamille")
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	@ManyToOne
	public Famille getFamille() {
		return famille;
	}
	public void setFamille(Famille famille) {
		this.famille = famille;
	}
	
	public SousFamille() {this(0, "");}
	public SousFamille(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

}
