package beans;

import java.util.List;

import javax.persistence.*;

@Entity
public class Batiment
{
	private int id;
	private String numBat;
	private List<Etage> etages;
	private Site site;
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumBat() {
		return numBat;
	}
	public void setNumBat(String numBat) {
		this.numBat = numBat;
	}
	
	@OneToMany(mappedBy="batiment")
	public List<Etage> getEtages() {
		return etages;
	}
	public void setEtages(List<Etage> etages) {
		this.etages = etages;
	}
	@ManyToOne
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
	public Batiment(){this(0, "");}
	public Batiment(int id, String numBat) {
		super();
		this.id = id;
		this.numBat = numBat;
	}
	
}
