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
import utils.Geradores;
import utils.TestLinkUtils;

public class CadastroUsuario {
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
	public void cadastroObrigatorios() throws Exception {
		
		try {
			driver.get(url);
			
	     	driver.findElement(By.id("formularioDeCadastro:botaoContinuaCadastro")).click();
			driver.findElement(By.id("formularioCadastro:nome")).sendKeys(Geradores.nomeAleatorio(50));
			driver.findElement(By.id("formularioCadastro:cpf")).sendKeys(Geradores.geraCPF());
			driver.findElement(By.id("formularioCadastro:telefone")).sendKeys("55959595955");
			driver.findElement(By.id("formularioCadastro:rua")).sendKeys("Rua tal");
			driver.findElement(By.id("formularioCadastro:numero")).sendKeys("154");
			driver.findElement(By.id("formularioCadastro:bairro")).sendKeys("Ibirapuita");
			driver.findElement(By.id("formularioCadastro:email")).sendKeys(Geradores.nomeAleatorio(10)+"@gmail.com");
			driver.findElement(By.id("formularioCadastro:senha")).sendKeys("69564654@");
			driver.findElement(By.id("formularioCadastro:senhaConfig")).sendKeys("69564654@");
			driver.findElement(By.id("formularioCadastro:botaoEnviar")).click();			

			
			if (driver.findElement(By.id("formConfirmaEmail:botaoAtualizarEmail")) == null) {
				throw new Exception("PASSO 1: N�O FOI POSS�VEL E ENCONTRAR O ELEMENTO" + " --- DENTRO DA P�GINA ----");
			}

			TestLinkUtils.reportResult("Realizar Cadastro", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			TestLinkUtils.reportResult("Realizar Cadastro", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void cadastroNomeExcedente() throws Exception {
		
		try {
			driver.get(url);

			driver.findElement(By.id("formularioDeCadastro:botaoContinuaCadastro")).click();
			driver.findElement(By.id("formularioCadastro:nome")).sendKeys(Geradores.nomeAleatorio(105));
			driver.findElement(By.id("formularioCadastro:cpf")).sendKeys(Geradores.geraCPF());
			driver.findElement(By.id("formularioCadastro:telefone")).sendKeys("55959595955");
			driver.findElement(By.id("formularioCadastro:rua")).sendKeys("Rua tal");
			driver.findElement(By.id("formularioCadastro:numero")).sendKeys("154");
			driver.findElement(By.id("formularioCadastro:bairro")).sendKeys("Ibirapuita");
			driver.findElement(By.id("formularioCadastro:email")).sendKeys(Geradores.nomeAleatorio(10)+"@gmail.com");
			driver.findElement(By.id("formularioCadastro:senha")).sendKeys("69564654@");
			driver.findElement(By.id("formularioCadastro:senhaConfig")).sendKeys("69564654@");
			driver.findElement(By.id("formularioCadastro:botaoEnviar")).click();			

			
			if (driver.findElement(By.id("formConfirmaEmail:botaoAtualizarEmail")) == null) {
				throw new Exception("PASSO 1: N�O FOI POSS�VEL E ENCONTRAR O ELEMENTO" + " --- DENTRO DA P�GINA ----");
			}

			TestLinkUtils.reportResult("Realizar Cadastro Caracter Excedentes", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			TestLinkUtils.reportResult("Realizar Cadastro Caracter Excedentes", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());
		}
	}

}
