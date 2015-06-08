package beans;

import java.util.List;

import javax.persistence.*;

@Entity
public class Site
{
	private int id;
	private String numSite;
	private List<Batiment> batiments;
	private List<Client> clients;
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumSite() {
		return numSite;
	}
	public void setNumSite(String numSite) {
		this.numSite = numSite;
	}
	
	@OneToMany(mappedBy="site")
	public List<Batiment> getBatiments() {
		return batiments;
	}
	public void setBatiments(List<Batiment> batiments) {
		this.batiments = batiments;
	}
	@ManyToMany(mappedBy="sites")
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public Site(){this(0, "");}
	public Site(int id, String numSite) {
		super();
		this.id = id;
		this.numSite = numSite;
	}
	
}
