package beans;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Client
{
	private int id;
	private String nom;
	private String email;
	private Set<Site> sites;
	private Set<Materiel> materiels;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@ManyToMany
	public Set<Site> getSites() {
		return sites;
	}
	public void setSites(Set<Site> sites) {
		this.sites = sites;
	}
	@OneToMany(mappedBy="client")
	public Set<Materiel> getMateriels() {
		return materiels;
	}
	public void setMateriels(Set<Materiel> materiels) {
		this.materiels = materiels;
	}
	
	public Client(){this(0, "", "");}
	public Client(int id, String nom, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
	}

}
