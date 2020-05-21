package br.com.zup.pgg.client.service;

import java.util.List;

import br.com.zup.pgg.client.dao.ClientDao;
import br.com.zup.pgg.client.model.Client;

public class ClientService {
	
	ClientDao clientDao = new ClientDao();
	
	public void clientInsert(Client client) {
		
		clientDao.clientInsert(client);
		
	}
	
	public List<Client> getClients() {
		return clientDao.listaClientes();
	}

	public Client getClientByCpf(String cpf) {
		return clientDao.getClientByCpf(cpf);
	}
}
