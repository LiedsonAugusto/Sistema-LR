package Login;

public class ChaveCriptografia {
	
	String[] chars1 = {"q", "e", "t", "u", "o", "l", "j", "g", "d", "a", "x", "v", "n"};
	String[] chars2 = {"w", "r", "y", "i", "p", "k", "h", "f", "s", "z", "c", "b", "m"};
	
	public String Criptografar(String senha) {
		String criptografia = "";
		
		for (char caractere : senha.toCharArray()) {
			String hex = String.format("%x", (int) caractere);
			criptografia += hex;
		}
		return null;
	}
	
	public String Descriptografar(String senha) {
		return null;
	}
}
