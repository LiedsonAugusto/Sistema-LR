package Produtos;

public class Produto {

    private String ID;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco) {
    	this.nome = nome;
    	this.preco = preco;
    	this.quantidade = 1;
    }

    public String getNome() {
    	return this.nome;
    }
    
    public void setNome(String novoNome) {
    	this.nome = novoNome;
    }

    public double getPreco() {
    	return this.preco;
    }
    
    public void setPreco(double novoPreco) {
    	this.preco = novoPreco;
    }

    public String getID() {
    	return this.ID;
    }
    
    public void setID(String ID) {
    	this.ID = ID;
    }
    
    @Override
    public String toString() {
    	return this.ID + " | " + this.nome + " | " + this.quantidade + " Itens em estoque | " + String.format("%.2f", this.preco) + " R$";
    }
    
    public String toStringF() {
    	return this.ID + " | " + this.nome + " | " + this.preco + " R$";
    }

}