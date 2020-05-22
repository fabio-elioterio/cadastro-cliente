package br.com.zup.pgg.client.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.zup.pgg.client.dao.ClientDao;
import br.com.zup.pgg.client.model.Client;

@Service
public class ClientService {

	ClientDao clientDao = new ClientDao();

	public Client clientInsert(Client client) {

		return this.clientDao.clientInsert(client);
	}

	public List<Client> getClients() {
		return clientDao.listaClientes();
	}

	public Client getClientByCpf(String cpf) {

		return clientDao.getClientByCpf(cpf);
	}

	public Client puClient(Client client, String cpf) {
				
		clientDao.putClient(cpf, client);
		return client;
	}

	public void delete(String cpf) {
		clientDao.delete(cpf);
	}
}
