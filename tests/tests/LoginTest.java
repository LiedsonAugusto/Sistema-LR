package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class LoginTest extends TestesGerais{

	@Test
	void testValidaLogFuncionario() {
		try {
			controllerLogin.validaLoginFuncionario(null, null);
			fail(nulo);
		} catch (NullPointerException npe) {}
		
		try {
			controllerLogin.validaLoginFuncionario("", "");
			fail(vazio);
		} catch (IllegalArgumentException iae) {}
		
		assertEquals(false, controllerLogin.validaLoginFuncionario(idFuncionario, "coxinha123"));
		assertEquals(false, controllerLogin.validaLoginFuncionario("nada", senhaFuncionario));
		assertEquals(false, controllerLogin.validaLoginFuncionario(idFuncionario, senhaADM));
		assertEquals(true, controllerLogin.validaLoginFuncionario(idFuncionario, senhaFuncionario));
	}
	
	@Test
	void testValidaLogAdm() {
		try {
			controllerLogin.validaLoginAdm(null, null);
			fail(nulo);
		} catch (NullPointerException npe) {}
		
		try {
			controllerLogin.validaLoginAdm("", "");
			fail(vazio);
		} catch (IllegalArgumentException iae) {}
		
		assertEquals(false, controllerLogin.validaLoginAdm(idAdm, "coxinha123"));
		assertEquals(false, controllerLogin.validaLoginAdm("nada", senhaADM));
		assertEquals(false, controllerLogin.validaLoginAdm(idAdm, senhaFuncionario));
		assertEquals(true, controllerLogin.validaLoginAdm(idAdm, senhaADM));
	}

	@Test
	void testAdicionaFuncionario() {
		try {
			controllerLogin.adicionaFuncionario(null, null, null);
			fail(nulo);
		} catch (NullPointerException npe) {}
		
		try {
			controllerLogin.adicionaFuncionario("", "", "");
			fail(vazio);
		} catch (IllegalArgumentException iae) {}
		
		try {
			controllerLogin.adicionaFuncionario("ID1", "nome1", "Senha1");
			fail(nome);
		} catch (IllegalArgumentException iae) {}
	}
}
