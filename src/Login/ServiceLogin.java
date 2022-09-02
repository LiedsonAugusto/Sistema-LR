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

    public void validaLoginAdm(String ID, String senha) {
    	Administrador administrador = this.repositoryContas.getAdministrador(ID);
    }

    public void adicionaFuncionario(String idFuncionario, String nome, String senha) {

    }

    public void removeFuncionario(String idFuncionario) {

    }

    public void adicionaADM(String ID, String senha, String nome) {

    }

    public void removeADM(String ID) {

    }

}