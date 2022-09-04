package Vendas;

import java.util.HashMap;

public class HistoricoDeVendas {

    private HashMap<String, Venda> vendas;
    
    public Venda get(String ID) {
    	return this.vendas.get(ID);
    }

    public Venda getVendas(String idVenda) {
    	return this.vendas.get(idVenda);
    }

    public void putVendas(Venda venda) {
    	this.vendas.put(Integer.toString(this.vendas.size()+1), venda);
    }

    public void removeVendas(String idVenda) {
    	this.vendas.remove(idVenda);
    }
    
    public HashMap<String, Venda> getVendas(){
    	return this.vendas;
    }

}