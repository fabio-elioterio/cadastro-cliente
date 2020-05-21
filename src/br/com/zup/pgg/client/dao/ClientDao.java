package br.com.zup.pgg.client.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.zup.pgg.client.factory.ConnectionFactory;
import br.com.zup.pgg.client.model.Client;

public class ClientDao {

	Connection conn = new ConnectionFactory().getConnection();

	public void clientInsert(Client cliente) {

		String sql = " insert into cliente " + "(name, age, cpf, email, telephone, address)"
				+ " values (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, cliente.getName());
			stmt.setInt(2, cliente.getAge());
			stmt.setString(3, cliente.getCpf());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getTelephone());
			stmt.setString(6, cliente.getAddress());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Client> listaClientes() {
		Client cliente = new Client();
		List<Client> clienteLista = new ArrayList<>();
		String sql = "select * from cliente";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				cliente.setName(rs.getString("name"));
				cliente.setAge(rs.getInt("age"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEmail(rs.getString("email"));
				cliente.setTelephone(rs.getString("telephone"));

				clienteLista.add(cliente);
			}

			stmt.close();
		} catch (SQLException e) {

		}
		return clienteLista;

	}
	
	public Client getClientByCpf(String cpf) {
		
		String sql = "select * from cliente where cpf = ?";
		Client client = new Client();
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, cpf);
			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				client.setName(result.getString("name"));
				client.setAge(result.getInt("age"));
				client.setCpf(result.getString("cpf"));
				client.setEmail(result.getString("email"));
				client.setTelephone(result.getString("telephone"));
			}
			
			result.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return client;
	}
}
