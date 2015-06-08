package beans;

import java.util.List;

import javax.persistence.*;

@Entity
public class Salle
{
	private int id;
	private String numSalle;
	private List<Materiel> materiels;
	private Etage etage;
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumSalle() {
		return numSalle;
	}
	public void setNumSalle(String numSalle) {
		this.numSalle = numSalle;
	}
	
	@OneToMany(mappedBy="salle")
	public List<Materiel> getMateriels() {
		return materiels;
	}
	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}
	
	@ManyToOne
	public Etage getEtage() {
		return etage;
	}
	public void setEtage(Etage etage) {
		this.etage = etage;
	}
	
	public Salle() {this(0, "");}
	public Salle(int id, String numSalle) {
		super();
		this.id = id;
		this.numSalle = numSalle;
	}
	
}
