package beans;

import java.util.List;

import javax.persistence.*;

@Entity
public class Intervenant
{
	private int id;
	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	private List<Intervention> interventions;
	private List<Groupe> groupes;
	
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	@OneToMany(mappedBy="intervenant")
	public List<Intervention> getInterventions() {
		return interventions;
	}
	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}
	@ManyToMany
	public List<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}
	
	public Intervenant(){this(0, "", "", "", "");}
	public Intervenant(int id, String nom, String prenom, String login,
			String mdp) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
	}

}
