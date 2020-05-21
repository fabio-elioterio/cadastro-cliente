package br.com.zup.pgg.client.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.zup.pgg.client.model.Client;
import br.com.zup.pgg.client.service.ClientService;

@WebServlet(urlPatterns = "/clientes")
public class ClientController extends HttpServlet {

	private static final String CLIENTE_INSERIDO = "\nCliente inserido com sucesso!";
	private static final String ERRO_AO_INSERIR_CLIENTE = "Cliente ja existe ou o campo cpf está nulo";
	private static final long serialVersionUID = 1L;
	static ClientService clienteService = new ClientService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String cpf = req.getParameter("cpf");

		if (cpf != null) {

			buscaCliente(req, resp);

		} else {

			for (Client cliente : clienteService.getClients()) {
				writer.println("----------------------------");
				writer.println("                            ");
				writer.println("Name: " + cliente.getName());
				writer.println("Age: " + cliente.getAge());
				writer.println("Email: " + cliente.getEmail());
				writer.println("Cpf: " + cliente.getCpf());
				writer.println("Telephone: " + cliente.getTelephone());
				writer.println("Address: " + cliente.getAddress());
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String cpf = request.getParameter("cpf");

		Client cliente = new Client();
		if (cpf != "") {
			cliente.setName(request.getParameter("name"));
			cliente.setAge(Integer.parseInt(request.getParameter("age")));
			cliente.setCpf(request.getParameter("cpf"));
			cliente.setEmail(request.getParameter("email"));
			cliente.setTelephone(request.getParameter("telephone"));
			cliente.setAddress(request.getParameter("address"));

			clienteService.clientInsert(cliente);

			response.getWriter()
					.print("nome: " + cliente.getName() + "\nage: " + cliente.getAge() + "\ncpf: " + cliente.getCpf()
							+ "\nemail: " + cliente.getEmail() + "\ntelephone: " + cliente.getTelephone()
							+ "\naddress: " + cliente.getAddress());
			writer.print(CLIENTE_INSERIDO);

		} else {
			//TODO: validar erro com mesmo cpf
			writer.print(ERRO_AO_INSERIR_CLIENTE);

		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		Client clientToUpDate = new Client();
		PrintWriter writer = response.getWriter();

		if (cpf != null) {

			clientToUpDate.setName(request.getParameter("name"));
			clientToUpDate.setAge(Integer.parseInt(request.getParameter("age")));
			clientToUpDate.setEmail(request.getParameter("email"));
			clientToUpDate.setTelephone(request.getParameter("telephone"));
			clientToUpDate.setAddress(request.getParameter("address"));

			clienteService.puClient(clientToUpDate, cpf);

			response.getWriter();
			writer.print("name: " + clientToUpDate.getName() + "\nage: " + clientToUpDate.getAge() + "\ncpf: "
					+ clientToUpDate.getCpf() + "\nemail: " + clientToUpDate.getEmail() + "\ntelephone: "
					+ clientToUpDate.getTelephone() + "\naddress: " + clientToUpDate.getAddress() + "\n");

		} else {

			writer.print("CPF NAO ENCONTRADO!");
		}
		writer.print("Cliente Atualizado com sucesso!");
	}

	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cpf = req.getParameter("cpf");
		clienteService.delete(cpf);

	}

	public static void buscaCliente(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter writer = resp.getWriter();
		String cpf = req.getParameter("cpf");
		Client clienteBuscado = clienteService.getClientByCpf(cpf);
		writer.println("Name: " + clienteBuscado.getName());
		writer.println("Age: " + clienteBuscado.getAge());
		writer.println("Email: " + clienteBuscado.getEmail());
		writer.println("Cpf: " + clienteBuscado.getCpf());
		writer.println("Telephone: " + clienteBuscado.getTelephone());
		writer.println("Age: " + clienteBuscado.getAddress());
	}
}
