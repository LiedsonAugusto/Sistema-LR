package Login;

import java.util.HashSet;
import java.util.Random;

public class Cripto {
	
	String[] chars1 = {"q", "e", "t", "u", "o", "l", "j", "g", "d", "a", "x", "v", "n"};
	String[] chars2 = {"w", "r", "y", "i", "p", "k", "h", "f", "s", "z", "c", "b", "m"};
	HashSet<String> letras1 = new HashSet<>();
	HashSet<String> letras2 = new HashSet<>();
	String[] charsTodos = {"w", "r", "y", "i", "p", "k", "h", "f", "s", "z", "c", "b", "m", "q", "e", "t", "u", "o", "l", "j", "g", "d", "a", "x", "v", "n"};
	Random gerador = new Random();
	
	public Cripto() {
		for (String letra : this.chars1) {
			this.letras1.add(letra);
		}
		for (String letra : this.chars2) {
			this.letras2.add(letra);
		}
	}
	
	public String Criptografar(String senha) {
		String criptografia = "";
		int soma;
		
		for (String letra : this.chars1) {
			this.letras1.add(letra);
		}
		for (String letra : this.chars2) {
			this.letras2.add(letra);
		}
		
		for (char caractere : senha.toCharArray()) {
			int indice = gerador.nextInt(26);
			if (this.letras1.contains(this.charsTodos[indice])) { 
				soma = 7;
			} else {
				soma = 12;
			}
			String hex = String.format("%x", ((int) caractere + soma));
			criptografia += hex + this.charsTodos[indice];
		}
		
		return criptografia;
	}
	
	public String Descriptografar(String criptografia) {
		StringBuilder sb = new StringBuilder(criptografia.length() / 3);
		int charInt;
		for (int i = 0; i < criptografia.length(); i += 3) {
			String hex = "" + criptografia.charAt(i) + criptografia.charAt(i + 1);
			if (this.letras1.contains(String.valueOf(criptografia.charAt(i + 2)))) {
				charInt = (Integer.parseInt(hex, 16)) - 7;
			} else {
				charInt = (Integer.parseInt(hex, 16)) - 12;
			}
			
			sb.append((char) charInt);
		}
		return sb.toString();
	}
}
