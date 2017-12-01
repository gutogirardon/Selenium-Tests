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

public class VisualizarPlanoDeNegocio {

	public static WebDriver driver;
	public static String url = "http://ggirardon.com:8080/GerenciadorPampatec/";
	
	public void openBrowser() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void VisualizarPlano() throws Exception {
	try {

       driver.get(url);
        WebElement campoDeEmail = driver.findElement(By.id("formularioDeLogin:emailInput"));
        campoDeEmail.sendKeys("julielen-ad@hotmail.com");

        WebElement campoDeSenha = driver.findElement(By.id("formularioDeLogin:senhaInput"));
        campoDeSenha.sendKeys("julielen");

        campoDeSenha.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();

        Thread.sleep(1000);

        driver.findElement(By.id("lista_planos:singleDT:1:visualizar")).click();

        driver.findElement(By.xpath("//*[@id=\"formulario_cadastro_projeto:botaoSalvar2\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"modalInfoSalvar\"]/div/div/div[3]/input")).submit();


        
        TestLinkUtils.reportResult("Visualizar Plano de Negocio", null, TestLinkAPIResults.TEST_PASSED);
  	} catch (Exception e) {
  		TestLinkUtils.reportResult("Visualizar Plano de Negocio", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
  		Assert.fail(e.getMessage());
  	}
}

	@After
	public void tearDown() throws Exception {
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}

}
