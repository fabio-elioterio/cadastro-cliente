package br.com.zup.pgg.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.pgg.client.dto.MensagemDto;
import br.com.zup.pgg.client.entity.Client;
import br.com.zup.pgg.client.exception.ClientException;
import br.com.zup.pgg.client.repository.ClientRepository;

@Service
public class ClientService {

	private static final String CPF_NÃO_ENCONTRADO = "CPF não encontrado.";
	private static final String CLIENTE_DELETADO_COM_SUCESSO = "Cliente deletado com sucesso!!!";
	@Autowired
	ClientRepository repository;

	public Client clientInsert(Client client) {

		return this.repository.save(client);
	}

	public List<Client> getClients() {
		return (List<Client>) repository.findAll();
	}

	public Client getClientByCpf(String cpf) throws ClientException {

		Client clientByDB = repository.findByCpf(cpf).orElseThrow(() -> new ClientException(CPF_NÃO_ENCONTRADO));

		return clientByDB;
	}

	public Client puClient(Client client, String cpf) {
		Client clientByDB = repository.findById(cpf).get();

		clientByDB.setAddress(client.getAddress());
		clientByDB.setAge(client.getAge());
		clientByDB.setEmail(client.getEmail());
		clientByDB.setTelephone(client.getTelephone());

		return this.repository.save(clientByDB);
	}

	public MensagemDto delete(String cpf) {
		this.repository.deleteById(cpf);
		return new MensagemDto(CLIENTE_DELETADO_COM_SUCESSO);
	}
}
