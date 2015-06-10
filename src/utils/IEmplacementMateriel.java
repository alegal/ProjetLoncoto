package utils;

import java.util.List;

import beans.Batiment;
import beans.Etage;
import beans.Intervenant;
import beans.Intervention;
import beans.Materiel;
import beans.Salle;
import beans.Site;

public interface IEmplacementMateriel
{
	public List<Site> findAllSite();
	public List<Site> findByBatiment();
	public List<Batiment> findAllBatiments();
	public List<Etage> findAllEtage();
	public List<Salle> findAllSalle();
	public List<Materiel> findAllMateriel();
	public Materiel findMaterielById(int id);
	public Site findSiteById(int id);
	public Site editSite(Site s);
	public void deleteSite(Site s);
}
