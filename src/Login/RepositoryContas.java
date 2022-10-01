package Login;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
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

    public void putFuncionario(String ID, Funcionario funcionario) {
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
    
    private String montar(String criptografia) {
    	String[] grupoSoma7  = {"q", "e", "t", "u", "o", "l"};
    	String[] grupoSoma12 = {"w", "r", "y", "i", "p", "k"};
    	String[] grupoSoma20 = {"j", "g", "d", "a", "x", "v", "n"};
    	String[] grupoSoma9  = {"h", "f", "s", "z", "c", "b", "m"};
    	String[] alfabeto = {"w", "r", "y", "i", "p", "k", "h", "f", "s", "z", "c", "b", "m", "q", "e", "t", "u", "o", "l", "j", "g", "d", "a", "x", "v", "n"};
    	HashSet<String> setSoma7 = new HashSet<>();
    	HashSet<String> setSoma12 = new HashSet<>();
    	HashSet<String> setSoma20 = new HashSet<>();
    	HashSet<String> setSoma9 = new HashSet<>();
    	Random gerador = new Random();
    	
    	for (String letra : grupoSoma7) {
			setSoma7.add(letra);
		}
		for (String letra : grupoSoma12) {
			setSoma12.add(letra);
		}
		for (String letra : grupoSoma20) {
			setSoma20.add(letra);
		}
		for (String letra : grupoSoma9) {
			setSoma9.add(letra);
		}
    	
    	String retorno = "";
		String criptoInvertida = "";
		int soma = 0;
		
		for (int i = 0; i < criptografia.length(); i += 3) {
			String hexadecimal = "" + criptografia.charAt(i) + criptografia.charAt(i + 1);
			String chave = "" + criptografia.charAt(i + 2);
			
			if (setSoma12.contains(chave)) {
				soma = 12;
			} else if (setSoma20.contains(chave) ) {
				soma = 20;
			} else if (setSoma7.contains(chave)) {
				soma = 7;
			} else if (setSoma9.contains(chave)) {
				soma = 9;
			}
			
			int decimal = Integer.parseInt(hexadecimal, 16) - soma;
			retorno += (char) decimal;
		}
		
		for (int i = retorno.length() - 1; i > -1; i--) {
			criptoInvertida += "" + retorno.charAt(i);
		}
		
		return criptoInvertida;
    }
}