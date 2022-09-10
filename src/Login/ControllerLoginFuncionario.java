package Login;

import Validador.ValidadorEntradas;

public class ControllerLoginFuncionario {

	private ServiceLogin serviceLogin;
	private ValidadorEntradas validador;
	
	public ControllerLoginFuncionario(ServiceLogin servicelogin) {
		this.serviceLogin = servicelogin;
    	this.validador = new ValidadorEntradas();
	}
	
	public boolean validaLoginFuncionario(String ID, String senha) {
    	this.validador.valida(new String[] {ID, senha});
    	return this.serviceLogin.validaLoginFuncionario(ID, senha);
    }
	
	public void alterarSenha(String ID, String novaSenha) {
		this.validador.valida(novaSenha);
		this.serviceLogin.alteraSenha(ID, novaSenha);
	}
	
}
