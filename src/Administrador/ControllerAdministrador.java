package Administrador;

import Validador.ValidadorEntradas;

public class ControllerAdministrador {

    private ValidadorEntradas validadorEntradas;

    private ServiceAdministrador serviceAdministrador;

    public ControllerAdministrador(ServiceAdministrador serviceAdministrador) {
    	this.serviceAdministrador = serviceAdministrador;
    }

    public String listarDeposito() {
    	if (this.serviceAdministrador.tamanhoDeposito() == 0) {
    		throw new RuntimeException("Erro, depósito está vazio.\n");
    	}
    	return this.serviceAdministrador.listarDeposito();
    }

    public String listaProduto(String ID) {
    	this.validadorEntradas.valida(ID);
    	if (this.serviceAdministrador.tamanhoDeposito() == 0) {
    		throw new RuntimeException("Erro, depósito está vazio.\n");
    	}
    	return this.serviceAdministrador.listaProduto(ID);
    	
    }

    public String listarHistorico() {
    	if (this.serviceAdministrador.tamanhoHistorico() == 0) {
    		throw new RuntimeException("Erro, depósito está vazio.\n");
    	}
    	return this.serviceAdministrador.listarDeposito();
    }

    public String listarHistorico(String data) {
    	this.validadorEntradas.valida(data);
    	if (this.serviceAdministrador.tamanhoHistorico() == 0) {
    		throw new RuntimeException("Erro, depósito está vazio.\n");
    	}
    	return this.serviceAdministrador.listarHistorico(data);
    }

    public void alteraNomeProduto(String ID, String nome) {
    	this.validadorEntradas.valida(new String[] {ID, nome});
    	if (this.serviceAdministrador.tamanhoDeposito() == 0) {
    		throw new RuntimeException("Erro, depósito está vazio.\n");
    	}
    	this.serviceAdministrador.alteraNomeProduto(ID, nome);
    }

    public void alteraPrecoProduto(String ID, double preco) {
    	this.validadorEntradas.validaNome(ID);
    	this.validadorEntradas.validaPositivo(preco);
    	this.serviceAdministrador.alteraPrecoProduto(ID, preco);
    }

    public String adicionaProduto(String nome, double preco) {
    	this.validadorEntradas.validaNome(nome);
    	this.validadorEntradas.validaPositivo(preco);
    	return this.serviceAdministrador.adicionaProduto(nome, preco);
    }

    public void removeProduto(String ID) {
    	this.validadorEntradas.valida(ID);
    	if (this.serviceAdministrador.tamanhoDeposito() == 0) {
    		throw new RuntimeException("Erro, depósito está vazio.\n");
    	}
    	this.serviceAdministrador.removeProduto(ID);
    }

    public void limparDeposito() {
    	if (this.serviceAdministrador.tamanhoDeposito() == 0) {
    		throw new RuntimeException("Erro, depósito está vazio.\n");
    	}
    	this.serviceAdministrador.limparDeposito();
    }

}