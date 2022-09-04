package Administrador;

import Produtos.DepositoDeProdutos;
import Produtos.Produto;
import Vendas.HistoricoDeVendas;

public class ServiceAdministrador {

    private HistoricoDeVendas historicoDeVendas;
    private DepositoDeProdutos depositoDeProdutos;
    
    public ServiceAdministrador(HistoricoDeVendas historicoDeVendas, DepositoDeProdutos depositoDeItens) {
    	this.historicoDeVendas = historicoDeVendas;
    	this.depositoDeProdutos = depositoDeItens;
    }

    public String listarDeposito() {
    	String retorno = "";
    	for (String chave : this.depositoDeProdutos.getProdutos().keySet()) {
    		retorno += this.depositoDeProdutos.get(chave).toString() + '\n';
    	}
    	return retorno;
    }

    public String listaProduto(String ID) {
    	String retorno = "";
    	for(String chave : this.depositoDeProdutos.getProdutos().keySet()) {
    		if (this.depositoDeProdutos.get(chave).getID() == ID) {
    			retorno = this.depositoDeProdutos.get(chave).toString() + '\n';
    		}
    	}
    	return retorno;
    }

    public String listarHistorico() {
    	String retorno = "";
    	for(String chave : this.historicoDeVendas.getVendas().keySet()) {
    		retorno += this.historicoDeVendas.get(chave).toString() + '\n';
    	}
    	return retorno;
    }

    public String listarHistorico(String data) {
    	String retorno = "";
    	for(String chave : this.historicoDeVendas.getVendas().keySet()) {
    		if (this.historicoDeVendas.get(chave).getDataDeVenda() == data) {
    			retorno = this.historicoDeVendas.get(chave).toString() + '\n';
    		}
    	}
    	return retorno;

    }

    public void alteraNomeProduto(String ID, String nome) {
    	for (String chave : this.depositoDeProdutos.getProdutos().keySet()) {
    		if (this.depositoDeProdutos.get(chave).getID() == ID) {
    			this.depositoDeProdutos.get(chave).setNome(nome);
    		}
    	}
    }

    public void alteraPrecoProduto(String ID, double preco) {
    	for (String chave : this.depositoDeProdutos.getProdutos().keySet()) {
    		if (this.depositoDeProdutos.get(chave).getID() == ID) {
    			this.depositoDeProdutos.get(chave).setPreco(preco);
    		}
    	}
    }

    public String adicionaProduto(String nome, double preco) {
    	Produto novoProduto = new Produto(nome, preco);
    	this.depositoDeProdutos.put(novoProduto);
    	return novoProduto.getID();
    }

    public void removeProduto(String ID) {
    	this.depositoDeProdutos.remove(ID);
    }

    public void limparDeposito() {
    	for (String chave : this.depositoDeProdutos.getProdutos().keySet()) {
    		this.depositoDeProdutos.remove(chave);
    	}
    }

}