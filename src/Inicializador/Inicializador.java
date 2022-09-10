package Inicializador;

import Administrador.ControllerAdministrador;
import Administrador.ServiceAdministrador;
import Funcionario.ControllerFuncionario;
import Funcionario.ServiceFuncionario;
import Login.ControllerLoginAdministrador;
import Login.ControllerLoginFuncionario;
import Login.RepositoryContas;
import Login.ServiceLogin;
import Produtos.DepositoDeProdutos;
import Vendas.HistoricoDeVendas;

public class Inicializador {

	// Administrador
	ControllerAdministrador controllerAdministrador;
	ServiceAdministrador serviceAdministrador;
	
	// Funcionario
	ControllerFuncionario controllerFuncionario;
	ServiceFuncionario serviceFuncionario;

	// Login
	ControllerLoginAdministrador controllerLoginAdministrador;
	ControllerLoginFuncionario controllerLoginFuncionario;
	ServiceLogin serviceLogin;
	
	// Repositorys
	RepositoryContas repositoryContas;
	DepositoDeProdutos depositoDeProdutos;
	HistoricoDeVendas historicoDeVendas;
	
	public Inicializador() {
		this.repositoryContas = new RepositoryContas();
		this.depositoDeProdutos = new DepositoDeProdutos();
		this.historicoDeVendas = new HistoricoDeVendas();
	}
	
	public ControllerLoginAdministrador inicializaAdministradorLogin() {
		this.serviceLogin = new ServiceLogin(this.repositoryContas);
		this.controllerLoginAdministrador = new ControllerLoginAdministrador(this.serviceLogin);
		return this.controllerLoginAdministrador;
	}
	
	public ControllerLoginFuncionario inicializaFuncionarioLogin() {
		this.serviceLogin = new ServiceLogin(this.repositoryContas);
		this.controllerLoginFuncionario = new ControllerLoginFuncionario(this.serviceLogin);
		return this.controllerLoginFuncionario;
	}
	
	public ControllerFuncionario inicializaFuncionario() {
		this.serviceFuncionario = new ServiceFuncionario(this.historicoDeVendas, this.depositoDeProdutos);
		this.controllerFuncionario = new ControllerFuncionario(this.serviceFuncionario);
		return this.controllerFuncionario;
	}
	
	public ControllerAdministrador inicializaAdministrador() {
		this.serviceAdministrador = new ServiceAdministrador(historicoDeVendas, depositoDeProdutos);
		this.controllerAdministrador = new ControllerAdministrador(this.serviceAdministrador);
		return this.controllerAdministrador;
	}
	
}
