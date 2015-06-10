package utils;

import java.util.List;

import beans.Batiment;
import beans.Etage;
import beans.Materiel;
import beans.Site;

public interface IEmplacementMateriel
{
	public List<Site> findAllSite();
	public List<Site> findByBatiment();
	public List<Batiment> findAllBatiments();
	public List<Etage> findAllEtage();
	public Materiel findMaterielById(int id);
	public List<Materiel> findAllMateriel();
}
