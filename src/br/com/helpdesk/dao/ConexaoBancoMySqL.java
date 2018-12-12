package br.com.helpdesk.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBancoMySqL {

	private static final String USUARIO = "root";
	private static final String SENHA = "lunona";
	private static final String URL = "jdbc:mysql://localhost/helpdeskdb";
	private static final String DRIVER = "com.mysql.jdbc.Driver";

	// Conectar ao banco
	public static Connection abrir() throws Exception {
		// Registrar o driver
		Class.forName(DRIVER);
		// Capturar a conexão
		Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
		// Retorna a conexao aberta
		return conn;

	}

}
