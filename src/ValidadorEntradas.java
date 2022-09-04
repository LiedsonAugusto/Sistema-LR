public class ValidadorEntradas {
	
	String vazio = "Erro por valor de entrada vazia";
	String nulo = "Erro por valor de entrada nula";
	String nPositivo = "Erro por valor de menor que zero";
	
	public void valida(String argumento) {
		if (argumento.isBlank()) {
			throw new IllegalArgumentException(vazio);
		}
		if (argumento.equals(null)) {
			throw new NullPointerException(nulo);
		}
	}
	
	public void valida (String[] argumentos) {
		for (String argumento : argumentos) {
			valida(argumento);
		}
	}
	
	public void validaPositivo (Integer argumento) {
		if (argumento == null) {
			throw new NullPointerException(nulo);
		}
		if (argumento > 0) {
			throw new IllegalArgumentException(nPositivo);
		}
	}
}