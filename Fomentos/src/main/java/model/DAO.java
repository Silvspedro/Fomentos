package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	// parâmetros de conexão

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/fomentos?useTimezone=true&sserverTimezone=UTC";
	private String user = "root";
	private String password = "Fist2737*";

	// Método de conexão
	protected Connection conectar() {
		Connection con = null; // Esse objeto será usado para estabelecer uma sessão com o banco de dados.
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password); // Para estabelecer a conexão com o banco de dados.
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void inserirUsuario(JavaBeans usuario) {
		String create = "insert into cadastro_usuario(NOME_USUARIO, EMAIL_USUARIO, SENHA_USUARIO, CPF_USUARIO) values (?, ?, ?, ?)";
		try {
			// abrir a conexão com o banco.
			Connection con = conectar();
			// Preparar a query para execução no banco de dados.
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parâmetros (?) pelo conteúdo das variáveis JavaBeans
			pst.setString(1, usuario.getNome_usuario());
			pst.setString(2, usuario.getEmail_usuario());
			pst.setString(3, usuario.getSenha_usuario());
			pst.setString(4, usuario.getCpf_usuario());
			// Executar a query
			pst.executeUpdate();
			// Encerrar a conexão com o banco.
			con.close();

		} catch (Exception e) {
			System.out.println(e);

		}
	}
	
	/** CRUD READ **/

	public ArrayList<JavaBeans> validacaoLogin() {
		// Criando objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> dados_usuario = new ArrayList<>();
		String read = "select * from cadastro_usuario order by nome_usuario";
		try {
			// abrir a conexão com o banco.
			Connection con = conectar();
			// Preparar a query para execução no banco de dados.
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// o laço abaixo será executado enquando houve contatos
			while (rs.next()) {
				// variaveis de aopio que recebem os dados do banco
				String id_usuario = rs.getString(1);
				String nome_usuario = rs.getString(2);
				String email_usuario = rs.getString(3);
				String senha_usuario = rs.getString(4);
				String cpf_usuario = rs.getString(5);
				String cpf_compra = rs.getString(5);
				// populando o ArrayList
				dados_usuario.add(new JavaBeans(id_usuario, nome_usuario, email_usuario, senha_usuario,cpf_usuario,cpf_compra));
				// Encerrar a conexão com o banco.
				
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return dados_usuario;
	}
	
}