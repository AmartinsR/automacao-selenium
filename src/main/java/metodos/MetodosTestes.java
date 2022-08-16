package metodos;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//1º metodo
public class MetodosTestes {

	WebDriver driver;

	// .setProperty é um método da classe System
	// 1ª "" - webdriver fixo, driver fixo, o que se alterá é o chrome, pois depende
	// do navegador a ser testado
	// 2ª "" - caminho do driver, qual o caminho do projeto até chegar no chrome
	// driver "." está na raiz do projeto / expandir significa que iremos acessar
	// uma nova pasta
	// continuando..., após a barra, colocar o nome da pasta /Drivers/colocar o nome
	// do arquivo que colocamos dentro desta pasta. usamos os supositórios do
	// Selenium e Junit

	// 2º método
	public void abrirNavegador(String url) {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		// criar um objeto, para utilizar os métodos do driver
		driver = new ChromeDriver();
		// para maximizar o navegador
		driver.manage().window().maximize();
		// get é o site que eu quero entrar para testar
		driver.get(url);

	}

	// 3º método
	public void validarTitulo(String tituloEsperado) {

		// para pegar o titulo do site
		String titulo = driver.getTitle();
		assertEquals(tituloEsperado, titulo);
	}

	// 4º método
	public void validarUrl(String urlEsperada) {
		// driver.getCurrentUrl para pegar a url da página
		String url = driver.getCurrentUrl();
		assertEquals(urlEsperada, url);

	}

	// 5º método
	public void fecharNavegador() {

		// driver.quit - serve também para fechar a tela após cada teste
		driver.quit();

	}

	// 6º método
	public void evienciarTeste(String nomeEvidencia) throws IOException {
		
		// Classe TakesScreenshot é responsável por tirar prints/fotos da tela
		// porque driver? porque ele se comunica com a tela, tem acesso a tela atravéz
		// da classe webdriver que é do selenium
		// Addcast - responsável por fazer
		// Nos preparamos para tirar a foto
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		
		// File - é o arquivo tiramos/pegamos a foto
		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		
		// precisamos guardar o arquivo File dar um destino destFile, o caminho dentro
		// de "", pois é uma String
		File destFile = new File("./evidencias/" + nomeEvidencia + ".png");
		
		// por fim copiamos a foto no destido
		FileUtils.copyFile(scrFile, destFile);
	}
	
	// 7º método, fazer uma busca
	public void escrever(By elemento, String texto) {
		//estamos escrevendo um texto automaticamente nesta linha
		driver.findElement(elemento).sendKeys(texto);
		
	}
	
}