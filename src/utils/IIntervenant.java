package utils;

import java.util.Date;
import java.util.List;

import beans.Intervenant;
import beans.Intervention;

public interface IIntervenant
{
	public List<Intervenant> findAllIntervenant();
	public Intervenant find(String login,String pass);
	public Intervenant find(int id);
	public List<Intervention> findAllIntervention();
	public Intervention findInterventionBYId(int id);
	public Intervenant editIntervenant(Intervenant iv);
	public Intervention addIntervention(Intervention iv);
	public Intervention save(Intervention intervention);
	public List<Intervention> findInterventionbyStatut(int statut);
	public List<Intervention> findInterventionbySite(int site);
	public List<Intervention> findInterventionbyClient(int client);
	public List<Intervention> findInterventionbyDateCreation(Date dateCreation);
	public void deleteIntervenant(Intervenant it);
	public void deleteIntervention(Intervention it);
}
