package br.inatel.pos.dm110.impl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.poc.mobile.dm110.interfaces.ClientRemote;
import br.inatel.pos.dm110.api.ClientService;

@RequestScoped
public class ClientServiceImpl implements ClientService {

	@EJB(lookup="java:app/dm110-ejb-1.0.0-SNAPSHOT/ClientBean!br.inatel.poc.mobile.dm110.interfaces.ClientRemote")
	private ClientRemote clientBean;
	
	@Override
	public void addNewClient(String clientName , String clientEmail) {
		clientBean.addNewClient( clientName , clientEmail);
	}

	@Override
	public String[] listClients() {
		return clientBean.listClients();
	}



}
