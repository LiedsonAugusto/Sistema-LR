package Produtos;

public class ProdutoDTO {

    private String ID;
    private String nome;
    private double preco;
    private int quantidade;

    public ProdutoDTO(String ID, String nome, double preco, int quantidade) {
    	this.ID = ID;
    	this.nome = nome;
    	this.preco = preco;
    	this.quantidade = quantidade;
    }
    
    public String getNome() {
    	return this.nome;
    }

    public double getPreco() {
    	return this.preco * this.quantidade;
    }

    public String getID() {
    	return this.ID;
    }

}