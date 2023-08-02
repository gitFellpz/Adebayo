package br.com.adebayo.model;

//JavaBeans
public class Itens {
	
	private int id;
	private String nome;
	private double quantidade;
	private double preco;
	
	public Itens() {
		
	}

	public Itens(String nome, double quantidade, double preco) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Estoque [id=" + id + ", nome=" + nome + ", quantidade=" + quantidade + ", preco=" + preco + "]";
	}
	
	
}
