package Administrador;

import java.util.Set;

import Validador.ValidadorEntradas;

public class ControllerAdministrador {

    private ValidadorEntradas validadorEntradas;

    private ServiceAdministrador serviceAdministrador;

    public ControllerAdministrador(ServiceAdministrador serviceAdministrador) {
    	this.serviceAdministrador = serviceAdministrador;
    	this.validadorEntradas = new ValidadorEntradas();
    }

    public String listarDeposito() {
    	if (this.serviceAdministrador.tamanhoDeposito() == 0) {
    		throw new RuntimeException("Erro, depósito está vazio.\n");
    	}
    	return this.serviceAdministrador.listarDeposito();
    }

    public String listaProduto(String ID) {
    	this.validadorEntradas.valida(ID);
    	this.validadorEntradas.validarIDInexistente(this.serviceAdministrador.getDepositoDeProdutos(), ID);
    	return this.serviceAdministrador.listaProduto(ID);
    	
    }

    public String listarHistorico() {
    	if (this.serviceAdministrador.tamanhoHistorico() == 0) {
    		throw new RuntimeException("Erro, depósito está vazio.\n");
    	}
    	return this.serviceAdministrador.listarHistorico();
    }

    public String listarHistorico(String data) {
    	this.validadorEntradas.valida(data);
    	this.validadorEntradas.validarData(this.serviceAdministrador.getHistoricoDeVendas(), data);
    	return this.serviceAdministrador.listarHistorico(data);
    }

    public void alteraNomeProduto(String ID, String nome) {
    	this.validadorEntradas.valida(new String[] {ID, nome});
    	this.validadorEntradas.validarIDInexistente(this.serviceAdministrador.getDepositoDeProdutos(), ID);
    	this.serviceAdministrador.alteraNomeProduto(ID, nome);
    }

    public void alteraPrecoProduto(String ID, double preco) {
    	this.validadorEntradas.valida(ID);
    	this.validadorEntradas.validaPositivo(preco);
    	this.validadorEntradas.validarIDInexistente(this.serviceAdministrador.getDepositoDeProdutos(), ID);
    	this.serviceAdministrador.alteraPrecoProduto(ID, preco);
    }

    public String adicionaProduto(String nome, double preco) {
    	this.validadorEntradas.validaNome(nome);
    	this.validadorEntradas.valida(nome);
    	this.validadorEntradas.validaPositivo(preco);
    	return this.serviceAdministrador.adicionaProduto(nome, preco);
    }

    public void removeProduto(String ID) {
    	this.validadorEntradas.valida(ID);
    	this.validadorEntradas.validarIDInexistente(this.serviceAdministrador.getDepositoDeProdutos(), ID);
    	this.serviceAdministrador.removeProduto(ID);
    }

    public void limparDeposito() {
    	if (this.serviceAdministrador.tamanhoDeposito() == 0) {
    		throw new RuntimeException("Erro, depósito está vazio.\n");
    	}
    	this.serviceAdministrador.limparDeposito();
    }
    
    public int tamanhoDeposito() {
    	return this.serviceAdministrador.tamanhoDeposito();
    }
    
    public int tamanhoHistorico() {
    	return this.serviceAdministrador.tamanhoHistorico();
    }
    
    public Set<String> getDepositoDeProdutos(){
    	return this.serviceAdministrador.getDepositoDeProdutos();
    }

    
    public Set<String> getHistoricoDeVendas(){
    	return this.serviceAdministrador.getHistoricoDeVendas();
    }

}