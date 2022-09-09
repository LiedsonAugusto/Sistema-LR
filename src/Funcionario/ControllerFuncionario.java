package Funcionario;

import Validador.ValidadorEntradas;

public class ControllerFuncionario {

    private ValidadorEntradas validadorEntradas;
    private ServiceFuncionario serviceFuncionario;

    public ControllerFuncionario(ServiceFuncionario serviceFuncionario) {
    	this.serviceFuncionario = serviceFuncionario;
    	this.validadorEntradas = new ValidadorEntradas();
    }
    
    public String iniviaVenda() {
    	return this.serviceFuncionario.iniciaVenda();
    }

    public void concluirVenda(String idVenda) {
    	this.validadorEntradas.valida(idVenda);
    	this.serviceFuncionario.concluirVenda(idVenda);
    }

    public void adicionarProduto(String idProduto, String idVenda, int quantidade) {
    	this.validadorEntradas.valida(new String[] {idProduto, idVenda});
    	this.validadorEntradas.validaPositivo(quantidade);
    	this.serviceFuncionario.adicionarProduto(idProduto, idVenda, quantidade);
    }

    public void removerProduto(String idVenda, String idProduto) {
    	this.validadorEntradas.valida(new String[] {idProduto, idVenda});
    	this.serviceFuncionario.removerProduto(idVenda, idProduto);
    }

    public void removerVenda(String idVenda) {
    	this.validadorEntradas.valida(idVenda);
    	this.serviceFuncionario.removerVenda(idVenda);
    }

    public String visualizarProduto(String idProduto) {
    	this.validadorEntradas.valida(idProduto);
    	this.validadorEntradas.validarIDInexistente(this.serviceFuncionario.getIDs(), idProduto);
    	return this.serviceFuncionario.visualizarProduto(idProduto);
    }

    public String visualizarEstoque() {
    	return this.serviceFuncionario.visualizarEstoque();
    }

    public String visualizarVenda(String idVenda) {
    	this.validadorEntradas.valida(idVenda);
    	return this.serviceFuncionario.visualizarVenda(idVenda);
    }

    public void visualizarHistoricoDeVendas() {

    }
    
    public String getDataVenda(String ID) {
    	return this.serviceFuncionario.getDataVenda(ID);
    }

}