package br.com.zup.pgg.client.test;

import br.com.zup.pgg.client.entity.Client;
import br.com.zup.pgg.client.repository.ClientRepository;
import org.assertj.core.api.Assertions;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void createShouldPersistData() {

        //cenário
        Client client = new Client("0123456789X", "Juliana", 25, "juliana.78@gmail.com",
                "2569-4535", "Rua Alarico de Toledo Piza, 28A");

        //ação
        this.clientRepository.save(client);

        //verificação
        Assertions.assertThat(client.getCpf()).isNotNull().isEqualTo("0123456789X");
        Assertions.assertThat(client.getName()).isEqualTo("Juliana");
        Assertions.assertThat(client.getAge()).isNotNull();
        Assertions.assertThat(client.getEmail()).isEqualTo("juliana.78@gmail.com");
        Assertions.assertThat(client.getTelephone()).isNotNull();
        Assertions.assertThat(client.getAddress()).isNotNull();
    }

    @Test
    public void deleteShouldRemoveData() {
        Client client = new Client("0123456789X", "Juliana", 25, "juliana.78@gmail.com",
                "2569-4535", "Rua Alarico de Toledo Piza, 28A");
        this.clientRepository.save(client);
        clientRepository.delete(client);

        Assertions.assertThat(clientRepository.findById(client.getCpf())).isEmpty();
    }

    @Test
    public void upDateShouldChangeAndPersistData() {
        Client client = new Client("0123456789X", "Juliana", 25, "juliana.78@gmail.com",
                "2569-4535", "Rua Alarico de Toledo Piza, 28A");
        this.clientRepository.save(client);
        client.setName("Juliana Vieira");
        client.setAge(27);
        client.setAddress("Rua do Zenity");
        this.clientRepository.save(client);

        Assertions.assertThat(client.getName()).isEqualTo("Juliana Vieira");
        Assertions.assertThat(client.getAge()).isEqualTo(27);
        Assertions.assertThat(client.getAddress()).isEqualTo("Rua do Zenity");

    }
    @Test
    public void findByCpfShouldFindClient() {
        Client client = new Client("0123456789X", "Juliana", 25, "juliana.78@gmail.com",
                "2569-4535", "Rua do Zenity, 256");
        Client secondClient = new Client("507966948-93", "Fabio Junior", 19, "fabio.elioterio@zup.com.br",
                "95962-1891", "Rua Alarico de Toledo Piza, 28A");
        this.clientRepository.save(client);
        this.clientRepository.save(secondClient);

        Assertions.assertThat(clientRepository.findByCpf(secondClient.getCpf()).get());
    }

    @Test
    public void findClients() {
        Client client = new Client("0123456789X", "Juliana", 25, "juliana.78@gmail.com",
                "2569-4535", "Rua do Zenity, 256");
        Client secondClient = new Client("507966948-93", "Fabio Junior", 19, "fabio.elioterio@zup.com.br",
                "95962-1891", "Rua Alarico de Toledo Piza, 28A");
        this.clientRepository.save(client);
        this.clientRepository.save(secondClient);

        List<Client> clientList = (List<Client>) clientRepository.findAll();

        Assertions.assertThat(clientList.size()).isEqualTo(6);
    }

    @Test
    public void createWhenCpfIsNullShouldThrowConstraintViolationException() {
        thrown.expect(ConstraintViolationException.class);
        thrown.expectMessage("Oops! Parece que o CPF não foi inserido, por favor insera seu CPF.");

        Client client = new Client();
        client.setName("Fabio");
        client.setAddress("Rua Alarico de Toledo Piza, 28A");
        client.setAge(19);
        client.setEmail("fabio.elioterio@gmail.com");
        client.setTelephone("2569-4535");
        this.clientRepository.save(client);

    }

    @Test
    public void createWhenNameIsNullShouldThrowConstraintViolationException() {
        thrown.expect(ConstraintViolationException.class);
        thrown.expectMessage("Oops! Parece que o nome não foi inserido, por favor insera seu nome.");

        Client client = new Client();
        client.setCpf("50796694893");
        client.setAddress("Rua Alarico de Toledo Piza, 28A");
        client.setAge(19);
        client.setEmail("fabio.elioterio@gmail.com");
        client.setTelephone("2569-4535");
        this.clientRepository.save(client);

    }

    @Test
    public void createWhenAddressIsNullShouldThrowConstraintViolationException() {
        thrown.expect(ConstraintViolationException.class);
        thrown.expectMessage("Oops! Parece que o endereço não foi inserido, por favor insera seu endereço.");

        Client client = new Client();
        client.setName("Fabio");
        client.setCpf("50796694893");
        client.setAge(19);
        client.setEmail("fabio.elioterio@gmail.com");
        client.setTelephone("2569-4535");
        this.clientRepository.save(client);

    }

    @Test
    public void createWhenAgeIsNullShouldThrowConstraintViolationException() {
        thrown.expect(ConstraintViolationException.class);
        thrown.expectMessage("Oops! Parece que a idade não foi inserida, por favor insera sua idade.");

        Client client = new Client();
        client.setName("Fabio");
        client.setCpf("50796694893");
        client.setAddress("Rua Alarico de Toledo Piza, 28A");
        client.setEmail("fabio.elioterio@gmail.com");
        client.setTelephone("2569-4535");
        this.clientRepository.save(client);

    }

    @Test
    public void createWhenEmailIsNullShouldThrowConstraintViolationException() {
        thrown.expect(ConstraintViolationException.class);
        thrown.expectMessage("Oops! Parece que o email não foi inserido, por favor insera seu email.");

        Client client = new Client();
        client.setName("Fabio");
        client.setCpf("50796694893");
        client.setAge(19);
        client.setAddress("Rua Alarico de Toledo Piza, 28A");
        client.setTelephone("2569-4535");
        this.clientRepository.save(client);

    }

    @Test
    public void createWhenTelephoneIsNullShouldThrowConstraintViolationException() {
        thrown.expect(ConstraintViolationException.class);
        thrown.expectMessage("Oops! Parece que o telefone não foi inserido, por favor insera seu telefone.");

        Client client = new Client();
        client.setName("Fabio");
        client.setCpf("50796694893");
        client.setAge(19);
        client.setAddress("Rua Alarico de Toledo Piza, 28A");
        client.setEmail("fabio.elioterio@zup.com.br");
        this.clientRepository.save(client);

    }


}
