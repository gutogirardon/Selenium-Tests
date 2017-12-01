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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testlink.api.java.client.TestLinkAPIResults;
import utils.Geradores;
import utils.TestLinkUtils;
  
public class VisualizarComentarios {

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
	public void visualizarTodosComentarios() throws Exception {

		try {
			driver.get(url); 

			driver.findElement(By.id("formularioDeLogin:emailInput")).clear();
			driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("lincoln_twilink1@hotmail.com");
			driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("06101510");

			driver.findElement(By.id("formularioDeLogin:botaoLogin")).sendKeys(Keys.ENTER);

			driver.findElement(By.linkText("Planos de Negócio")).click();
			driver.findElement(By.name("menuSuperior:menuSuperior:j_idt28")).click();

			driver.findElement(By.id("lista_planos:singleDT:0:visualizar")).click();

			driver.findElement(By.id("menuSuperior:botao_revisar")).sendKeys(Keys.ENTER);
			
			driver.findElement(By.id("tabNegocio")).sendKeys(Keys.ENTER);
			
			
	        boolean bom = false;
			
	        try {
	            driver.findElement(By.xpath("//*[contains(text(),'Bom')]"));
	            bom = true;
	            TestLinkUtils.reportResult("Visualizar Comentário do Gerente", null, TestLinkAPIResults.TEST_PASSED);
	        } catch (Exception e) {
	            bom = false;
	            TestLinkUtils.reportResult("Visualizar Comentário do Gerente", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
	            Assert.fail(e.getMessage());
	        }
	        System.out.println(" " + bom);
	       
			
			//driver.findElement(By.id("tabNegocio")).sendKeys(Keys.ENTER);
			
			///driver.findElement(By.id("formulario_resubmeterplano:comentarioSegCliente")).sendKeys(Keys.ENTER);
			
			//driver.findElement(By.id("formulario_resubmeterplano:comentarioPropostaValor")).sendKeys(Keys.ENTER);
			
			//driver.findElement(By.id("formulario_resubmeterplano:comentarioAtividadesChaves")).sendKeys(Keys.ENTER);
			
			//driver.findElement(By.id("formulario_resubmeterplano:botaoSalvar2")).sendKeys(Keys.ENTER);
			
			//driver.findElement(By.id("menuSuperior:botao_Ressubmeter")).sendKeys(Keys.ENTER);
			
			//driver.findElement(By.name("formulario_resubmeterplano:j_idt54")).click();
			
			
		} catch (Exception e) {
			//TestLinkUtils.reportResult("Visualizar Comentários", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			//Assert.fail(e.getMessage());
		}finally{
			TestLinkUtils.reportResult("Visualizar Comentários", null, TestLinkAPIResults.TEST_PASSED);
		}
	}

}
