package Funcionario;

import java.util.HashMap;
import java.util.Set;

import Produtos.DepositoDeProdutos;
import Produtos.Produto;
import Produtos.ProdutoDTO;
import Vendas.HistoricoDeVendas;
import Vendas.Venda;

public class ServiceFuncionario {

    private HistoricoDeVendas historicoDeVendas;
    private DepositoDeProdutos depositoDeProdutos;

    public ServiceFuncionario(HistoricoDeVendas historicoDeVendas, DepositoDeProdutos depositoDeProdutos) {
    	this.historicoDeVendas = historicoDeVendas;
    	this.depositoDeProdutos = depositoDeProdutos;
    }

    public void concluirVenda(String idVenda) {
    	this.historicoDeVendas.get(idVenda).alteraStatus();
    }
    
    public void adicionarProduto(String idProduto, String idVenda, int quantidade) {
    	Produto produto = this.depositoDeProdutos.get(idProduto);
    	ProdutoDTO produtoDTO = new ProdutoDTO(produto.getID(), produto.getNome(), produto.getPreco(), quantidade);
    	this.historicoDeVendas.get(idVenda).adicionaProduto(produtoDTO);
    }

    public void removerProduto(String idVenda, String idProduto) {
    	Produto produto = this.depositoDeProdutos.get(idProduto);
    	ProdutoDTO produtoDTO = new ProdutoDTO(produto.getID(), produto.getNome(), produto.getPreco(), 0);
    	this.historicoDeVendas.get(idVenda).removeProduto(produtoDTO);
    }

    public void removerVenda(String idVenda) {
    	this.historicoDeVendas.remove(idVenda);
    }

    public String visualizarProduto(String idProduto) {
    	return this.depositoDeProdutos.get(idProduto).toStringF();
    }

    public String visualizarEstoque() {
    	String produtosToString = "";
    	HashMap<String, Produto> produtos = this.depositoDeProdutos.getProdutos();
    	if (produtos.size() == 0) {
    		return "~~Estoque~~\n\nVazio --\n\n";
    	}
    	
    	for (String chave : produtos.keySet()) {
    		produtosToString += produtos.get(chave).toStringF();
    	}
    	return "~~Estoque~~\n\n" + produtosToString + "\n\n";
    }

    public String visualizarVenda(String idVenda) {
    	return this.historicoDeVendas.get(idVenda).toString();
    }

    public void visualizarHistoricoDeVendas() {

    }

	public String iniciaVenda() {
		Venda venda = new Venda();
		this.historicoDeVendas.put(venda);
		return venda.getIdDaVenda();
	}
	
	public Set<String> getIDs(){
		return this.depositoDeProdutos.getIDs();
	}
	
	public String getDataVenda(String ID) {
		return this.historicoDeVendas.get(ID).getDataDeVenda();
	}

}