package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FuncionarioTest extends TestesGerais{

	String produto = "1 | Pétala de Rosa | 1,00 R$";
	String produtoDTO = "1 | Pétala de Rosa | 1,00 R$ | 2x | 2,00 R$";
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
		
		String id = controllerAdministrador.adicionaProduto("Pétala de Rosa", 1.00);
		assertEquals(produto, controllerFuncionario.visualizarProduto(id));
	}
	
	@Test
	void testVisualizarEstoque() {
		String id = controllerAdministrador.adicionaProduto("Pétala de Rosa", 1.00);
		assertEquals(estoque, controllerFuncionario.visualizarEstoque());
		controllerAdministrador.removeProduto(id);
		assertEquals(estoqueVazio, controllerFuncionario.visualizarEstoque());
	}
	
	@Test
	void testVisualizaAdicionaRemoveVendaProduto() {
		String idProduto = controllerAdministrador.adicionaProduto("Pétala de Rosa", 1.00);
		String idVenda = controllerFuncionario.iniciaVenda();
		String venda = "1 - ID da venda | " + controllerFuncionario.getDataVenda(idVenda) + " - Data da venda" + " | Em andamento\n";
		assertEquals(venda, controllerFuncionario.visualizarVenda(idVenda));
		controllerFuncionario.adicionarProduto(idProduto, idVenda, 2);
		venda = "1 - ID da venda | " + controllerFuncionario.getDataVenda(idVenda) + " - Data da venda" + " | Em andamento\n" + produtoDTO + "\n";
		assertEquals(venda, controllerFuncionario.visualizarVenda(idVenda));
		controllerFuncionario.adicionarProduto(idProduto, idVenda, 2);
		produtoDTO = "1 | Pétala de Rosa | 1,00 R$ | 4x | 4,00 R$";
		venda = "1 - ID da venda | " + controllerFuncionario.getDataVenda(idVenda) + " - Data da venda" + " | Em andamento\n" + produtoDTO + "\n";
		assertEquals(venda, controllerFuncionario.visualizarVenda(idVenda));
		controllerFuncionario.removerProduto(idVenda, idProduto, 1);
		produtoDTO = "1 | Pétala de Rosa | 1,00 R$ | 3x | 3,00 R$";
		venda = "1 - ID da venda | " + controllerFuncionario.getDataVenda(idVenda) + " - Data da venda" + " | Em andamento\n" + produtoDTO + "\n";
		assertEquals(venda, controllerFuncionario.visualizarVenda(idVenda));
		controllerFuncionario.removerProduto(idVenda, idProduto, 10);
		venda = "1 - ID da venda | " + controllerFuncionario.getDataVenda(idVenda) + " - Data da venda" + " | Em andamento\n";
		assertEquals(venda, controllerFuncionario.visualizarVenda(idVenda));
		controllerFuncionario.iniciaVenda();
		String venda2 = "2 - ID da venda | " + controllerFuncionario.getDataVenda("2") + " - Data da venda" + " | Em andamento\n";
		assertEquals(venda2, controllerFuncionario.visualizarVenda("2"));
	}
	
	@Test
	void testIniciaAdicionaRemoveVisualizaInvalidas() {
		try {
			controllerFuncionario.visualizarVenda("NãoTemVenda");
			fail(idInexistente);
		} catch (IllegalArgumentException iae) {}
		
		try {
			controllerFuncionario.visualizarVenda(null);
			fail(nulo);
		} catch (NullPointerException npe) {}
		
		try {
			controllerFuncionario.visualizarVenda("");
			fail(vazio);
		} catch (IllegalArgumentException iae) {}
		
		try {
			controllerFuncionario.concluirVenda("NãoTemVenda");
			fail(idInexistente);
		} catch (IllegalArgumentException iae) {}
		
		try {
			controllerFuncionario.concluirVenda(null);
			fail(nulo);
		} catch (NullPointerException npe) {}
		
		try {
			controllerFuncionario.concluirVenda("");
			fail(vazio);
		} catch (IllegalArgumentException iae) {}
		
		try {
			controllerFuncionario.adicionarProduto("NãoTemProduto", "NãoTemVenda", 1);
			fail(idInexistente);
		} catch (IllegalArgumentException iae) {}
		
		try {
			controllerFuncionario.adicionarProduto(null, null, 1);
			fail(nulo);
		} catch (NullPointerException npe) {}
		
		try {
			controllerFuncionario.iniciaVenda();
			controllerAdministrador.adicionaProduto("Pétala de Rosa", 1.00);
			controllerFuncionario.adicionarProduto("1", "1", -1);
			fail(positivo);
		} catch (IllegalArgumentException iae) {}
		
		try {
			controllerFuncionario.removerProduto("NãoTemVenda", "NãoTemProduto", 1);
			fail(idInexistente);
		} catch (IllegalArgumentException iae) {}
		
		try {
			controllerFuncionario.removerProduto(null, null, 1);
			fail(nulo);
		} catch (NullPointerException npe) {}
		
		try {
			controllerFuncionario.iniciaVenda();
			controllerAdministrador.adicionaProduto("Pétala de Rosa", 1.00);
			controllerFuncionario.removerProduto("1", "1", -1);
			fail(positivo);
		} catch (IllegalArgumentException iae) {}
	}
	
}
