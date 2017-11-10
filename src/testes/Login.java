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

public class Login {

	public static WebDriver driver;
	public static String url = "http://teste.com:8080/GerenciadorPampatec/";

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
			driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("teste@gmail.com");
			driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("teste");
			driver.findElement(By.id("formularioDeLogin:botaoLogin")).sendKeys(Keys.ENTER);

			if (driver.findElement(By.linkText("In�cio")) == null) {
				throw new Exception("PASSO 1: N�O FOI POSS�VEL E ENCONTRAR O ELEMENTO" + " --- DENTRO DA P�GINA ----");
			}

			//TestLinkUtils.reportResult("Realizar Login", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			//TestLinkUtils.reportResult("Realizar Login", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testeLoginFake() throws Exception {
		try {
			driver.get(url);

			driver.findElement(By.id("formularioDeLogin:emailInput")).clear();
			driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("teste@gmail.com");
			driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123");
			driver.findElement(By.id("formularioDeLogin:botaoLogin")).sendKeys(Keys.ENTER);

			if (driver.findElement(By.linkText("In�cio")) == null) {
				throw new Exception("PASSO 1: N�O FOI POSS�VEL E ENCONTRAR O ELEMENTO" + " --- DENTRO DA P�GINA ----");
			}

			//TestLinkUtils.reportResult("Realizar Login", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			//TestLinkUtils.reportResult("Realizar Login", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());
		}
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

}