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
		try {
			controllerAdministrador.listaProduto(null);
			fail(nulo);
		} catch (NullPointerException npe) {}
		
		try {
			controllerAdministrador.listaProduto("");
			fail(vazio);
		} catch (IllegalArgumentException iae) {}
		
		try {
			String idProduto1 = controllerAdministrador.adicionaProduto("ESCOVA", -1111);
			fail(positivo);
		} catch (IllegalArgumentException iae) {}
		
		String idProduto1 = controllerAdministrador.adicionaProduto("ESCOVA", 1111);
		String toStringProduto1 = "1 | ESCOVA | 1 Itens em estoque | 1111,00 R$";
		assertEquals(toStringProduto1 + '\n', controllerAdministrador.listaProduto(idProduto1));
		
		try {
			controllerAdministrador.listaProduto("1100");
		} catch (IllegalArgumentException iae) {}
		
	}

}
