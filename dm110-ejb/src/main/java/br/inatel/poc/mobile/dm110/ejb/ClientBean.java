package br.inatel.poc.mobile.dm110.ejb;

import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.poc.mobile.dm110.dao.ClientDAO;

import br.inatel.poc.mobile.dm110.entities.Client;

import br.inatel.poc.mobile.dm110.interfaces.ClientLocal;
import br.inatel.poc.mobile.dm110.interfaces.ClientRemote;

@Stateless
@Local(ClientLocal.class)
@Remote(ClientRemote.class)
public class ClientBean implements ClientLocal , ClientRemote {

	@EJB
	private ClientDAO dao;
	
	@Override
	public void addNewClient(String clientName , String clientEmail) {			
		Client client = new Client();
		client.setName(clientName);
		client.setEmail(clientEmail);
		dao.insert(client);
	}

	@Override
	public String[] listClients() {		
		return dao.findAll().stream().map(Client::toString).collect(Collectors.toList()).toArray(new String[0]);
	}
}
