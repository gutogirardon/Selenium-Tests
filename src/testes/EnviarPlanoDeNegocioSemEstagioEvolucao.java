package testes;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testlink.api.java.client.TestLinkAPIResults;
import utils.Geradores;
import utils.TestLinkUtils;

public class EnviarPlanoDeNegocioSemEstagioEvolucao {

	public static WebDriver driver;
	public static String url = "http://ggirardon.com:8080/GerenciadorPampatec/";

	@Before
	public void openBrowser() throws MalformedURLException {
		// System.setProperty("webdriver.chrome.driver",
		// "/home/guto/Documentos/chromedriver");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().logs();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void cadastroPlanoNegocioSemEstagio() throws Exception {

		try {
			driver.get(url);

			driver.findElement(By.id("formularioDeLogin:emailInput")).clear();
			driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("ggirardon@gmail.com");
			driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("Guto1508");

			driver.findElement(By.id("formularioDeLogin:botaoLogin")).sendKeys(Keys.ENTER);

			driver.findElement(By.linkText("Planos de Negócio")).click();
			driver.findElement(By.name("menuSuperior:menuSuperior:j_idt28")).click();

			driver.findElement(By.id("lista_planos:singleDT:1:visualizar")).click();

			WebDriverWait wait = new WebDriverWait(driver, 10);
			// wait.until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt65"))).click();

			// aqui comeca produto ou servico

			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Produto ou Serviço"))).click();
			
			//driver.findElement(By.id("formulario_cadastro_projeto:botaoSalvar4")).click();

	
			// TestLinkUtils.reportResult("Cadastrar Plano de NegÃ³cio", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			// TestLinkUtils.reportResult("Cadastrar Plano de NegÃ³cio", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			//TestLinkUtils.reportResult("Visualizar plano de negócio completo", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());
		}
	}

}
