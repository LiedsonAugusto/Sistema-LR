package Produtos;

import java.util.HashMap;

public class DepositoDeProdutos {

    private HashMap<String, Produto> produtos;

    public Produto get(String ID) {
    	return this.produtos.get(ID);
    }

    public void put(Produto produto) {
    	this.produtos.put(produto.getID(), produto);
    }

    public void remove(String ID) {
    	this.produtos.remove(ID);
    }

}
