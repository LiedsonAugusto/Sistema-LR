package Validador;

import java.util.Set;

public class ValidadorEntradas {
	
	String vazio = "Erro por valor de entrada vazia";
	String nulo = "Erro por valor de entrada nula";
	String nPositivo = "Erro por valor de menor que zero";
	String nNome = "Erro por ter NÚMERO no nome";
	String idInvalido = "Erro ao passar ID inexistente";
	String dataInvalida = "Erro ao passar data inexistente";
	
	public void valida(String argumento) {
		if (argumento.isBlank()) {
			throw new IllegalArgumentException(this.vazio);
		}
		if (argumento.equals(null)) {
			throw new NullPointerException(this.nulo); 
		}
	}
	
	public void valida (String[] argumentos) {
		for (String argumento : argumentos) {
			valida(argumento);
		}
	}
	
	public void validaPositivo (Integer argumento) {
		if (argumento == null) {
			throw new NullPointerException(this.nulo);
		}
		if (argumento < 0) {
			throw new IllegalArgumentException(this.nPositivo);
		}
	}
	
	public void validaPositivo (Double argumento) {
		if (argumento == null) {
			throw new NullPointerException(this.nulo);
		}
		if (argumento < 0) {
			throw new IllegalArgumentException(this.nPositivo);
		}
	}
	
	public void validaNome(String argumento) {
		for (char letra : argumento.toCharArray()) {
			if (Character.isDigit(letra)) {
				throw new IllegalArgumentException(this.nNome);
			}
		}
	}
	
	public void validarIDInexistente(Set<String> chaves, String ID) {
		for (String chave : chaves) {
			if (chave.equals(ID)) {
				return;
			}
		}
		throw new IllegalArgumentException(idInvalido); 
	}
	
	public void validarData(Set<String> chaves, String data) {
		for (String chave : chaves) {
			if (chave.equals(data)) {
				return;
			}
		}
		throw new IllegalArgumentException(dataInvalida); 
	}
}