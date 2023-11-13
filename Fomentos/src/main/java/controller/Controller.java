package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

/**
 * Servlet implementation class ValidacaoLogin
 */
@WebServlet(urlPatterns = { "/Logar", "/insert", "/validar" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans usuario = new JavaBeans();

	public Controller() {
		super();
	}

	// Metodo de decisão e direcionamento para prosseguimento seguinte
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath(); // Armazena o caminho da requisição.
		System.out.println(action);
		if (action.equals("/Logar")) {
			System.out.println("Entrou");
			validacaoLogin(request, response);
		} else if (action.equals("/insert")) {
			novoUsuario(request, response);
		} else if (action.equals("/validar")) {
			validarCPF(request, response);
		}
	}

	// Metodo para adicionar novo Usuario
	protected void novoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Teste de recebimento dos dados do formulário.
//		System.out.println(request.getParameter("nome"));
//		System.out.println(request.getParameter("email"));
//		System.out.println(request.getParameter("senha"));
//		System.out.println(request.getParameter("cpf"));
		// Setar as variáveis JavaBeans.
		usuario.setNome_usuario(request.getParameter("nome"));
		usuario.setEmail_usuario(request.getParameter("email"));
		usuario.setSenha_usuario(request.getParameter("senha"));
		usuario.setCpf_usuario(request.getParameter("cpf"));

		// Invocar o método inserirUsuario passando o objeto contato.
		dao.inserirUsuario(usuario);
		// Redirecionar para o documento login.html
		response.sendRedirect("tela-de-login.html");
	}

	// Metodo para validar login do Usuario
	protected void validacaoLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Varioaveis utilizadas para validar login
		String emailDigitado = request.getParameter("email");
		String senhaDigitada = request.getParameter("senha");
		String emailValidado = null;
		String senhaValidada = null;
		// Criando um objeto para receber os dados javaBeans
		ArrayList<JavaBeans> lista = dao.validacaoLogin();
		// Retirada de itens da lista para comparação
		for (int i = 0; i < lista.size(); i++) {
			// Teste de recebimento de dados
			System.out.println(lista.get(i).getId_usuario());
			System.out.println(lista.get(i).getEmail_usuario());
			System.out.println(lista.get(i).getSenha_usuario());
			if (emailDigitado.equals(lista.get(i).getEmail_usuario())
					&& senhaDigitada.equals(lista.get(i).getSenha_usuario())) {
				emailValidado = lista.get(i).getEmail_usuario();
				senhaValidada = lista.get(i).getSenha_usuario();
			}

		}
		// Redirecionamento para pagina devida
		if (emailDigitado.equals(emailValidado) && senhaDigitada.equals(senhaValidada)) {
			response.sendRedirect("pagina_pos_login.html");
		} else {
			response.sendRedirect("termos-uso.html");
		}
	}

	// validador de CPF
	
	protected void validarCPF(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		usuario.setCpf_compra(request.getParameter("cpf")); // Substitua pelo CPF que deseja validar
		String validandocpf = request.getParameter("cpf");
		String compra = null;
		usuario.setCpf_compra(validandocpf);
		boolean validado = false;
		if (validandocpf != compra) {
			System.out.println("CPF válido.");
			
			validandocpf = validandocpf.replaceAll("[^0-9]", ""); // Remove caracteres não numéricos

			if (validandocpf.length() != 11) {
				validado = false;
			}

			int[] digitos = new int[11];
			for (int i = 0; i < 11; i++) {
				digitos[i] = Character.getNumericValue(validandocpf.charAt(i));
			}

			// Verifica o primeiro dígito verificador
			int soma = 0;
			for (int i = 0; i < 9; i++) {
				soma += digitos[i] * (10 - i);
			}
			int resto = soma % 11;
			int digitoVerificador1 = (resto < 2) ? 0 : 11 - resto;
			if (digitos[9] != digitoVerificador1) {
				validado = false;
			}

			// Verifica o segundo dígito verificador
			soma = 0;
			for (int i = 0; i < 10; i++) {
				soma += digitos[i] * (11 - i);
			}
			resto = soma % 11;
			int digitoVerificador2 = (resto < 2) ? 0 : 11 - resto;
			if (digitos[10] != digitoVerificador2) {
				validado = false;
			}

			validado = true;
			if (validado = true) {
				response.sendRedirect("pag-confimado.html");
			}
		} else {
			System.out.println("CPF inválido.");
			response.sendRedirect("Pagamentos.html");
		}
	}

	private boolean validarCPF(String validandocpf) {
		// TODO Auto-generated method stub
		return false;
	}

}