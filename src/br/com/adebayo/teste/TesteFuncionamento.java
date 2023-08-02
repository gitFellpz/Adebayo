package br.com.adebayo.teste;

import java.sql.SQLException;
import java.util.Scanner;
import br.com.adebayo.repository.ItensDAO;
import br.com.adebayo.model.Itens;

public class TesteFuncionamento {
	
	public static void main(String[] args) throws SQLException {
		
		ItensDAO dao = new ItensDAO();
		Scanner input = new Scanner(System.in);
		
		String nome;
		Double quantidade, preco;
		
		System.out.print("Insira o nome do Item: ");
		nome = input.nextLine();
		
		System.out.print("Insira a quantidade do Item: ");
		quantidade = input.nextDouble();
		
		System.out.print("Insira o preço unitário do Item: ");
		preco = input.nextDouble();
		
		try {
			Itens padrao = new Itens(nome, quantidade, preco);
			dao.insert(padrao);
			System.out.println("\nItem " + nome + " criado!");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		input.next();
	}

}
