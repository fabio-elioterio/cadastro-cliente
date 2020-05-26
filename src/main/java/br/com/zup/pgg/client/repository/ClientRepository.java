package br.com.zup.pgg.client.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.pgg.client.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, String> {

	Optional<Client> findByCpf(String cpf);
}
