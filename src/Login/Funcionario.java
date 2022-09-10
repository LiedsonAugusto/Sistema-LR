package Login;

public class Funcionario {

    private String nome;
    private String idFuncionario;
    private String senha;

    public Funcionario(String idFuncionario, String senha, String nome) {
    	this.nome = nome;
    	this.idFuncionario = idFuncionario;
    	this.senha = senha;
    }

    public String getNome() {
    	return this.nome;
    }

    public String getIdFuncionario() {
    	return this.idFuncionario;
    }

    public String getSenha() {
    	return this.senha;
    }

	public void setSenha(String novaSenha) {
		this.senha = novaSenha;
	}

}