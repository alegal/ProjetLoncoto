package actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import utils.IEmplacementMateriel;
import beans.Batiment;
import beans.Etage;
import beans.Materiel;
import beans.Salle;
import beans.Site;

import com.opensymphony.xwork2.ActionSupport;

public class EmplacementAction extends ActionSupport implements SessionAware
{	
	private List<Site> sites;
	private List<Batiment> Batiments;
	private List<Etage> Etages;
	private List<Salle> salles;
	private Materiel materiel;
	private List<Materiel> materiels;
	public IEmplacementMateriel emplacementDAO;
	
	// Propriétés
	private int siteID;
	private int batimentID;
	private String numBatiment;
	private int etageID;
	private String numEtage;
	private int salleID;
	private String numSalle;
	private int materielID;
	private String numSerie;
	
	
	// Accesseurs
	
	public List<Site> getSites() {
		return sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}

	public List<Batiment> getBatiments() {
		return Batiments;
	}

	public void setBatiments(List<Batiment> batiments) {
		Batiments = batiments;
	}

	public List<Etage> getEtages() {
		return Etages;
	}

	public void setEtages(List<Etage> etages) {
		Etages = etages;
	}

	public List<Salle> getSalles() {
		return salles;
	}

	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	public List<Materiel> getMateriels() {
		return materiels;
	}

	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}

	public IEmplacementMateriel getEmplacementDAO() {
		return emplacementDAO;
	}

	public void setEmplacementDAO(IEmplacementMateriel emplacementDAO) {
		this.emplacementDAO = emplacementDAO;
	}

	public int getSiteID() {
		return siteID;
	}

	public void setSiteID(int siteID) {
		this.siteID = siteID;
	}

	public int getBatimentID() {
		return batimentID;
	}

	public void setBatimentID(int batimentID) {
		this.batimentID = batimentID;
	}

	public String getNumBatiment() {
		return numBatiment;
	}

	public void setNumBatiment(String numBatiment) {
		this.numBatiment = numBatiment;
	}

	public int getEtageID() {
		return etageID;
	}

	public void setEtageID(int etageID) {
		this.etageID = etageID;
	}

	public String getNumEtage() {
		return numEtage;
	}

	public void setNumEtage(String numEtage) {
		this.numEtage = numEtage;
	}

	public int getSalleID() {
		return salleID;
	}

	public void setSalleID(int salleID) {
		this.salleID = salleID;
	}

	public String getNumSalle() {
		return numSalle;
	}

	public void setNumSalle(String numSalle) {
		this.numSalle = numSalle;
	}

	public int getMaterielID() {
		return materielID;
	}

	public void setMaterielID(int materielID) {
		this.materielID = materielID;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	
	// Function de création
	public String create(String nomTb){
		return SUCCESS;
	}
	
	public String Liste(){
		//images = imageModel.find();
		return SUCCESS;
	}
	
	public String edit(){
		return SUCCESS;
	}
	
	public String save(){
		return SUCCESS;
	}
	
	public String DetailMateriel(){
		materiel = emplacementDAO.findMaterielById(materielID);
		return SUCCESS;
	}
	

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
}
