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

public class ClassificarPlanoRealizarAjustes {
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
				 
				//Planos de negócio
				driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/a")).click();
				//Avaliar planos 
				driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/ul/li/a")).click();
				
				Select dropdown = new Select(driver.findElement(By.name("locovelho:tabelaDeNegocios:j_idt42")));
				driver.findElement(By.name("locovelho:tabelaDeNegocios:j_idt42")).click();
				dropdown.selectByVisibleText("Submetido");
				
				driver.findElement(By.xpath("//*[@id=\"locovelho:tabelaDeNegocios:0:avaliarPlano\"]/span[2]")).click();
				//Abas
				//Negocio
				driver.findElement(By.xpath("//*[@id=\"tabNegocio\"]")).click();
				
				//AnaliseMercado
				driver.findElement(By.xpath("//*[@id=\"tabAnaliseMercado\"]")).click();
						
				//Produto Serviço
				driver.findElement(By.xpath("//*[@id=\"tabProdutoServico\"]")).click();
				
				//Gestao Pessoas
				driver.findElement(By.xpath("//*[@id=\"tabGestaoPessoas\"]")).click();
					
				//Planofinanceiro
				driver.findElement(By.xpath("//*[@id=\"tabPlanoFinanceiro\"]")).click();
		
				//Avaliar
				driver.findElement(By.xpath("//*[@id=\"formulario_comentarpreavalizar\"]/div[3]/div/div[1]/ul/li[7]")).click();
				//Realizar ajustes
				driver.findElement(By.xpath("//*[@id=\"formulario_comentarpreavalizar:avaliacao\"]/tbody/tr[2]/td[2]/label")).click();
	
				dropdown.selectByVisibleText("Salvar Pré-Avaliação");
				
				TestLinkUtils.reportResult("Classificar Plano - Realizar Ajustes", null, TestLinkAPIResults.TEST_PASSED);
			} catch (Exception e) {
 				TestLinkUtils.reportResult("Classificar Plano - Realizar Ajustes", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
				Assert.fail(e.getMessage());
			}
		}

	}