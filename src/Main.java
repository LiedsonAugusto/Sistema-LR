public class Main {

	public static void main(String[] args) {
		
		String senha = "Bobinho123";
		String criptografia = "";
		
		for (char caractere : senha.toCharArray()) {
			String hex = String.format("%x", ((int) caractere) + 1000);
			criptografia += hex;
		}
		
		StringBuilder sb = new StringBuilder(criptografia.length() / 2);
		for (int i = 0; i < criptografia.length(); i += 2) {
			String hex = "" + criptografia.charAt(i) + criptografia.charAt(i + 1);
			int charInt = Integer.parseInt(hex, 16);
			sb.append((char) charInt);
		}
		senha = sb.toString();
		System.out.println(senha);
	}
	
}