package beans;

import java.util.List;

import javax.persistence.*;


@Entity
public class Groupe
{
	private int id;
	private String libelle;
	private List<Intervenant> intervenants;
	
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
	
	@ManyToMany(mappedBy="groupes")
	public List<Intervenant> getIntervenants() {
		return intervenants;
	}
	public void setIntervenants(List<Intervenant> intervenants) {
		this.intervenants = intervenants;
	}
	
	public Groupe(){this(0, "");}
	public Groupe(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	
}
