package Vendas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import Produtos.ProdutoDTO;

public class Venda {

    private HashSet<ProdutoDTO> listaDeProdutos;

    private String dataDeVenda;
    private String idDaVenda;
    private boolean concluida;

    public Venda() {
    	Date data = new Date();
    	SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:ss");
    	dataDeVenda = dataFormatada.format(data);
    	this.listaDeProdutos = new HashSet<>();
    	this.concluida = false;
    }

    public void adicionaProduto(ProdutoDTO produto2) {
    	for (ProdutoDTO produto : this.listaDeProdutos) {
    		if (produto.equals(produto2)) {
    			produto.adicionaMaisUm();
    			return;
    		}
    	}
    	this.listaDeProdutos.add(produto2);
    }

    public String getIdDaVenda() {
    	return this.idDaVenda;
    }
    
    public void setID(String ID) {
    	this.idDaVenda = ID;
    }

    public String getDataDeVenda() {
    	return this.dataDeVenda;
    }

    @Override
    public String toString() {
    	String retorno;
    	retorno = this.idDaVenda + " - ID da venda" + " | " + this.dataDeVenda + " - Data da venda" + " | " + this.statusCompra() + '\n';
    	for (ProdutoDTO produto : listaDeProdutos) {
    		retorno += produto.toString() + '\n';
    	}
    	return retorno;
    }
    
    public String toStringApenasVendas() {
    	String retorno;
    	retorno = this.idDaVenda + " - ID da venda" + " | " + this.dataDeVenda + " - Data da venda" + " | " + this.statusCompra();
    	return retorno;
    }
    
    private String statusCompra() {
    	return this.concluida ? "Concluida" : "Em andamento";
    }
    
    public boolean isConcluida() {
    	return this.concluida;
    }
    
    public void alteraStatus() {
    	this.concluida = !this.concluida;
    }
    
    public void removeProduto(ProdutoDTO produto) {
    	this.listaDeProdutos.remove(produto);
    }
}