package utils;

import java.util.List;

import beans.Client;

public interface IClient
{
	public List<Client> findAllClient();
	public Client findById(int id);
	public Client editClient(Client c);
	public void deleteClient(Client c);
}
