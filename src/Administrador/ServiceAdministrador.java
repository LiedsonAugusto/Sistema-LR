package Administrador;

import java.util.HashSet;
import java.util.Set;

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
    		if (this.depositoDeProdutos.get(chave).getID().equals(ID)) {
    			retorno = this.depositoDeProdutos.get(chave).toString() + '\n';
    		}
    	}
    	return retorno;
    }

    public String listarHistorico() {
    	String retorno = "";
    	for(String chave : this.historicoDeVendas.getVendas().keySet()) {
    		retorno += this.historicoDeVendas.get(chave).toStringApenasVendas() + '\n';
    	}
    	return retorno;
    }

    public String listarHistorico(String data) {
    	String retorno = "";
    	for(String chave : this.historicoDeVendas.getVendas().keySet()) {
    		if (this.historicoDeVendas.get(chave).getDataDeVenda().equals(data)) {
    			retorno = this.historicoDeVendas.get(chave).toString() + '\n';
    		}
    	}
    	return retorno;

    }

    public void alteraNomeProduto(String ID, String nome) {
    	for (String chave : this.depositoDeProdutos.getProdutos().keySet()) {
    		if (this.depositoDeProdutos.get(chave).getID().equals(ID)) {
    			this.depositoDeProdutos.get(chave).setNome(nome);
    		}
    	}
    }

    public void alteraPrecoProduto(String ID, double preco) {
    	for (String chave : this.depositoDeProdutos.getProdutos().keySet()) {
    		if (this.depositoDeProdutos.get(chave).getID().equals(ID)) {
    			this.depositoDeProdutos.get(chave).setPreco(preco);
    		}
    	}
    }

    public String adicionaProduto(String nome, double preco) {
    	for (String chave : this.depositoDeProdutos.getProdutos().keySet()) {
    		if (this.depositoDeProdutos.get(chave).getNome().equals(nome)) {
    			this.depositoDeProdutos.get(chave).adicionaQuantidade(1);
    			return this.depositoDeProdutos.get(chave).getID();
    		}
    	}
    	Produto novoProduto = new Produto(nome, preco);
    	this.depositoDeProdutos.put(novoProduto);
    	return novoProduto.getID();
    }
    
    public String adicionaProduto(String nome, double preco, int quantidade) {
    	for (String chave : this.depositoDeProdutos.getProdutos().keySet()) {
    		if (this.depositoDeProdutos.get(chave).getNome().equals(nome)) {
    			this.depositoDeProdutos.get(chave).adicionaQuantidade(quantidade);
    			return this.depositoDeProdutos.get(chave).getID();
    		}
    	}
    	Produto novoProduto = new Produto(nome, preco, quantidade);
    	this.depositoDeProdutos.put(novoProduto);
    	return novoProduto.getID();
    }

    public void removeProduto(String ID) {
    	this.depositoDeProdutos.remove(ID);
    }

    public void limparDeposito() {
    	this.depositoDeProdutos.limpar();
    }
    
    public int tamanhoDeposito(){
    	return this.depositoDeProdutos.getProdutos().size();
    }
    
    public int tamanhoHistorico() {
    	return this.historicoDeVendas.getVendas().size();
    }
    
    public Set<String> getDepositoDeProdutos() {
    	return this.depositoDeProdutos.getProdutos().keySet();
    }
    
    public Set<String> getHistoricoDeVendas() {
    	return this.historicoDeVendas.getVendas().keySet();
    }

    public Set<String> getDatasDeHistorico(){
    	Set<String> datas = new HashSet<>();
    	for(String chave : this.historicoDeVendas.getVendas().keySet()) {
    		datas.add(this.historicoDeVendas.get(chave).getDataDeVenda());
    	}
    	return datas;
    }
    
}