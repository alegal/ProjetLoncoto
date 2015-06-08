package beans;

import java.util.List;

import javax.persistence.*;

@Entity
public class Materiel 
{
	private int id;
	private String numSerie;
	private String typeIntervention;
	private List<Intervention> interventions;
	private Salle salle;
	private Client client;
	private Article article;
	
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	public String getTypeIntervention() {
		return typeIntervention;
	}
	public void setTypeIntervention(String typeIntervention) {
		this.typeIntervention = typeIntervention;
	}
	
	@OneToMany(mappedBy="materiel")
	public List<Intervention> getInterventions() {
		return interventions;
	}
	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}
	
	@ManyToOne
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	@ManyToOne
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@ManyToOne
	public Article getArticle() {return article;}
	public void setArticle(Article article) {this.article = article;}
	
	public Materiel() {this(0, "", "");}
	public Materiel(int id, String numSerie, String typeIntervention) {
		super();
		this.id = id;
		this.numSerie = numSerie;
		this.typeIntervention = typeIntervention;
	}
	
	
	
}
