package br.inatel.poc.mobile.dm110.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.inatel.poc.mobile.dm110.entities.Client;

@Stateless
public class ClientDAO {

	@PersistenceContext(unitName = "inventory")
	private EntityManager em;
	
	public void insert(Client client) {
		em.persist(client);
	}
	
	public List<Client> findAll(){
		return em.createQuery("from Client c", Client.class).getResultList();
	}
}