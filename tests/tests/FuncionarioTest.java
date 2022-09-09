package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FuncionarioTest extends TestesGerais{

	String produto = "1 | Pétala de Rosa | 1,00 R$";
	String estoque = "~~Estoque~~\n\n" + produto + "\n\n";
	String estoqueVazio = "~~Estoque~~\n\nVazio --\n\n";
	
	@Test
	void testVisualizaProduto() {
		try {
			controllerFuncionario.visualizarProduto(null);
			fail(nulo);
		} catch (NullPointerException npe) {}
		
		try {
			controllerFuncionario.visualizarProduto("");
			fail(vazio);
		} catch (IllegalArgumentException iae) {}
		
		try {
			controllerFuncionario.visualizarProduto("ID Nenhum");
			fail(idInexistente);
		} catch (IllegalArgumentException iae) {}
		
		String id = this.controllerAdministrador.adicionaProduto("Pétala de Rosa", 1.00);
		assertEquals(produto, controllerFuncionario.visualizarProduto(id));
	}
	
	@Test
	void testVisualizarEstoque() {
		String id = this.controllerAdministrador.adicionaProduto("Pétala de Rosa", 1.00);
		assertEquals(estoque, controllerFuncionario.visualizarEstoque());
		controllerAdministrador.removeProduto(id);
		assertEquals(estoqueVazio, controllerFuncionario.visualizarEstoque());
	}
	
	@Test
	void testVisualizaVenda() {
		String idProduto = this.controllerAdministrador.adicionaProduto("Pétala de Rosa", 1.00);
		String idVenda = controllerFuncionario.iniciaVenda();
		String venda = "1 - ID da venda | " + controllerFuncionario.getDataVenda(idVenda) + " - Data da venda";
		assertEquals(venda, controllerFuncionario.visualizarVenda(idVenda));
	}
}
