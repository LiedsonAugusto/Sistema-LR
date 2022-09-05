package Login;

public class ServiceLogin {

    private RepositoryContas repositoryContas;
    
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
    	if (administrador != null && senha.equals(administrador.getSenha())) {
    		return true;
    	}
    	return false;
    }

    public void adicionaFuncionario(String idFuncionario, String nome, String senha) {
    	this.repositoryContas.putFuncionario(idFuncionario, new Funcionario(idFuncionario, nome, senha));
    }

    public void removeFuncionario(String idFuncionario) {
    	this.repositoryContas.removeFuncionario(idFuncionario);
    }

    public void adicionaADM(String ID, String nome, String senha) {
    	this.repositoryContas.putAdministrador(ID, new Administrador(ID, nome, senha));
    }

    public void removeADM(String ID) {
    	this.removeADM(ID);
    }

}