package utils;

import java.util.List;

import beans.Intervention;
import beans.Materiel;


public interface IMateriel
{
	public List<Materiel> findAllMateriel();
	public Materiel find(int id);
	public Materiel addMateriel(Materiel mat);
	public Materiel save(Materiel mat);
}
