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

public class SingleTest {
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
	public void cadastroBairroExcedente() throws Exception {

		try {
			driver.get(url);

			driver.findElement(By.id("formularioDeCadastro:botaoContinuaCadastro")).click();
			driver.findElement(By.id("formularioCadastro:nome")).sendKeys(Geradores.nomeAleatorio(20));
			driver.findElement(By.id("formularioCadastro:cpf")).sendKeys(Geradores.geraCPF());
			driver.findElement(By.id("formularioCadastro:telefone")).sendKeys("55959595955");
			driver.findElement(By.id("formularioCadastro:rua")).sendKeys("Rua tal");
			driver.findElement(By.id("formularioCadastro:numero")).sendKeys("00112233445566");
			driver.findElement(By.id("formularioCadastro:bairro")).sendKeys(Geradores.nomeAleatorio(105));
			driver.findElement(By.id("formularioCadastro:j_idt33")).sendKeys(Geradores.nomeAleatorio(5));
			driver.findElement(By.id("formularioCadastro:email")).sendKeys(Geradores.nomeAleatorio(10) + "@gmail.com");
			driver.findElement(By.id("formularioCadastro:senha")).sendKeys("6956465@");
			driver.findElement(By.id("formularioCadastro:senhaConfig")).sendKeys("6956465@");
			driver.findElement(By.id("formularioCadastro:botaoEnviar")).click();

			if (driver.findElement(By.id("formConfirmaEmail:botaoAtualizarEmail")) == null) {
				throw new Exception(
						"PASSO 1: N�O FOI POSS�VEL E ENCONTRAR O ELEMENTO" + " --- DENTRO DA P�GINA ----");
			}

			TestLinkUtils.reportResult("Cadastro - Bairro com caracteres excedentes", null,
					TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			TestLinkUtils.reportResult("Cadastro - Bairro com caracteres excedentes", e.getMessage(),
					TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());
		}
	}
}