package utils;

import java.util.List;

import beans.Groupe;

public interface IGroupe
{
	public List<Groupe> findAllGroupe();
	public Groupe findById(int id);
	public Groupe editGroupe(Groupe g);
	public void deleteGroupe(Groupe g);
}
