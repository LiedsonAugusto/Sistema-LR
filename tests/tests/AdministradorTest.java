package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import Produtos.Produto;

class AdministradorTest extends TestesGerais{

	@Test
	void testListarDeposito() {
		try {
			controllerAdministrador.listarDeposito();
			fail(rte);
		} catch (RuntimeException rte) {}
		
		Produto produto1 = new Produto("ESCOVA", 1111);
		depositoDeProdutos.put(produto1);
		String toStringProduto1 = "1 | ESCOVA | 1 Itens em estoque | 1111,00 R$";
		assertEquals(toStringProduto1 + '\n', controllerAdministrador.listarDeposito());
		
		Produto produto2 = new Produto("COXINHA", 123);
		depositoDeProdutos.put(produto2);
		String toStringProduto2 = "2 | COXINHA | 1 Itens em estoque | 123,00 R$";
		assertEquals(toStringProduto1 + '\n' + toStringProduto2 + '\n', controllerAdministrador.listarDeposito());
		
		Produto produto3 = new Produto("TV", 3.50);
		depositoDeProdutos.put(produto3);
		String toStringProduto3 = "3 | TV | 1 Itens em estoque | 3,50 R$";
		assertEquals(toStringProduto1 + '\n' + toStringProduto2+ '\n' + toStringProduto3 + '\n', controllerAdministrador.listarDeposito());
		
		String idProduto1 = produto1.getID();
		String idProduto2 = produto2.getID();
		String idProduto3 = produto3.getID();
		
		depositoDeProdutos.remove(idProduto3);
		assertEquals(toStringProduto1 + '\n' + toStringProduto2 + '\n', controllerAdministrador.listarDeposito());
		depositoDeProdutos.remove(idProduto2);
		assertEquals(toStringProduto1 + '\n', controllerAdministrador.listarDeposito());
		depositoDeProdutos.remove(idProduto1);
		
		try {
			controllerAdministrador.listarDeposito();
			fail(rte);
		} catch (RuntimeException rte) {}
		
	}
	
	@Test
	void testListaProduto() {
		String idProduto1;
		try {
			controllerAdministrador.listaProduto(null);
			fail(nulo);
		} catch (NullPointerException npe) {}
		
		try {
			controllerAdministrador.listaProduto("");
			fail(vazio);
		} catch (IllegalArgumentException iae) {}
		
		try {
			idProduto1 = controllerAdministrador.adicionaProduto("ESCOVA", -1111);
			fail(positivo);
		} catch (IllegalArgumentException iae) {}
		
		idProduto1 = controllerAdministrador.adicionaProduto("ESCOVA", 1111);
		String toStringProduto1 = "1 | ESCOVA | 1 Itens em estoque | 1111,00 R$";
		assertEquals(toStringProduto1 + '\n', controllerAdministrador.listaProduto(idProduto1));
		
		try {
			controllerAdministrador.listaProduto("1100");
		} catch (IllegalArgumentException iae) {}
		
		controllerAdministrador.removeProduto(idProduto1);
		
		try {
			controllerAdministrador.listaProduto(idProduto1);
		} catch (IllegalArgumentException iae) {} 
		
	}
	
	@Test
	void testListarHistorico() {
		try {
			controllerAdministrador.listarHistorico();
			fail(rte);
		} catch(RuntimeException rte) {}
		controllerAdministrador.adicionaProduto("TV", 1000);
		controllerAdministrador.adicionaProduto("CAMA", 1500);
		
		String idVenda = controllerFuncionario.iniciaVenda();
		controllerFuncionario.adicionarProduto("1", "1", 3);
		controllerFuncionario.adicionarProduto("2", "1", 1);
		controllerFuncionario.concluirVenda(idVenda);
		
		String retornoDaVenda = "1 - ID da venda | " + historicoDeVendas.get("1").getDataDeVenda() + " - Data da venda" + " | " + "Concluida";
		
		assertEquals(retornoDaVenda + '\n', controllerAdministrador.listarHistorico());
	}
	
	@Test
	void testListarHistotico() {
		try {
			controllerAdministrador.listarHistorico(null);
			fail(nulo);
		} catch (NullPointerException npe) {}
		try {
			controllerAdministrador.listarHistorico(" ");
			fail(vazio);
		} catch (IllegalArgumentException iae) {}
		try {
			controllerAdministrador.listarHistorico("09-02-2002");
			fail(iae);
		} catch(IllegalArgumentException iae) {}
		
		controllerAdministrador.adicionaProduto("TV", 1000);
		String idVenda = controllerFuncionario.iniciaVenda();
		controllerFuncionario.adicionarProduto("1", "1", 3);
		String retorno = "1 - ID da venda | " + historicoDeVendas.get("1").getDataDeVenda() + " - Data da venda | Em andamento" + 
				'\n' + "1 | TV | 1000,00 R$ | 3x | 3000,00 R$" + '\n';
				
		assertEquals(retorno + '\n', controllerAdministrador.listarHistorico(historicoDeVendas.get("1").getDataDeVenda()));

		controllerAdministrador.adicionaProduto("CAMA", 1500);
		controllerFuncionario.adicionarProduto("2", "1", 1);
		controllerFuncionario.adicionarProduto("1", "1", 1);
		controllerFuncionario.concluirVenda(idVenda);
		
		retorno = "1 - ID da venda | " + historicoDeVendas.get("1").getDataDeVenda() + " - Data da venda | Concluida" + 
						'\n' + "1 | TV | 1000,00 R$ | 4x | 4000,00 R$" + '\n' +
								"2 | CAMA | 1500,00 R$ | 1x | 1500,00 R$\n";

		assertEquals(retorno + '\n', controllerAdministrador.listarHistorico(historicoDeVendas.get("1").getDataDeVenda()));
		
	}
	
	@Test
	void testAlteraNomeProduto() {
		try {
			controllerAdministrador.alteraNomeProduto(null, null);
			fail(nulo);
		} catch (NullPointerException npe) {}
		try {
			controllerAdministrador.alteraNomeProduto("", " ");
			fail(iae);
		} catch (IllegalArgumentException iae) {}
		try {
			controllerAdministrador.alteraNomeProduto("1111", "TESTE");
			fail(iae);
		} catch (IllegalArgumentException iae) {}
		controllerAdministrador.adicionaProduto("TV", 3000);
		controllerAdministrador.alteraNomeProduto("1", "NOVATV");
		String toStringProduto1 = "1 | NOVATV | 1 Itens em estoque | 3000,00 R$";
		assertEquals(toStringProduto1 + '\n', controllerAdministrador.listaProduto("1"));
	}
	
	@Test
	void testAlteraPrecoProduto() {
		try {
			controllerAdministrador.alteraPrecoProduto(null, 0.0);
			fail(nulo);
		} catch (NullPointerException npe) {}
		try {
			controllerAdministrador.alteraPrecoProduto("", 0.0);
			fail(iae);
		} catch(IllegalArgumentException iae) {}
		try {
			controllerAdministrador.alteraPrecoProduto("1111", 1000);
			fail(iae);
		} catch (IllegalArgumentException iae) {}
		controllerAdministrador.adicionaProduto("TV", 3000);
		controllerAdministrador.alteraPrecoProduto("1", 3500);
		String toStringProduto1 = "1 | TV | 1 Itens em estoque | 3500,00 R$";
		assertEquals(toStringProduto1 + '\n', controllerAdministrador.listaProduto("1"));
	}
		
	@Test
	void testAdicionaProduto() {
		try {
			controllerAdministrador.adicionaProduto(null, 2000);
			fail(nulo);
		} catch (NullPointerException npe) {}
		try {
			controllerAdministrador.adicionaProduto("", 2000);
			fail(iae);
		} catch (IllegalArgumentException npe) {}
		try {
			controllerAdministrador.adicionaProduto("oi123", 400);
			fail(iae);
		} catch (IllegalArgumentException iae) {}
		try {
			controllerAdministrador.adicionaProduto("TV", -500);
			fail(iae);
		} catch (IllegalArgumentException iae) {}
	}
	
	@Test
	void testRemoveProduto() {
		try {
			controllerAdministrador.removeProduto(null);
			fail(nulo);
		} catch (NullPointerException npe) {}
		try {
			controllerAdministrador.removeProduto("");
			fail(iae);
		} catch (IllegalArgumentException iae) {}
		try {
			controllerAdministrador.removeProduto("111");
			fail(iae);
		} catch (IllegalArgumentException iae) {}
		controllerAdministrador.adicionaProduto("TV", 3000);
		controllerAdministrador.adicionaProduto("HD", 500);
		controllerAdministrador.removeProduto("2");
		try {
			controllerAdministrador.listaProduto("2");
			fail(iae);
		} catch (IllegalArgumentException iae) {}
		controllerAdministrador.removeProduto("1");
		try {
			controllerAdministrador.listaProduto("1");
			fail(iae);
		} catch (IllegalArgumentException iae) {}
	}
	
	@Test
	void testLimparDeposito() {
		try {
			controllerAdministrador.limparDeposito();
			fail(rte);
		} catch (RuntimeException rte) {}
		controllerAdministrador.adicionaProduto("TV", 3000);
		controllerAdministrador.limparDeposito();
		try {
			controllerAdministrador.listarDeposito();
			fail(rte);
		} catch (RuntimeException rte) {}
		controllerAdministrador.adicionaProduto("TV", 3000);
		controllerAdministrador.adicionaProduto("CD", 3500);
		controllerAdministrador.limparDeposito();
		try {
			controllerAdministrador.listarDeposito();
			fail(rte);
		} catch (RuntimeException rte) {}
	}
	
	@Test
	void testTamanhoDeposito() {
		assertEquals(0, controllerAdministrador.tamanhoDeposito());
		controllerAdministrador.adicionaProduto("TV", 3000);
		assertEquals(1, controllerAdministrador.tamanhoDeposito());
		controllerAdministrador.removeProduto("1");
		assertEquals(0, controllerAdministrador.tamanhoDeposito());
	}
	
	@Test
	void testTamanhoHistorico() {
		assertEquals(0, controllerAdministrador.tamanhoHistorico());
		controllerAdministrador.adicionaProduto("TV", 1000);
		controllerAdministrador.adicionaProduto("CAMA", 1500);
		String idVenda = controllerFuncionario.iniciaVenda();
		controllerFuncionario.adicionarProduto("1", "1", 3);
		controllerFuncionario.adicionarProduto("2", "1", 1);
		controllerFuncionario.concluirVenda(idVenda);
		assertEquals(1, controllerAdministrador.tamanhoHistorico());
		controllerFuncionario.removerVenda("1");
		assertEquals(0, controllerAdministrador.tamanhoHistorico());
	}
}
