package Produtos;

public class Produto {

    private String ID;

    private String nome;

    private double preco;

    public Produto(String ID, String nome, double preco) {
    	this.ID = ID;
    	this.nome = nome;
    	this.preco = preco;
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

}