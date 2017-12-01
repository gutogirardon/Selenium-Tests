package testes;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.sun.org.apache.bcel.internal.generic.Select;

import testlink.api.java.client.TestLinkAPIResults;
import utils.Geradores;
import utils.TestLinkUtils;

public class Testando {

	public static WebDriver driver;
	public static String url = "http://ggirardon.com:8080/GerenciadorPampatec/";

	@Before
	public void openBrowser() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().logs();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void testEsMGP59() throws Exception {
		try {
			// Ir à URL do SITE UNDER TESTING
			driver.get(url);
			driver.findElement(By.id("formularioDeLogin:emailInput")).clear();
			driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("shairibeirols@gmail.com");
			driver.findElement(By.id("formularioDeLogin:senhaInput")).clear();
			driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123");
			Thread.sleep(2000);
			driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Planos de negócio")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Avaliar Planos de Negócio")).click();
			Thread.sleep(2000);
			new Select(driver.findElement(By.name("locovelho:tabelaDeNegocios:j_idt42")))
					.selectByVisibleText("Sendo Avaliado");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("option[value=\"Sendo Avaliado\"]")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Início")).click();

			WebElement Início = driver.findElement(By.linkText("Início"));
			Assert.assertTrue(Início.isDisplayed());

			TestLinkUtils.reportResult("Filtrar tabelas do PN", null, TestLinkAPIResults.TEST_PASSED);
			TestLinkUtils.reportResult("Visualizar os planos de negócio filtrando suas tabelas.", null,
					TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			TestLinkUtils.reportResult("Filtrar tabelas do PN", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			TestLinkUtils.reportResult("Visualizar os planos de negócio filtrando suas tabelas.", e.getMessage(),
					TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());

		}

	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

}