package Login;

public class Administrador {

    private String nome;
    private String ID;
    private String senha;

    public Administrador(String ID, String nome, String senha) {
    	this.nome = nome;
    	this.ID = ID;
    	this.senha = senha;
    }

    public String getNome() {
    	return this.nome;
    }

    public String getID() {
    	return this.ID;
    }

    public String getSenha() {
    	return this.senha;
    }

}