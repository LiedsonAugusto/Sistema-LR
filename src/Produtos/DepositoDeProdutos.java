package Produtos;

import java.util.HashMap;

public class DepositoDeProdutos {

    private HashMap<String, Produto> produtos;
    int ID = 0;

    public Produto get(String ID) {
    	return this.produtos.get(ID);
    }

    public void put(Produto produto) {
    	produto.setID(Integer.toString(ID + 1));
    	this.produtos.put(Integer.toString(ID + 1), produto);
    	this.ID ++;
    }

    public void remove(String ID) {
    	this.produtos.remove(ID);
    }
    
    public HashMap<String, Produto> getProdutos() {
    	return this.produtos;
    }

}
