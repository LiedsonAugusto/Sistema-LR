import java.sql.*;

import Inicializador.Inicializador;

public class Main {

	public static void main(String[] args) {
		/**Connection conexao = Inicializador.conectar();
		if (conexao == null) {
			System.out.println("conexão falhou.");
		} else {
			String sql = "insert into funcionarios (nome, id, senha) values (?, ?, ?)";
			
			try {
				PreparedStatement stm = conexao.prepareStatement(sql);
				stm.setString(1, "Funcionario Doidão");
				stm.setString(2, "121111333");
				stm.setString(3, "senhaDoidona");
				stm.execute();
				stm.close();
				conexao.close();
			} catch (SQLException e) {
				System.out.println("Erro ao criar");
			}
			
			try {
				sql = "delete from funcionarios where (?) ";
				PreparedStatement stm = conexao.prepareStatement(sql);
				stm.setString(1, "121111333");
				stm.execute();
				stm.close();
				conexao.close();
			} catch (SQLException e) {
				System.out.println("Erro ao deletar");
			}
			
			try {
				Statement stat = conexao.createStatement();
				ResultSet result = stat.executeQuery("select * from funcionarios;");
				
				while (result.next()) {
					System.out.println(result.getString("nome"));
				}
			} catch (SQLException e) {
				System.out.println("Erro toString");
			}
			
			
			System.out.println("\nFinalizado\n");
		}**/
	}
	
}