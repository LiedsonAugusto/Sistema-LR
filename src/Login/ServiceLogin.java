package Login;

import java.util.Set;
import Login.Cripto;

public class ServiceLogin {

    private RepositoryContas repositoryContas;
    private Cripto cripto;
    
    public ServiceLogin(RepositoryContas repositoryContas) {
    	this.repositoryContas = repositoryContas;
    	this.cripto = new Cripto();
    }

    public boolean validaLoginFuncionario(String ID, String senha) {
    	Funcionario funcionario = this.repositoryContas.getFuncionario(ID);
    	if (funcionario == null) {
    		return false;
    	}
    	String descriptSenha = cripto.Descriptografar(funcionario.getSenha());
    	if (descriptSenha.equals(senha)) {
    		return true;
    	}
    	return false;
    }

    public boolean validaLoginAdm(String ID, String senha) {
    	Administrador administrador = this.repositoryContas.getAdministrador(ID);
    	if (administrador == null) {
    		return false;
    	}
    	String descriptSenha = cripto.Descriptografar(administrador.getSenha());
    	if (administrador != null && descriptSenha.equals(senha)) {
    		return true;
    	}
    	return false;
    }

    public void adicionaFuncionario(String idFuncionario, String senha, String nome){
    	this.repositoryContas.putFuncionario(idFuncionario, new Funcionario(idFuncionario, cripto.Criptografar(senha), nome));
    }

    public void removeFuncionario(String idFuncionario) {
    	this.repositoryContas.removeFuncionario(idFuncionario);
    }

    public void adicionaADM(String ID, String senha, String nome) {
    	this.repositoryContas.putAdministrador(ID, new Administrador(ID, cripto.Criptografar(senha), nome));
    }

    public void removeADM(String ID) {
    	this.repositoryContas.removeADM(ID);
    }
    
    public Set<String> getChavesFuncionario() {
    	return this.repositoryContas.getChaveFuncionario();
    }
    
    public Set<String> getChavesADM() {
    	return this.repositoryContas.getChaveADM();
    }

	public void alteraSenha(String ID, String novaSenha) {
		this.repositoryContas.getFuncionario(ID).setSenha(cripto.Criptografar(novaSenha));
	}

}