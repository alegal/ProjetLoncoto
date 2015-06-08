package beans;

import java.util.List;

import javax.persistence.*;

@Entity
public class Article
{
	private int id;
	private String nom;
	private String description;
	private List<Materiel> materiels;
	private SousFamille sousfamille;
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToMany(mappedBy="article")
	public List<Materiel> getMateriels() {
		return materiels;
	}
	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}
	
	@ManyToOne
	public SousFamille getSousfamille() {
		return sousfamille;
	}
	public void setSousfamille(SousFamille sousfamille) {
		this.sousfamille = sousfamille;
	}
	
	public Article() {this(0, "", "");}
	public Article(int id, String nom, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
	}
	
	

}
