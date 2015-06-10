package actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;









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
	
	public Map<String, Object> getSession() {return session;}
	
	public List<Intervenant> getIntervenants() {
		return iusers.findAllIntervenant();
	}

	public void setIntervenants(List<Intervenant> intervenants) {
		this.intervenants = intervenants;
	}
	
	public List<Materiel> getMateriels() {
		System.out.println("Admin action : " +iemplacementMateriel.findAllMateriel().size());
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
				iv = iusers.addIntervenant(iv);
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
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}
}
