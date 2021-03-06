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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import testlink.api.java.client.TestLinkAPIResults;
import utils.TestLinkUtils;

public class VisualizarPlanos {
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
				
				driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/a")).click();
				driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/ul/li/a")).click();
				
				Select dropdown = new Select(driver.findElement(By.name("locovelho:tabelaDeNegocios:j_idt42")));
				driver.findElement(By.name("locovelho:tabelaDeNegocios:j_idt42")).click();
				dropdown.selectByVisibleText("Ressubmetido");
				
				TestLinkUtils.reportResult("Visualizar Planos Ressubmetidos", null, TestLinkAPIResults.TEST_PASSED);
			} catch (Exception e) {
 				TestLinkUtils.reportResult("Visualizar Planos Ressubmetidos", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
				Assert.fail(e.getMessage());
			}
		}

	}		