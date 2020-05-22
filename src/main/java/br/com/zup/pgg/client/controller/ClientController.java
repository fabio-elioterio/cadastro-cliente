package br.com.zup.pgg.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.pgg.client.model.Client;
import br.com.zup.pgg.client.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	ClientService clienteService;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(path = "/clientes")
	public Client clientPost(@RequestBody Client client) {

		return this.clienteService.clientInsert(client);
	}

	@GetMapping(path = "/clientes", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Client> getCliet() {

		return this.clienteService.getClients();
	}

	@GetMapping(path = "/clientes/{cpf}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Client getByCpf(@PathVariable String cpf) {

		return this.clienteService.getClientByCpf(cpf);
	}

	@PutMapping(path = "/clientes/{cpf}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Client putClient(@PathVariable String cpf, @RequestBody Client upDateClient) {
		this.clienteService.puClient(upDateClient, cpf);
		return upDateClient;
	}

	@DeleteMapping(path = "/clientes/{cpf}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public void deleteClient(@PathVariable String cpf) {
		this.clienteService.delete(cpf);
	}

}
