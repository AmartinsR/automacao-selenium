package primeira.automacao.selenium.junit;

import java.io.IOException;
import java.sql.Driver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import metodos.MetodosTestes;

public class PrimeiroTeste {

	// Before Ele é executado antes de qualquer teste//Before - responsável também
	// por abrir nosso browser

	MetodosTestes metodos = new MetodosTestes();
	By pesquisar = By.xpath("//input[@id='twotabsearchtextbox']");

	@Before

	public void setUp() throws Exception {

		metodos.abrirNavegador("https://www.amazon.com.br");

	}

	@After // Ele é executado após qualquer teste, depois que faço um teste, executa este
	public void tearDown() throws Exception {
		metodos.fecharNavegador();

	}

	// 1º teste
	@Test
	public void validarTitulo() throws IOException {

		metodos.validarTitulo("Amazon.com.br | Tudo pra você, de A a Z.");
		metodos.evienciarTeste("CT01 - validando titulo");
	}
	
	//2º teste
	@Test public void buscarProduto() throws IOException {
		
		metodos.escrever(pesquisar, "Iphone 13");
		metodos.evienciarTeste("CT02 - Buscar produto");
	
		
}
	}