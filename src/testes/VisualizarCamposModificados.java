package testes;

import static org.junit.Assert.*;
import java.net.MalformedURLException;
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
import org.openqa.selenium.support.ui.WebDriverWait;

import testlink.api.java.client.TestLinkAPIResults;
import utils.Geradores;
import utils.TestLinkUtils;

public class VisualizarCamposModificados {
	public static WebDriver driver;
	public static String url = "http://ggirardon.com:8080/GerenciadorPampatec/";

	@Before
	public void openBrowser() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

		@Test
		public void testeLoginEmailValido() throws Exception {
			try {
				driver.get(url);

				driver.findElement(By.id("formularioDeLogin:emailInput")).clear();
				driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("gerente@ggirardon.com");
				driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123");
				driver.findElement(By.id("formularioDeLogin:botaoLogin")).sendKeys(Keys.ENTER);
				
				driver.findElement(By.linkText("Planos de Negócio")).click();
				driver.findElement(By.name("menuSuperior:menuSuperior:j_idt26")).click();

				driver.findElement(By.id("ui-button-text ui-c")).click();

				WebDriverWait wait = new WebDriverWait(driver, 10);
				
			
				driver.findElement(By.id("tabPlanoFinanceiro")).click();
				driver.findElement(By.id("formulario_comentarpreavalizar:campoObservacoes")).click();
				driver.findElement(By.id("formulario_comentarpreavalizar:observacoesPreDefinidas")).click();
				driver.findElement(By.id("formulario_comentarpreavalizar:avaliacao:0")).click();
				driver.findElement(By.linkText("Salvar Pré-Avaliação")).click();
				
				TestLinkUtils.reportResult("Visualizar Campos Modificados", null, TestLinkAPIResults.TEST_PASSED);
			} catch (Exception e) {
				TestLinkUtils.reportResult("Visualizar Campos Modificados", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
				Assert.fail(e.getMessage());
			}
				}
	@After
	public void closeBrowser() {
		driver.quit();
	}

}
