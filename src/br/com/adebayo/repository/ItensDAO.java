package br.com.adebayo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.adebayo.connection.ConnectionFactory;
import br.com.adebayo.model.Itens;

public class ItensDAO {
	
private Connection conexao;
	
	public ItensDAO() throws SQLException {
		this.conexao = ConnectionFactory.conectar();
	}
	
	//inserir um usuario
	public void insert(Itens estoque) throws SQLException {
								//nome da tabela
		String sql = "insert into ITENS (nome, quantidade, preco)values(?,?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setString(1, estoque.getNome());
		stmt.setDouble(2, estoque.getQuantidade());
		stmt.setDouble(3, estoque.getPreco());
		
		stmt.execute();		
		stmt.close();
	}
	
	public void update(Itens estoque) throws SQLException {
		//nome da tabela
		String sql = "update ITENS set nome=?, quantidade=?, preco=?  where id=?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setString(1, estoque.getNome());
		stmt.setDouble(2, estoque.getQuantidade());
		stmt.setDouble(3, estoque.getPreco());
		stmt.setInt(4, estoque.getId());
		
		stmt.execute();		
		stmt.close();
	}
	
	public void delete(int id) throws SQLException {
		//nome da tabela
		String sql = "delete from ITENS where id=?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setInt(1, id);
		
		stmt.execute();		
		stmt.close();
	}
	
	public List<Itens> selectAll() throws SQLException {
			
		List<Itens> itensList = new ArrayList<Itens>();
		String sql = "select * from itens";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Itens itens = new Itens();
			itens.setId(rs.getInt("id"));
			itens.setNome(rs.getString("nome"));
			itens.setQuantidade(rs.getDouble("quantidade"));
			itens.setPreco(rs.getDouble("preco"));
			
			itensList.add(itens);
		}
				
		stmt.close();
		rs.close();
		return itensList;
	}
	
}
