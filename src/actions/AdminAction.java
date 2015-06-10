package actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;












import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;

import utils.IClient;
import utils.IEmplacementMateriel;
import utils.IGroupe;
import utils.IIntervenant;
import beans.Article;
import beans.Batiment;
import beans.Client;
import beans.Etage;
import beans.Groupe;
import beans.Intervenant;
import beans.Intervention;
import beans.Materiel;
import beans.Salle;
import beans.Site;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport implements SessionAware
{
	private Map<String, Object> session;
	private List<Intervenant> intervenants;
	private List<Materiel> materiels;
	private List<Site> sites;
	private List<Client> clients;
	private List<Article> articles;
	private List<Batiment> batiments;
	private List<Groupe> groupes;
	private List<Etage> etages;
	private List<Salle> salles;
	private List<Intervention> interventions;
	private IIntervenant iusers;
	private IGroupe igroup;
	private IEmplacementMateriel iemplacementMateriel;
	private IClient iclient;
	private int idIntervenant;
	private String nomIntervenant;
	private String prenomIntervenant;
	private String loginIntervenant;
	private String mdpIntervenant;
	private String groupeIntervenant;
	private List<Groupe> listGroupesIntervenant;
	private int idIntervention;
	private int idGroupe;
	private String libelleGroupe;
	private List<Intervenant> listIntervenantsGroupe;
	private int idClient;
	private String nomClient;
	private String emailClient;
	private String materielsClient;
	private List<Site> listSitesClient;
	private List<Materiel> listMaterielsClient;
	private int idSite;
	private String numSite;
	private List<Client> listClientsSite;
	
	
	public Map<String, Object> getSession() {return session;}
	
	public List<Intervenant> getIntervenants() {
		return iusers.findAllIntervenant();
	}

	public void setIntervenants(List<Intervenant> intervenants) {
		this.intervenants = intervenants;
	}
	
	public List<Materiel> getMateriels() {
		return iemplacementMateriel.findAllMateriel();
	}

	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}

	public List<Site> getSites() {
		return iemplacementMateriel.findAllSite();
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}
	
	public List<Client> getClients() {
		return iclient.findAllClient();
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<Batiment> getBatiments() {
		return iemplacementMateriel.findAllBatiments();
	}

	public void setBatiments(List<Batiment> batiments) {
		this.batiments = batiments;
	}
	
	public List<Groupe> getGroupes() {
		return igroup.findAllGroupe();
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}
	
	public List<Etage> getEtages() {
		return iemplacementMateriel.findAllEtage();
	}

	public void setEtages(List<Etage> etages) {
		this.etages = etages;
	}

	public List<Salle> getSalles() {
		return iemplacementMateriel.findAllSalle();
	}

	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}

	public List<Intervention> getInterventions() {
		return iusers.findAllIntervention();
	}

	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}

	public IIntervenant getIusers() {
		return iusers;
	}

	public void setIusers(IIntervenant iusers) {
		this.iusers = iusers;
	}

	public IGroupe getIgroup() {
		return igroup;
	}

	public void setIgroup(IGroupe igroup) {
		this.igroup = igroup;
	}

	public IEmplacementMateriel getIemplacementMateriel() {
		return iemplacementMateriel;
	}
	
	public IClient getIclient() {
		return iclient;
	}

	public void setIclient(IClient iclient) {
		this.iclient = iclient;
	}

	public void setIemplacementMateriel(IEmplacementMateriel iemplacementMateriel) {
		this.iemplacementMateriel = iemplacementMateriel;
	}

	public int getIdIntervenant() {
		return idIntervenant;
	}

	public void setIdIntervenant(int idIntervenant) {
		this.idIntervenant = idIntervenant;
	}

	public String getNomIntervenant() {
		return nomIntervenant;
	}

	public void setNomIntervenant(String nomIntervenant) {
		this.nomIntervenant = nomIntervenant;
	}

	public String getPrenomIntervenant() {
		return prenomIntervenant;
	}

	public void setPrenomIntervenant(String prenomIntervenant) {
		this.prenomIntervenant = prenomIntervenant;
	}

	public String getLoginIntervenant() {
		return loginIntervenant;
	}

	public void setLoginIntervenant(String loginIntervenant) {
		this.loginIntervenant = loginIntervenant;
	}

	public String getMdpIntervenant() {
		return mdpIntervenant;
	}

	public void setMdpIntervenant(String mdpIntervenant) {
		this.mdpIntervenant = mdpIntervenant;
	}

	public String getGroupeIntervenant() {
		return groupeIntervenant;
	}

	public void setGroupeIntervenant(String groupeIntervenant) {
		this.groupeIntervenant = groupeIntervenant;
	}
	
	public List<Groupe> getListGroupesIntervenant() {
		return listGroupesIntervenant;
	}

	public void setListGroupesIntervenant(List<Groupe> listGroupesIntervenant) {
		this.listGroupesIntervenant = listGroupesIntervenant;
	}

	public int getIdIntervention() {
		return idIntervention;
	}

	public void setIdIntervention(int idIntervention) {
		this.idIntervention = idIntervention;
	}
	
	public int getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(int idGroupe) {
		this.idGroupe = idGroupe;
	}

	public String getLibelleGroupe() {
		return libelleGroupe;
	}

	public void setLibelleGroupe(String libelleGroupe) {
		this.libelleGroupe = libelleGroupe;
	}

	public List<Intervenant> getListIntervenantsGroupe() {
		return listIntervenantsGroupe;
	}

	public void setListIntervenantsGroupe(List<Intervenant> listIntervenantsGroupe) {
		this.listIntervenantsGroupe = listIntervenantsGroupe;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	public String getMaterielsClient() {
		return materielsClient;
	}

	public void setMaterielsClient(String materielsClient) {
		this.materielsClient = materielsClient;
	}

	public List<Site> getListSitesClient() {
		return listSitesClient;
	}

	public void setListSitesClient(List<Site> listSitesClient) {
		this.listSitesClient = listSitesClient;
	}

	public List<Materiel> getListMaterielsClient() {
		return listMaterielsClient;
	}

	public void setListMaterielsClient(List<Materiel> listMaterielsClient) {
		this.listMaterielsClient = listMaterielsClient;
	}

	public int getIdSite() {
		return idSite;
	}

	public void setIdSite(int idSite) {
		this.idSite = idSite;
	}

	public String getNumSite() {
		return numSite;
	}

	public void setNumSite(String numSite) {
		this.numSite = numSite;
	}

	public List<Client> getListClientsSite() {
		return listClientsSite;
	}

	public void setListClientsSite(List<Client> listClientsSite) {
		this.listClientsSite = listClientsSite;
	}

	public String index(){
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  ){
			
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String editIntervenant(){
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  ){
			if( idIntervenant > 0){
				Intervenant i = iusers.find(idIntervenant);
				if( i != null){
					nomIntervenant = i.getNom();
					prenomIntervenant = i.getPrenom();
					loginIntervenant = i.getLogin();
					mdpIntervenant = i.getMdp();
					listGroupesIntervenant = i.getGroupes();
				}
			}
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String save(){
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  ){
			groupes = igroup.findAllGroupe();
			if(!nomIntervenant.trim().isEmpty() && !prenomIntervenant.trim().isEmpty() && !loginIntervenant.trim().isEmpty() && !mdpIntervenant.trim().isEmpty() && !groupeIntervenant.equals("") && groupeIntervenant != null ){
				List<Groupe> grp = new ArrayList<Groupe>();
				String[] tabGrp = groupeIntervenant.split(",");
				for (String string : tabGrp) {
					grp.add(igroup.findById(Integer.parseInt(string.trim())));
				}
				Intervenant iv = new Intervenant(idIntervenant, nomIntervenant, prenomIntervenant, loginIntervenant, mdpIntervenant);
				iv.setGroupes(grp);
				iv = iusers.editIntervenant(iv);
				return SUCCESS;
			}
			return ERROR;
		}
		return ERROR;
	}
	
	public String deleteIntervenant(){
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  ){
			Intervenant it = iusers.find(idIntervenant);
			if(it != null)
			{
				if(it.getInterventions().size()==0)
				{
					iusers.deleteIntervenant(it);
				}
			}
			return SUCCESS;
		}
		return LOGIN;
	}
	
	public String deleteIntervention(){
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  ){
			Intervention it = iusers.findInterventionBYId(idIntervention);
			if(it != null)
			{
				iusers.deleteIntervention(it);
			}
			return SUCCESS;
		}
		return LOGIN;
	}
	
	public String editGroupe(){
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  ){
			if( idGroupe > 0){
				Groupe g = igroup.findById(idGroupe);
				if( g != null){
					libelleGroupe = g.getLibelle();
					listIntervenantsGroupe = g.getIntervenants();
				}
			}
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String saveGroupe(){
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  ){
			if(!libelleGroupe.trim().isEmpty()){
				Groupe g = new Groupe(idGroupe, libelleGroupe);
				g = igroup.editGroupe(g);
				return SUCCESS;
			}
			return ERROR;
		}
		return ERROR;
	}
	
	public String deleteGroupe(){
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  ){
			Groupe g = igroup.findById(idGroupe);
			if(g != null)
			{
				igroup.deleteGroupe(g);
			}
			return SUCCESS;
		}
		return LOGIN;
	}
	
	public String editClient(){
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  ){
			if( idClient > 0){
				Client c = iclient.findById(idClient);
				if( c != null){
					nomClient = c.getNom();
					emailClient = c.getEmail();
					listMaterielsClient = new ArrayList(c.getMateriels());
					listSitesClient = new ArrayList (c.getSites());
				}
			}
			return SUCCESS;
		}
		return LOGIN;
	}
	
	public String saveClient(){
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  )
		{
			if(!nomClient.trim().isEmpty() && !emailClient.trim().isEmpty() && (materielsClient != null && !materielsClient.equals(""))){
				Client c = new Client(idClient, nomClient, emailClient);
				Set<Materiel> listChoixMateriels = new HashSet<Materiel>();
				String[] tabMateriel = materielsClient.split(",");
				for (String string : tabMateriel) {
					Materiel m1 = iemplacementMateriel.findMaterielById(Integer.parseInt(string.trim()));
					listChoixMateriels.add(m1);
				}
				c.setMateriels(listChoixMateriels);
				
				Set<Site> listChoixSites = new HashSet<Site>();
				for (Materiel m : listChoixMateriels) {
					listChoixSites.add(iemplacementMateriel.findSiteById( m.getSalle().getEtage().getBatiment().getSite().getId()));					
				}			
				c.setSites(listChoixSites);
				c = iclient.editClient(c);
				return SUCCESS;
			}
			return ERROR;
		}
		return LOGIN;
	}
	
	public String deleteClient(){
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  ){
			Client c = iclient.findById(idClient);
			if(c != null)
			{
				if(c.getMateriels().size() == 0)
				{
					iemplacementMateriel.deleteClient(c);
				}
			}
			return SUCCESS;
		}
		return LOGIN;
	}
	
	public String editSite(){
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  ){
			if( idSite > 0){
				Site s = iemplacementMateriel.findSiteById(idSite);
				if( s != null){
					numSite = s.getNumSite();
					listClientsSite = s.getClients();
				}
			}
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String saveSite(){
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  ){
			if(!numSite.trim().isEmpty()){
				Site s = new Site(idSite, numSite);
				s = iemplacementMateriel.editSite(s);
				return SUCCESS;
			}
			return ERROR;
		}
		return ERROR;
	}
	
	public String deleteSite(){
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  ){
			Site s = iemplacementMateriel.findSiteById(idSite);
			if(s != null)
			{
				iemplacementMateriel.deleteSite(s);
			}
			return SUCCESS;
		}
		return LOGIN;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}
}
