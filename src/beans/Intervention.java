package beans;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Intervention 
{
	private int id;
	private String numIntervention;
	private Date datePlanifiee;
	private Date dateRealisation;
	private int statut;
	private String commentaire;
	private Intervenant intervenant;
	private Materiel materiel;
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumIntervention() {
		return numIntervention;
	}
	public void setNumIntervention(String numIntervention) {
		this.numIntervention = numIntervention;
	}
	public Date getDatePlanifiee() {
		return datePlanifiee;
	}
	public void setDatePlanifiee(Date datePlanifiee) {
		this.datePlanifiee = datePlanifiee;
	}
	public Date getDateRealisation() {
		return dateRealisation;
	}
	public void setDateRealisation(Date dateRealisation) {
		this.dateRealisation = dateRealisation;
	}
	public int getStatut() {
		return statut;
	}
	public void setStatut(int statut) {
		this.statut = statut;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	@ManyToOne
	public Intervenant getIntervenant() {
		return intervenant;
	}
	public void setIntervenant(Intervenant intervenant) {
		this.intervenant = intervenant;
	}
	@ManyToOne
	public Materiel getMateriel() {
		return materiel;
	}
	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}
	
	public Intervention(){this(0, "", null, null, 0, "");}
	public Intervention(int id, String numIntervention, Date datePlanifiee,
			Date dateRealisation, int statut, String commentaire) {
		super();
		this.id = id;
		this.numIntervention = numIntervention;
		this.datePlanifiee = datePlanifiee;
		this.dateRealisation = dateRealisation;
		this.statut = statut;
		this.commentaire = commentaire;
	}
	
}
