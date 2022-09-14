package Login;

import java.sql.*;
import java.util.HashMap;
import java.util.Set;

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

    public void putFuncionario(String ID, Funcionario funcionario) throws SQLException {
    	this.funcionarios.put(ID, funcionario);
    }

    public void removeFuncionario(String ID) {
    	this.funcionarios.remove(ID);
    }

    public Administrador getAdministrador(String ID) {
    	return this.administradores.get(ID);
    }

    public void putAdministrador(String ID, Administrador administrador) {
    	this.administradores.put(ID, administrador);
    }

    public void removeADM(String ID) {
    	this.administradores.remove(ID);
    }
    
    public Set<String> getChaveFuncionario() {
    	return this.funcionarios.keySet();
    }
    
    public Set<String> getChaveADM(){
    	return this.administradores.keySet();
    }
    
}