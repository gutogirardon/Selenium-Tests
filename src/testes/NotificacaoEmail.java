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

public class NotificacaoEmail {

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
	public void testesetenta() throws Exception {
		try {
			
			driver.get(url);
            driver.findElement(By.id("formularioDeLogin:emailInput")).clear();
            driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("gerentedefault1@ideiah.com");
            driver.findElement(By.id("formularioDeLogin:senhaInput")).clear();
            driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("gerente123");
            Thread.sleep(2000);
            
            WebElement Início = driver.findElement(By.linkText("Início"));
            Assert.assertTrue(Início.isDisplayed());
             
			TestLinkUtils.reportResult("Verificar notificação", null, TestLinkAPIResults.TEST_FAILED);	
		
		}	catch (Exception exception) {
			
		}
	
	}
	
	
	
	
	
}