package br.com.adebayo.teste;

import java.sql.Connection;
import java.sql.SQLException;
import br.com.adebayo.connection.ConnectionFactory;

public class Teste {
	public static void main(String[] args) throws SQLException {
		
		for(int i = 0; i < 50; i++) {
			Connection conexao = ConnectionFactory.conectar();
			System.out.println("Conexão: " + i);
		}
	}
}
