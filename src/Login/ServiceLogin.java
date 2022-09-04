package Login;

import Validador.ValidadorEntradas;

public class ServiceLogin {

    private RepositoryContas repositoryContas;
    private ValidadorEntradas validador;
    
    public ServiceLogin(RepositoryContas repositoryContas) {
    	this.repositoryContas = repositoryContas;
    }

    public boolean validaLoginFuncionario(String ID, String senha) {
    	Funcionario funcionario = this.repositoryContas.getFuncionario(ID);
    	if (funcionario != null && funcionario.getSenha().equals(senha)) {
    		return true;
    	}
    	return false;
    }

    public boolean validaLoginAdm(String ID, String senha) {
    	Administrador administrador = this.repositoryContas.getAdministrador(ID);
    	if (senha.equals(administrador.getSenha())) {
    		return true;
    	}
    	return false;
    }

    public void adicionaFuncionario(String idFuncionario, Funcionario funcionario) {
    	this.repositoryContas.putFuncionario(idFuncionario, funcionario);
    }

    public void removeFuncionario(String idFuncionario) {
    	this.repositoryContas.removeFuncionario(idFuncionario);
    }

    public void adicionaADM(String ID, Administrador ADM) {
    	this.adicionaADM(ID, ADM);
    }

    public void removeADM(String ID) {
    	this.removeADM(ID);

    }

}