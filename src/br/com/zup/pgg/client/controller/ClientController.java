package br.com.zup.pgg.client.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

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
	private static final String CLIENTE_JA_EXISTE = "Cliente ja existe";
	private static final String CPF_NULO = "cpf nulo";
	private static final long serialVersionUID = 1L;
	static Map<String, Client> listaDeCliente = new HashMap<String, Client>();
	ClientService clienteService = new ClientService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String cpf = req.getParameter("cpf");

		if (cpf != null) {

			if (listaDeCliente.containsKey(cpf)) {

				buscaCliente(req, resp);

			} else {

				writer.print("CPF NÃO ENCONTRADO!");
			}

		} else {
			for (Client cliente : clienteService.getClients()) {
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

			if (!listaDeCliente.containsKey(cpf)) {

				clienteService.clientInsert(cliente);

				response.getWriter()
						.print("nome :" + cliente.getName() + "\nage :" + cliente.getAge() + "\ncpf :"
								+ cliente.getCpf() + "\nemail :" + cliente.getEmail() + "\ntelephone :"
								+ cliente.getTelephone() + "\naddress :" + cliente.getAddress());
				writer.print(CLIENTE_INSERIDO);

			}

			writer.print(CLIENTE_JA_EXISTE);

		} else {

			writer.print(CPF_NULO);
		}

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		Client clienteBuscado = listaDeCliente.get(cpf);
		PrintWriter writer = response.getWriter();

		if (cpf != null) {

			if (listaDeCliente.containsKey(cpf)) {

				clienteBuscado.setName(request.getParameter("name"));
				clienteBuscado.setAge(Integer.parseInt(request.getParameter("age")));
				clienteBuscado.setEmail(request.getParameter("email"));
				clienteBuscado.setTelephone(request.getParameter("telephone"));
				clienteBuscado.setAddress(request.getParameter("address"));

				listaDeCliente.put(cpf, clienteBuscado);
				response.getWriter();
				writer.print("name :" + clienteBuscado.getName() + "\nage :" + clienteBuscado.getAge() + "\ncpf :"
						+ clienteBuscado.getCpf() + "\nemail :" + clienteBuscado.getEmail() + "\ntelephone :"
						+ clienteBuscado.getTelephone() + "\naddress :" + clienteBuscado.getAddress());

			} else {

				writer.print("CPF NAO ENCONTRADO!");
			}
			writer.print("Cliente Atualizado com sucesso!");
		}
	}

//	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String cpf = req.getParameter("cpf");
//		clienteService.deleteCliente(cpf);
//
//	}
//
	public static void buscaCliente(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter writer = resp.getWriter();
		String cpf = req.getParameter("cpf");
		Client clienteBuscado = listaDeCliente.get(cpf);
		writer.println("Name: " + clienteBuscado.getName());
		writer.println("Age: " + clienteBuscado.getAge());
		writer.println("Email: " + clienteBuscado.getEmail());
		writer.println("Cpf: " + clienteBuscado.getCpf());
		writer.println("Telephone: " + clienteBuscado.getTelephone());
		writer.println("Age: " + clienteBuscado.getAddress());
	}
}
