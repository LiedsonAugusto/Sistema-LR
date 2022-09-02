package Produtos;

public class Produto {

    private String ID;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String ID, String nome, double preco) {
    	this.ID = ID;
    	this.nome = nome;
    	this.preco = preco;
    	this.quantidade = 1;
    }

    public String getNome() {
    	return this.nome;
    }

    public double getpreco() {
    	return this.preco;
    }

    public String getID() {
    	return this.ID;
    }
    
    public String toString() {
    	return this.ID + " | " + this.nome + " | " + this.quantidade + " Itens em estoque | " + this.preco + " R$";
    }

}