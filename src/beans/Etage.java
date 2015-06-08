package beans;

import java.util.List;

import javax.persistence.*;

@Entity
public class Etage
{
	private int id;
	private String numEtage;
	private List<Salle> salles;
	private Batiment batiment;
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumEtage() {
		return numEtage;
	}
	public void setNumEtage(String numEtage) {
		this.numEtage = numEtage;
	}
	
	@OneToMany(mappedBy="etage")
	public List<Salle> getSalles() {
		return salles;
	}
	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}
	
	@ManyToOne
	public Batiment getBatiment() {
		return batiment;
	}
	public void setBatiment(Batiment batiment) {
		this.batiment = batiment;
	}
	
	public Etage(){this(0, "");}
	public Etage(int id, String numEtage) {
		super();
		this.id = id;
		this.numEtage = numEtage;
	}
	
	
}
