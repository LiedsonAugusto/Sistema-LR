package Vendas;

import java.util.HashMap;
import java.util.Set;

public class HistoricoDeVendas {

    private HashMap<String, Venda> vendas;
    int ID;
    
    public HistoricoDeVendas() {
    	this.vendas = new HashMap<>();
    	this.ID = 0;
    }
    
    public Venda get(String idVenda) {
    	return this.vendas.get(idVenda);
    }
    
    public void put(Venda venda) {
    	venda.setID(Integer.toString(ID + 1));
    	this.vendas.put(Integer.toString(ID + 1), venda);
    	this.ID++;
    }

    public void remove(String idVenda) {
    	this.vendas.remove(idVenda);
    }
    
    public HashMap<String, Venda> getVendas(){
    	return this.vendas;
    }
    
    public Set<String> getIDs(){
    	return this.vendas.keySet();
    }

}