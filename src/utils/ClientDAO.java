package utils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import beans.Client;

public class ClientDAO implements IClient
{
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Client findById(int id) {
		return entityManager.find(Client.class, id);
	}
}
