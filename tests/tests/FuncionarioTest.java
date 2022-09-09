package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FuncionarioTest extends TestesGerais{

	String produto = "";
	
	@Test
	void visualizaProduto() {
		String id = controllerAdministrador.adicionaProduto("Pétala de Rosa", 1.00);
		assertEquals("1 | Pétala de Rosa | 1.0 R$", controllerFuncionario.visualizarProduto(id));
	}
}
