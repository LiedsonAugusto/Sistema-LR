package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class LoginTest extends TestesGerais{

	@Test
	void testValidaLogFuncionario() {
		try {
			controllerLogin.validaLoginFuncionario(null, null);
			fail("Era esperado uma exception por parametros nulos.");
		} catch (NullPointerException npe) {}
	}

}
