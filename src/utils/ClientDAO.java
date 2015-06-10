package utils;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public List<Client> findAllClient() {
		return entityManager.createQuery("FROM Client", Client.class).getResultList();
	}

	@Transactional
	public Client editClient(Client c) {
		if(c == null) return c;
		if(c.getId() > 0){
			entityManager.merge(c);
		}
		else entityManager.persist(c);
		return c;
	}

	@Override
	public void deleteClient(Client c) {
		entityManager.remove(c);
	}
	
	
}
