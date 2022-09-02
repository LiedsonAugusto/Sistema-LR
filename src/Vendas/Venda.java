package Vendas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import Produtos.ProdutoDTO;

public class Venda {

    private HashSet<ProdutoDTO> listaDeProdutos;

    private String dataDeVenda;

    private String idDaVenda;

    public Venda(String idDaVenda) {
    	this.idDaVenda = idDaVenda;
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

    public String getDataDeVenda() {
    	return this.dataDeVenda;
    }

}