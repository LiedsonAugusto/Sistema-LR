package Login;

import java.util.HashMap;

public class RepositoryContas {

    private HashMap<String, Funcionario> funcionarios;
    private HashMap<String, Administrador> administradores;

    public RepositoryContas () {
    	this.funcionarios = new HashMap<>();
    	this.administradores = new HashMap<>();
    }
    
    public Funcionario getFuncionario(String ID) {
    	return this.funcionarios.get(ID);
    }

    public void putFuncionario(Funcionario funcionario) {
    	this.funcionarios.put(Integer.toString(this.funcionarios.size() + 1), funcionario);
    }

    public void removeFuncionario(String ID) {
    	this.funcionarios.remove(ID);
    }

    public Administrador getAdministrador(String ID) {
    	return this.administradores.get(ID);
    }

    public void putAdministrador(Administrador administrador) {
    	this.administradores.put(Integer.toString(this.administradores.size() + 1), administrador);
    }

    public void removeAdministrador(String ID) {
    	this.administradores.remove(ID);
    }
    
    

}