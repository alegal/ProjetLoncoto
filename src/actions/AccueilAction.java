package actions;

import java.util.Map;
import java.util.Random;

import utils.*;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AccueilAction extends ActionSupport implements SessionAware
{
	private Map<String, Object> session;
	private IIntervenant iintervenant;
	private IClient iclient;
	
	public Map<String, Object> getSession() {return session;}
	
	public IIntervenant getIintervenant() {
		return iintervenant;
	}

	public void setIintervenant(IIntervenant iintervenant) {
		this.iintervenant = iintervenant;
	}

	public IClient getIclient() {
		return iclient;
	}

	public void setIclient(IClient iclient) {
		this.iclient = iclient;
	}
	
	
	public String index(){

		Random rd = new Random();
		/*
		for (int i = 0; i <= 10; i++) {
			Intervention iv = new Intervention(0, "intervention "+i, new Date(), new Date(), (rd.nextInt(3)+1), "Commentaire test "+i);
			iv.setClient(iclient.findById(rd.nextInt(3)+1));
			iv.setIntervenant(iusers.find(rd.nextInt(3)+1));
			System.out.println(iv.getClient().getNom());
			iusers.addIntervention(iv);
		}
		 */
		if(session.get("login") != null && session.get("password") != null && !session.get("login").equals("") && !session.get("password").equals("")){
			return SUCCESS;
		}
		return ERROR;
		
	}
	
	public String destruct(){
		if(session != null){
			session.clear();
		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
		
	}
}
