package Validador;

public class ValidadorEntradas {
	
	String vazio = "Erro por valor de entrada vazia";
	String nulo = "Erro por valor de entrada nula";
	String nPositivo = "Erro por valor de menor que zero";
	String nNome = "Erro por ter NÚMERO no nome";
	
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
		if (argumento > 0) {
			throw new IllegalArgumentException(this.nPositivo);
		}
	}
	
	public void validaNome(String argumento) {
		for (char letra : argumento.toCharArray()) {
			if (Character.getNumericValue(letra) >= 0) {
				throw new IllegalArgumentException(this.nNome);
			}
		}
	}
}