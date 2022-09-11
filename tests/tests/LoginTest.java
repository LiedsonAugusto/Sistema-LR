package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class LoginTest extends TestesGerais{

	@Test
	void testValidaLogFuncionario() {
		try {
			controllerLoginFuncionario.validaLoginFuncionario(null, null);
			fail(nulo);
		} catch (NullPointerException npe) {}
		
		try {
			controllerLoginFuncionario.validaLoginFuncionario("", "");
			fail(vazio);
		} catch (IllegalArgumentException iae) {}
		
		assertEquals(false, controllerLoginFuncionario.validaLoginFuncionario(idFuncionario, "coxinha123"));
		assertEquals(false, controllerLoginFuncionario.validaLoginFuncionario("nada", senhaFuncionario));
		assertEquals(false, controllerLoginFuncionario.validaLoginFuncionario(idFuncionario, senhaADM));
		assertEquals(true, controllerLoginFuncionario.validaLoginFuncionario(idFuncionario, senhaFuncionario));
	}
	
	@Test
	void testValidaLogAdm() {
		try {
			controllerLoginAdministrador.validaLoginAdm(null, null);
			fail(nulo);
		} catch (NullPointerException npe) {}
		
		try {
			controllerLoginAdministrador.validaLoginAdm("", "");
			fail(vazio);
		} catch (IllegalArgumentException iae) {}
		
		assertEquals(false, controllerLoginAdministrador.validaLoginAdm(idAdm, "coxinha123"));
		assertEquals(false, controllerLoginAdministrador.validaLoginAdm("nada", senhaADM));
		assertEquals(false, controllerLoginAdministrador.validaLoginAdm(idAdm, senhaFuncionario));
		assertEquals(true, controllerLoginAdministrador.validaLoginAdm(idAdm, senhaADM));
	}

	@Test
	void testAdicionaRemoveFuncionario() {
		try {
			controllerLoginAdministrador.adicionaFuncionario(null, null, null);
			fail(nulo);
		} catch (NullPointerException npe) {}
		
		try {
			controllerLoginAdministrador.adicionaFuncionario("", "", "");
			fail(vazio);
		} catch (IllegalArgumentException iae) {}
		
		try {
			controllerLoginAdministrador.adicionaFuncionario("ID1", "Senha1", "nome1");
			fail(nome);
		} catch (IllegalArgumentException iae) {}
		
		try {
			controllerLoginAdministrador.adicionaFuncionario(idFuncionario, "Senha1", "nome");
		} catch (IllegalArgumentException iae) {}
		
		controllerLoginAdministrador.adicionaFuncionario("ID1", "Senha1", "nome");
		assertEquals(true, controllerLoginFuncionario.validaLoginFuncionario("ID1", "Senha1"));
		controllerLoginAdministrador.removeFuncionario("ID1");
		assertEquals(false, controllerLoginFuncionario.validaLoginFuncionario("ID1", "Senha1"));
	}
	
	@Test
	void testAdicionaRemoveADM() {
		try {
			controllerLoginAdministrador.adicionaADM(null, null, null);
			fail(nulo);
		} catch (NullPointerException npe) {}
		
		try {
			controllerLoginAdministrador.adicionaADM("", "", "");
			fail(vazio);
		} catch (IllegalArgumentException iae) {}
		
		try {
			controllerLoginAdministrador.adicionaADM("ID1", "Senha1", "nome1");
			fail(nome);
		} catch (IllegalArgumentException iae) {}
		
		try {
			controllerLoginAdministrador.adicionaADM(idAdm, "Senha1", "nome");
		} catch (IllegalArgumentException iae) {}
		

		controllerLoginAdministrador.adicionaADM("ID1", "Senha1", "nome");
		assertEquals(true, controllerLoginAdministrador.validaLoginAdm("ID1", "Senha1"));
		controllerLoginAdministrador.removeADM("ID1");
		assertEquals(false, controllerLoginAdministrador.validaLoginAdm("ID1", "Senha1"));
	}
}
