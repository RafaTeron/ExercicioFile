package entities;

public class Produto {
	
	private String produto;
	private double preco;
	private int unidade;
	
	public Produto() {
		
	}
	
	public Produto(String produto, double preco, int unidade) {
		this.produto = produto;
		this.preco = preco;
		this.unidade = unidade;
	}


	public String getProduto() {
		return produto;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public int getUnidade() {
		return unidade;
	}


	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}
	
	public double total() {
		return preco * unidade;
	}


	@Override
	public String toString() {
		return "Produto: " + produto + "| Total: " + String.format("%.2f", total());
	}
	
	

}
