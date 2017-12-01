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

public class EditarPlanoNegocio {

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
	public void cadastroPlanoNegocioObrigatorio() throws Exception {

		try {
			driver.get(url);

			driver.findElement(By.id("formularioDeLogin:emailInput")).clear();
			driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("lincoln_twilink1@hotmail.com");
			driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("06101510");

			driver.findElement(By.id("formularioDeLogin:botaoLogin")).sendKeys(Keys.ENTER);

			driver.findElement(By.linkText("Planos de Negócio")).click();
			driver.findElement(By.name("menuSuperior:menuSuperior:j_idt28")).click();
			
			
			driver.findElement(By.id("lista_planos:singleDT:0:visualizar"))
			.sendKeys("Planoas de negocio teste");
			

		//driver.findElement(By.id("formEquipe:botaoSalvar1")).click();

			//WebDriverWait wait = new WebDriverWait(driver, 10);
			//wait.until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt65"))).click();
			// ate aqui salva equipe
			// aqui comeca o cadastro do plano de negocio

			driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).clear();
			driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto"))
					.sendKeys(" ");
			;

			driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).clear();
			driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes"))
					.sendKeys("Segmento de clientes");
			;

			driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).clear();
			driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).sendKeys("Proposta de valor");
			;

			driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).clear();
			driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).sendKeys("Atividades chave");
			;

			driver.findElement(By.id("formulario_cadastro_projeto:botaoSalvar2")).click();

			WebDriverWait wait = new WebDriverWait(driver, 3000);
			wait.until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt57"))).click();

			// aqui comeca aba analise de mercado
			WebDriverWait wait2 = new WebDriverWait(driver, 3000);
			wait2.until(ExpectedConditions.elementToBeClickable(By.linkText("Análise de Mercado"))).click();

			driver.findElement(By.name("formulario_cadastro_projeto:relacoComClientes"))
					.sendKeys("Relações com o cliente");
			;

			driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).clear();
			driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).sendKeys("parcerias  chave");
			;

			driver.findElement(By.id("formulario_cadastro_projeto:canais")).clear();
			driver.findElement(By.id("formulario_cadastro_projeto:canais")).sendKeys("canais");
			;

			driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).clear();
			driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).sendKeys("recursos principais");
			;

			driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).clear();
			driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).sendKeys("Concorrentes");
			;

			driver.findElement(By.id("formulario_cadastro_projeto:botaoSalvar3")).click();

			wait2.until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt57")))
					.click();

			// aqui comeca produto ou servico

			wait2.until(ExpectedConditions.elementToBeClickable(By.linkText("Produto ou Serviço"))).click();

			driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos"))
					.sendKeys("tecnologia e processos");
			;

			driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).clear();
			driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica"))
					.sendKeys("potencial de inovacao");
			;

			driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).clear();
			driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).sendKeys("aplicacoes");
			;

			driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).clear();
			driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas"))
					.sendKeys("dificuldades esperadas");
			;

			driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).clear();
			driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade"))
					.sendKeys("interacao universidade e empresa");
			;

			driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).clear();
			driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno"))
					.sendKeys("interacao empresa comunidade governo");
			;

			driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).clear();
			driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura"))
					.sendKeys("infraestrutura necessaria para o desenvolvimento");
			;

			driver.findElement(By.id("formulario_cadastro_projeto:botaoSalvar4")).click();

			wait2.until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt57")))
					.click();

			// AQUI ACABA A ABA PRODUTO OU SERVIÇO

			// aqui comeca GESTAO DE PESSOAS

			wait2.until(ExpectedConditions.elementToBeClickable(By.linkText("Gestão de Pessoas"))).click();

			driver.findElement(By.id("formulario_cadastro_projeto:participacaoAcionaria"))
					.sendKeys("Part. usuários");
			;

			driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).clear();
			driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego"))
					.sendKeys("Geração de Renda e emprego");
			;

			driver.findElement(By.id("formulario_cadastro_projeto:botaoSalvar5")).click();

			wait2.until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt57")))
					.click();

			// AQUI ACABA A ABA GESTAO DE PESSOAS

			// aqui comeca plano financeiro

			wait2.until(ExpectedConditions.elementToBeClickable(By.linkText("Plano Financeiro"))).click();

			driver.findElement(By.id("formulario_cadastro_projeto:fontesDeReceita"))
					.sendKeys("fontes de receita");
			;

			driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).clear();
			driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos"))
					.sendKeys("estrutura de custos");
			;
			
			driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).clear();
			driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial"))
					.sendKeys("investimento inicial");
			;
			

			driver.findElement(By.id("formulario_cadastro_projeto:botaoSalvar6")).click();

			wait2.until(ExpectedConditions.elementToBeClickable(By.name("formulario_cadastro_projeto:j_idt57")))
					.click();
			
			

			// AQUI ACABA A ABA GESTAO DE PESSOAS

			///TestLinkUtils.reportResult("Cadastrar Plano de Negócio", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
		//	TestLinkUtils.reportResult("Cadastrar Plano de Negócio", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());
		}
	}

}