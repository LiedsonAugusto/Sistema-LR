package Vendas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import Produtos.ProdutoDTO;

public class Venda {

    private HashSet<ProdutoDTO> listaDeProdutos;

    private String dataDeVenda;

    private String idDaVenda;

    public Venda() {
    	Date data = new Date();
    	SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:ss");
    	dataDeVenda = dataFormatada.format(data);
    	this.listaDeProdutos = new HashSet<>();
    }

    public void adicionaProduto(ProdutoDTO produto) {
    	this.listaDeProdutos.add(produto);
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
    	retorno = this.idDaVenda + " - ID da venda" + " | " + this.dataDeVenda + " - Data da venda" + '\n' + '\n';
    	for (ProdutoDTO produto : listaDeProdutos) {
    		retorno += produto.toString();
    	}
    	return retorno;
    }
}