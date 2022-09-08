package tests;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

class LoginTest extends TestesGerais{

	@Test
	void testValidaLogADM() {
		String id = "IDADM", senha = "SENHAADM";
		Assertions.assertEquals(true, controllerLogin.validaLoginAdm(id, senha));
	}

}
