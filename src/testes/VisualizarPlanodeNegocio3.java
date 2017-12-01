package testes;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VisualizarPlanodeNegocio3 {
	
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
 	public void testeVisualizarPlano() throws Exception {
		try {
			driver.get(url);
            WebElement campoDeEmail = driver.findElement(By.id("formularioDeLogin:emailInput"));
            campoDeEmail.sendKeys("shairibeirols@gmail.com");

            WebElement campoDeSenha = driver.findElement(By.id("formularioDeLogin:senhaInput"));
            campoDeSenha.sendKeys("99128591");

            campoDeSenha.sendKeys(Keys.ENTER);

            driver.findElement(By.xpath("//a[contains(.,'Planos de Negócio')]")).click();

            driver.findElement(By.name("menuSuperior:menuSuperior:j_idt28")).click();
            
            driver.findElement(By.id("lista_planos:singleDT:0:visualizar")).click();

		}
		catch(Exception exception) {}

	}
	
	@Test
	public void testeVisualizarPlanoCompleto() throws Exception {
		try {
			driver.get(url);
            WebElement campoDeEmail = driver.findElement(By.id("formularioDeLogin:emailInput"));
            campoDeEmail.sendKeys("shairibeirols@gmail.com");

            WebElement campoDeSenha = driver.findElement(By.id("formularioDeLogin:senhaInput"));
            campoDeSenha.sendKeys("99128591");

            campoDeSenha.sendKeys(Keys.ENTER);

            driver.findElement(By.xpath("//a[contains(.,'Planos de Negócio')]")).click();

            driver.findElement(By.name("menuSuperior:menuSuperior:j_idt28")).click();
            
            driver.findElement(By.id("lista_planos:singleDT:1:visualizar")).click();

		}
		catch(Exception exception) {}

	}

	@Test
 	public void testeVisualizarPlanoIncompleto() throws Exception {
		try {
			driver.get(this.url);
            WebElement campoDeEmail = driver.findElement(By.id("formularioDeLogin:emailInput"));
            campoDeEmail.sendKeys("shairibeirols@gmail.com");

            WebElement campoDeSenha = driver.findElement(By.id("formularioDeLogin:senhaInput"));
            campoDeSenha.sendKeys("99128591");

            campoDeSenha.sendKeys(Keys.ENTER);

            driver.findElement(By.xpath("//a[contains(.,'Planos de Negócio')]")).click();

            driver.findElement(By.name("menuSuperior:menuSuperior:j_idt28")).click();
            
            driver.findElement(By.id("lista_planos:singleDT:0:visualizar")).click();

		}
		catch(Exception exception) {}

	}
	
}
	


