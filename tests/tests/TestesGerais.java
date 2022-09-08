package tests;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Administrador.ControllerAdministrador;
import Administrador.ServiceAdministrador;
import Funcionario.ControllerFuncionario;
import Funcionario.ServiceFuncionario;
import Login.ControllerLogin;
import Login.RepositoryContas;
import Login.ServiceLogin;
import Produtos.DepositoDeProdutos;
import Vendas.HistoricoDeVendas;

class TestesGerais {
	
	ControllerLogin controllerLogin;
	ControllerAdministrador controllerAdministrador;
	ControllerFuncionario controllerFuncionario;
	DepositoDeProdutos depositoDeProdutos;
	HistoricoDeVendas historicoDeVendas;

	@BeforeEach
	void setUp(){
		historicoDeVendas = new HistoricoDeVendas();
		depositoDeProdutos = new DepositoDeProdutos();
		controllerFuncionario = new ControllerFuncionario(new ServiceFuncionario(historicoDeVendas, depositoDeProdutos));
		controllerAdministrador = new ControllerAdministrador(new ServiceAdministrador(historicoDeVendas, depositoDeProdutos));
		controllerLogin = new ControllerLogin(new ServiceLogin(new RepositoryContas()));
		
		controllerLogin.adicionaADM("IDADM", "SENHAADM", "ADM");
		controllerLogin.adicionaFuncionario("IDFUNCIONARIO", "SENHAFUNCIONARIO", "FUNCIONARIO");
	}
}
