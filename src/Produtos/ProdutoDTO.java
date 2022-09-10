package Produtos;

import java.util.Objects;

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
    
    public int getQuantidade() {
    	return this.quantidade;
    }
    
    public void adicionaQuantidade(int quantidade) {
    	this.quantidade += quantidade;
    }
    
    public void removeQuantidade(int quantidade) {
    	this.quantidade -= quantidade;
    	if (this.quantidade < 0) {
    		this.quantidade = 0;
    	}
    }
    
    @Override
    public String toString() {
    	return this.ID + " | " + this.nome + " | " + String.format("%.2f", this.preco) + " R$ | " + this.quantidade + "x | " + String.format("%.2f", this.preco * this.quantidade) + " R$";
    }
    
    @Override
	public int hashCode() {
		return Objects.hash(ID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoDTO other = (ProdutoDTO) obj;
		return Objects.equals(ID, other.ID);
	}

}