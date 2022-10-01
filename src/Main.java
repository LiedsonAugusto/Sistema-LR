import Login.Cripto;

public class Main {

	public static void main(String[] args) {
		Cripto c = new Cripto();
		String a = "123456";
		String b = c.quebrarDoService(c.quebrarDoService(a));
		String d = c.montarDoRepo(c.montarDoRepo(b));
		System.out.println(b);
		System.out.println(d);
	}
}