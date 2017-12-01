package testes;

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
import testlink.api.java.client.TestLinkAPIResults;
import utils.TestLinkUtils;


public class EmailValido {

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
     	   driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("julielen-ad@hotmail.com");
     	   driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("julielen");
     	   driver.findElement(By.id("formularioDeLogin:botaoLogin")).sendKeys(Keys.ENTER);

			if (driver.findElement(By.linkText("In�cio")) == null) {
				throw new Exception("PASSO 1: NAO FOI POSSIVEL E ENCONTRAR O ELEMENTO" + " --- DENTRO DA PAGINA ----");
			}

			TestLinkUtils.reportResult("Verificar email", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			TestLinkUtils.reportResult("Verificar email", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());
		}
	}
}