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
    		retorno = this.depositoDeProdutos.get(chave).toString() + '\n';
    	}
    	return retorno;
    }

    public String listaProduto(String ID) {

    }

    public String listarHistorico() {

    }

    public String listarHistorico(String data) {

    }

    public void alteraNomeProduto(String ID, String nome) {

    }

    public void alteraPrecoProduto(String ID, double preco) {

    }

    public String adicionaProduto(String nome, double preco) {

    }

    public void removeProduto(String ID) {

    }

    public void limparDeposito() {

    }

}