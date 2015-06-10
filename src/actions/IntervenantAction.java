package actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import utils.IIntervenant;
import beans.Client;
import beans.Groupe;
import beans.Intervenant;
import beans.Intervention;

import com.opensymphony.xwork2.ActionSupport;

public class IntervenantAction extends ActionSupport implements SessionAware
{
	// Propriétés
	public IIntervenant iusers;
	private List<Intervention> interV;
	private String login;
	private String mdp;
	
	// Propriété pour le site
	private Client client;


	// Objet session
	private Map<String, Object> session;
	//private NavigationState navigation;
	public Map<String, Object> getSession() {
		return session;
	}@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
		
	}
	

	private Intervention intervention;

	private int interventionID;
	private String numIntervention;
	private Date datePlanifieeIntervention;
	private Date dateRealisationIntervention;
	private int statutIntervention;
	private String comIntervention;
	
	
	// Propriété tests
	private String message;
	/*private List<String> choix;*/
	
	
	//Accesseurs
	
	public IIntervenant getIusers() {
		return iusers;
	}
	public void setIusers(IIntervenant iusers) {
		this.iusers = iusers;
	}
	public List<Intervention> getInterV() {
		return interV;
	}
	public void setInterV(List<Intervention> interV) {
		this.interV = interV;
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
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Intervention getIntervention() {
		return intervention;
	}
	public void setIntervention(Intervention intervention) {
		this.intervention = intervention;
	}
	public int getInterventionID() {
		return interventionID;
	}
	public void setInterventionID(int interventionID) {
		this.interventionID = interventionID;
	}
	public String getNumIntervention() {
		return numIntervention;
	}
	public void setNumIntervention(String numIntervention) {
		this.numIntervention = numIntervention;
	}
	public Date getDatePlanifieeIntervention() {
		return datePlanifieeIntervention;
	}
	public void setDatePlanifieeIntervention(Date datePlanifieeIntervention) {
		this.datePlanifieeIntervention = datePlanifieeIntervention;
	}
	public Date getDateRealisationIntervention() {
		return dateRealisationIntervention;
	}
	public void setDateRealisationIntervention(Date dateRealisationIntervention) {
		this.dateRealisationIntervention = dateRealisationIntervention;
	}
	public int getStatutIntervention() {
		return statutIntervention;
	}
	public void setStatutIntervention(int statutIntervention) {
		this.statutIntervention = statutIntervention;
	}
	public String getComIntervention() {
		return comIntervention;
	}
	public void setComIntervention(String comIntervention) {
		this.comIntervention = comIntervention;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	// Fonction permettant la connection
	public String userConnect(){
		
		Intervenant it = iusers.find(login, mdp);
		if(it != null){
			interV = iusers.findAllIntervention();
			session.put("login", login);
			session.put("password", mdp);
			return SUCCESS;
		}
		return ERROR; 
	}
	
	public String ListeIntervention(){
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  )
		{	
			interV = iusers.findAllIntervention();
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String InterventionByID(){
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  ){
			intervention = iusers.findInterventionBYId(interventionID);
			if(intervention != null){
				numIntervention = intervention.getNumIntervention();
				datePlanifieeIntervention = intervention.getDatePlanifiee();
				dateRealisationIntervention = intervention.getDateRealisation();
				comIntervention = intervention.getCommentaire();
				statutIntervention = intervention.getStatut();
				return SUCCESS;
			}
			return ERROR;
		}
		return ERROR;
	}
	
	public Intervention InterventionByID(int id){
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  ){
			intervention = iusers.findInterventionBYId(id);
			return intervention;
		}
		return null;
	}
	
	
	// Accès à l'édition des interventions
	public String editIntervention(){
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  ){
			if(interventionID > 0)
			{	
				intervention = InterventionByID(interventionID);
				if( intervention != null)
				{
					interventionID = intervention.getId();
					numIntervention = intervention.getNumIntervention();
					comIntervention = intervention.getCommentaire();
					datePlanifieeIntervention = intervention.getDatePlanifiee();
					statutIntervention = intervention.getStatut();
				}
			}
			return SUCCESS;
		}
		return ERROR;
	}
	
	
	// Fonction de sauvegarde d'un intervention
	public String saveIntervention(){
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  ){
			Intervention itv = iusers.findInterventionBYId(interventionID);
			if (itv != null){
				itv.setNumIntervention(numIntervention);
				itv.setDatePlanifiee(datePlanifieeIntervention);
				itv.setCommentaire(comIntervention);
				itv.setStatut(statutIntervention);
				iusers.save(itv);
				return SUCCESS;
			}
//			if(!numIntervention.trim().isEmpty() && !comIntervention.trim().isEmpty())
//			{
//				Intervention it = new Intervention(interventionID, numIntervention, datePlanifieeIntervention, new Date(), statutIntervention, comIntervention);
//				//it = iusers.editIntervention(it);
//				return SUCCESS;
//			}
			return ERROR;
		}
		return ERROR;

	}
	
	
	public String search(){
		return SUCCESS;
	}
	
	public String recherche(){
		  //message = "bonjour, il est " + new Date() + "-Nom->"+interventionStatut;
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  ){
			if (statutIntervention != -1){
				interV =  iusers.findInterventionbyStatut(statutIntervention);
				return SUCCESS;
			}
			interV = iusers.findAllIntervention();
			return SUCCESS;
			
		}
		return ERROR;
	}
}
