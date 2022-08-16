package primeira.automacao.selenium.junit;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import metodos.MetodosTestes;

public class GoogleTeste {

	MetodosTestes metodos = new MetodosTestes();

	@Before
	public void setUp() throws Exception {
		metodos.abrirNavegador("https://www.google.com.br");
	}
	

	@After
	public void tearDown() throws Exception {
		metodos.fecharNavegador();
	}

	@Test
	public void validarTitulo() throws IOException {
		metodos.evienciarTeste("CT03 - titulo google");
		metodos.validarTitulo("Google");
	}
}