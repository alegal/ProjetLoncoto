package beans;

import java.util.List;

import javax.persistence.*;

@Entity
public class Famille
{
	private int id;
	private String libelle;
	private List<SousFamille> sousfamilles;
	
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
	
	@OneToMany(mappedBy="famille")
	public List<SousFamille> getSousfamilles() {
		return sousfamilles;
	}
	public void setSousfamilles(List<SousFamille> sousfamilles) {
		this.sousfamilles = sousfamilles;
	}
	
	public Famille() {this(0, "");}
	public Famille(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	
}
