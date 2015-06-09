package actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import utils.IGroupe;
import utils.IIntervenant;
import beans.Groupe;
import beans.Intervenant;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport implements SessionAware
{
	private Map<String, Object> session;
	private List<Intervenant> intervenants;
	private IIntervenant iusers;
	private IGroupe igroup;
	private String nomIntervenant;
	private String prenomIntervenant;
	private String loginIntervenant;
	private String mdpIntervenant;
	private String groupeIntervenant;
	private List<Groupe> groupes;
	
	public Map<String, Object> getSession() {return session;}
	
	public List<Intervenant> getIntervenants() {
		return intervenants;
	}

	public void setIntervenants(List<Intervenant> intervenants) {
		this.intervenants = intervenants;
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

	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}


	public String index(){
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  ){
			intervenants = iusers.findAllIntervenant();
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String addIntervenant(){
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  ){
			groupes = igroup.findAllGroupe();
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String save(){
		if(session.get("login") != null && session.get("password") != null && session.get("login") != ""  ){
			groupes = igroup.findAllGroupe();
			if(!nomIntervenant.trim().isEmpty() && !prenomIntervenant.trim().isEmpty() && !loginIntervenant.trim().isEmpty() && !mdpIntervenant.trim().isEmpty() && !groupeIntervenant.equals("")){
				List<Groupe> grp = new ArrayList<Groupe>();
				String[] tabGrp = groupeIntervenant.split(",");
				for (String string : tabGrp) {
					grp.add(igroup.findById(Integer.parseInt(string.trim())));
				}
				Intervenant iv = new Intervenant(0, nomIntervenant, prenomIntervenant, loginIntervenant, mdpIntervenant);
				iv.setGroupes(grp);
				iv = iusers.addIntervenant(iv);
				return SUCCESS;
			}
			return ERROR;
		}
		return ERROR;
	}	
	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}
}
