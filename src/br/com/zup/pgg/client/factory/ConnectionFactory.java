package br.com.zup.pgg.client.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			return DriverManager.getConnection("jdbc:mysql://localhost:3306/cliente?user=root"
					+ "&password=root&useTimezone=true&serverTimezone=UTC");

		} catch (SQLException e) {

			throw new RuntimeException(e);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	} 
}
