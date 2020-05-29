package br.com.zup.pgg.client.entity;

import javax.persistence.*;

@Entity
public class Client {

	@Id
	@Column(nullable = false)
	private String cpf;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private int age;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String telephone;

	@Column(nullable = false)
	private String address;

	public Client() {

	}

	public Client(String cpf, String name, int age, String email, String telephone, String address) {
		this.cpf = cpf;
		this.name = name;
		this.age = age;
		this.email = email;
		this.telephone = telephone;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
