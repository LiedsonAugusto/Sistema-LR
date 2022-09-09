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
	void testAdicionaRemoveFuncionario() {
		try {
			controllerLogin.adicionaFuncionario(null, null, null);
			fail(nulo);
		} catch (NullPointerException npe) {}
		
		try {
			controllerLogin.adicionaFuncionario("", "", "");
			fail(vazio);
		} catch (IllegalArgumentException iae) {}
		
		try {
			controllerLogin.adicionaFuncionario("ID1", "Senha1", "nome1");
			fail(nome);
		} catch (IllegalArgumentException iae) {}
		
		controllerLogin.adicionaFuncionario("ID1", "Senha1", "nome");
		assertEquals(true, controllerLogin.validaLoginFuncionario("ID1", "Senha1"));
		controllerLogin.removeFuncionario("ID1");
		assertEquals(false, controllerLogin.validaLoginFuncionario("ID1", "Senha1"));
	}
	
	@Test
	void testAdicionaRemoveADM() {
		try {
			controllerLogin.adicionaADM(null, null, null);
			fail(nulo);
		} catch (NullPointerException npe) {}
		
		try {
			controllerLogin.adicionaADM("", "", "");
			fail(vazio);
		} catch (IllegalArgumentException iae) {}
		
		try {
			controllerLogin.adicionaADM("ID1", "Senha1", "nome1");
			fail(nome);
		} catch (IllegalArgumentException iae) {}
		

		controllerLogin.adicionaADM("ID1", "Senha1", "nome");
		assertEquals(true, controllerLogin.validaLoginAdm("ID1", "Senha1"));
		controllerLogin.removeADM("ID1");
		assertEquals(false, controllerLogin.validaLoginAdm("ID1", "Senha1"));
	}
}
