package beans;

import java.util.List;

import javax.persistence.*;

@Entity
public class Client
{
	private int id;
	private String nom;
	private String email;
	private List<Site> sites;
	private List<Materiel> materiels;
	
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
	public List<Site> getSites() {
		return sites;
	}
	public void setSites(List<Site> sites) {
		this.sites = sites;
	}
	@OneToMany(mappedBy="client")
	public List<Materiel> getMateriels() {
		return materiels;
	}
	public void setMateriels(List<Materiel> materiels) {
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
