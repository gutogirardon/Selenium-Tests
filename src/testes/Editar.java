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
import static org.junit.Assert.*;


public class Editar {

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
 	public void EditarPlano() throws Exception {
		try {
			driver.get(url);
            WebElement campoDeEmail = driver.findElement(By.id("formularioDeLogin:emailInput"));
            campoDeEmail.sendKeys("julielen-ad@hotmail.com");

            WebElement campoDeSenha = driver.findElement(By.id("formularioDeLogin:senhaInput"));
            campoDeSenha.sendKeys("julielen");

            campoDeSenha.sendKeys(Keys.ENTER);

            driver.findElement(By.xpath("//a[contains(.,'Planos de Negocio')]")).click();

            driver.findElement(By.name("menuSuperior:menuSuperior:j_idt28")).click();
            
            driver.findElement(By.id("lista_planos:singleDT:0:visualizar")).click();

            WebElement editarPlano = driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto"));
            editarPlano.sendKeys("RPRP Iv4");
            
            driver.findElement(By.xpath("//*[@id=\"formulario_cadastro_projeto:botaoSalvar2\"]")).click();

            driver.findElement(By.xpath("//*[@id=\"modalInfoSalvar\"]/div/div/div[3]/input")).submit();
		}
	
		catch(Exception exception) {}
	
	}	

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
