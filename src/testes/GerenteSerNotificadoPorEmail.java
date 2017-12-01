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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;
import utils.TestLinkUtils;

public class GerenteSerNotificadoPorEmail {
	
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
    public void notificarAlteracaoDoStatusDoPlanoTest() throws TestLinkAPIException {
        try {
            driver.get("url.inicial");
            WebElement campoDeEmail = driver.findElement(By.id("formularioDeLogin:emailInput"));
            campoDeEmail.sendKeys("emailValido");

            WebElement campoDeSenha = driver.findElement(By.id("formularioDeLogin:senhaInput"));
            campoDeSenha.sendKeys("senhaValida");

            campoDeSenha.sendKeys(Keys.ENTER);

            driver.findElement(By.xpath("//a[contains(.,'Planos de Negócio')]")).click();

            driver.findElement(By.name("menuSuperior:menuSuperior:j_idt26")).click();

            WebElement element = driver.findElement(By.name("formEquipe:autocomplete_input"));

            element.sendKeys("email1");

            driver.findElement(By.id("formEquipe:j_idt203")).click();

            driver.findElement(By.xpath("//*[@id=\'formEquipe:botaoSalvar1\']/span[2]")).click();

            Thread.sleep(1000);

            driver.findElement(By.xpath("//*[@id=\'modalInfoSalvarEquipe\']/div/div/div[3]/input")).click();

            WebElement campo1 = driver.findElement(By.xpath("//*[@id=\'formulario_cadastro_projeto:segmentoDeClientes\']"));
            campo1.sendKeys("info");

            WebElement campo2 = driver.findElement(By.xpath("//*[@id=\'formulario_cadastro_projeto:propostaDeValor\']"));
            campo2.sendKeys("info");

            WebElement campo3 = driver.findElement(By.xpath("//*[@id=\'formulario_cadastro_projeto:atividadesChave\']"));
            campo3.sendKeys("info");

            driver.findElement(By.xpath("//*[@id=\'tabAnaliseMercado\']")).click();

            WebElement campo4 = driver.findElement(By.xpath("//*[@id=\'formulario_cadastro_projeto:relacoComClientes\']"));
            campo4.sendKeys("info");

            WebElement campo5 = driver.findElement(By.xpath("//*[@id=\'formulario_cadastro_projeto:parceriasChaves\']"));
            campo5.sendKeys("info");

            WebElement campo6 = driver.findElement(By.xpath("//*[@id=\'formulario_cadastro_projeto:canais\']"));
            campo6.sendKeys("info");

            WebElement campo7 = driver.findElement(By.xpath("//*[@id=\'formulario_cadastro_projeto:recursosPrincipais\']"));
            campo7.sendKeys("info");

            WebElement campo8 = driver.findElement(By.xpath("//*[@id=\'formulario_cadastro_projeto:concorrentes\']"));
            campo8.sendKeys("info");

            Thread.sleep(3000);

            driver.findElement(By.xpath("//*[@id=\"tabProdutoServico\"]")).click();

            WebElement campo9 = driver.findElement(By.xpath("//*[@id=\'formulario_cadastro_projeto:tecnologiaProcessos\']"));
            campo9.sendKeys("info");

            WebElement campo10 = driver.findElement(By.xpath("//*[@id=\'formulario_cadastro_projeto:potencialInovacaoTecnologica\']"));
            campo10.sendKeys("info");

            WebElement campo11 = driver.findElement(By.xpath("//*[@id=\'formulario_cadastro_projeto:aplicacoes\']"));
            campo11.sendKeys("info");

            WebElement campo12 = driver.findElement(By.xpath("//*[@id=\'formulario_cadastro_projeto:dificuldadesEsperadas\']"));
            campo12.sendKeys("info");

            WebElement campo13 = driver.findElement(By.xpath("//*[@id=\"formulario_cadastro_projeto:interacaoEmpresaUniversidade\"]"));
            campo13.sendKeys("info");

            WebElement campo14 = driver.findElement(By.xpath("//*[@id=\'formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno\']"));
            campo14.sendKeys("info");

            WebElement campo15 = driver.findElement(By.xpath("//*[@id=\'formulario_cadastro_projeto:infraestrutura\']"));
            campo15.sendKeys("info");

            driver.findElement(By.xpath("//*[@id=\'tabGestaoPessoas\']")).click();

            WebElement campo16 = driver.findElement(By.xpath("//*[@id=\'formulario_cadastro_projeto:participacaoAcionaria\']"));
            campo16.sendKeys("info");

            WebElement campo17 = driver.findElement(By.xpath("//*[@id=\'formulario_cadastro_projeto:potencialEmprego\']"));
            campo17.sendKeys("info");

            driver.findElement(By.xpath("//*[@id=\'tabPlanoFinanceiro\']")).click();

            WebElement campo18 = driver.findElement(By.xpath("//*[@id=\'formulario_cadastro_projeto:fontesDeReceita\']"));
            campo18.sendKeys("info");

            WebElement campo19 = driver.findElement(By.xpath("//*[@id=\'formulario_cadastro_projeto:estruturaCustos\']"));
            campo19.sendKeys("info");

            WebElement campo20 = driver.findElement(By.xpath("//*[@id=\'formulario_cadastro_projeto:investimentoInicial\']"));
            campo20.sendKeys("info");

            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("botao_submeter"))).click();

            driver.findElement(By.xpath("//*[@id=\'form_enviar_projeto:j_idt221\']/span[2]")).click();

            Thread.sleep(1000);

            driver.findElement(By.xpath("//*[@id=\'modalInfoSubmeter\']/div/div/div[3]/input")).click();

//          Email

            this.driver.get("urlGmail");

            Thread.sleep(1000);

            WebElement campoEmail = driver.findElement(By.xpath("//*[@id=\'identifierId\']"));
            campoEmail.sendKeys("email.gmail");

            driver.findElement(By.xpath("//*[@id=\'identifierNext\']/content/span")).click();

            WebElement campoSenha = driver.findElement(By.xpath("//*[@id=\'password\']/div[1]/div/div[1]/input"));
            campoSenha.sendKeys("senha.gmail");

            Thread.sleep(1000);

            driver.findElement(By.xpath("//*[@id=\'passwordNext\']/content")).click();
            
            TestLinkUtils.reportResult("Verificar gerentes de cadastro", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			TestLinkUtils.reportResult("Verificar gerentes de cadastro", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());
		}

        }


    /*
    TESTA SE OS DADOS DO EMAIL CORRESPONDEM COM A ESPECIFICAÇÃO DO REQUISITO
     */
    @Test
    public void informacoesDoEmailTest() throws TestLinkAPIException{
        try {

            this.driver.get("urlGmail");

            Thread.sleep(1000);

            WebElement campoEmail = driver.findElement(By.xpath("//*[@id=\'identifierId\']"));
            campoEmail.sendKeys("email.gmail");

            driver.findElement(By.xpath("//*[@id=\'identifierNext\']/content/span")).click();

            WebElement campoSenha = driver.findElement(By.xpath("//*[@id=\'password\']/div[1]/div/div[1]/input"));
            campoSenha.sendKeys("senha.gmail");

            Thread.sleep(1000);

            driver.findElement(By.xpath("//*[@id=\'passwordNext\']/content")).click();

            Thread.sleep(1000);

            driver.findElement(By.xpath("//*[@id=\":3a\"]/span")).click();

            TestLinkUtils.reportResult("Verificar notificação", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			TestLinkUtils.reportResult("Verificar notificação", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());
		}

    }

    /*
    TESTA SE ATRAVÉS DO EMAIL É POSSÍVEL REDIRECIONAR PARA O SISTEMA DO GERENCIADOR
     */
    @Test
    public void redirecionamentoDeEmailTest() throws TestLinkAPIException{
        try {

            this.driver.get("urlGmail");

            Thread.sleep(1000);

            WebElement campoEmail = driver.findElement(By.xpath("//*[@id=\'identifierId\']"));
            campoEmail.sendKeys("email.gmail");

            driver.findElement(By.xpath("//*[@id=\'identifierNext\']/content/span")).click();

            WebElement campoSenha = driver.findElement(By.xpath("//*[@id=\'password\']/div[1]/div/div[1]/input"));
            campoSenha.sendKeys("senha.gmail");

            Thread.sleep(1000);

            driver.findElement(By.xpath("//*[@id=\'passwordNext\']/content")).click();

            Thread.sleep(1000);

            driver.findElement(By.xpath("//*[@id=\':3a\']")).click();

            Thread.sleep(2000);

            WebElement buttonAcessarSistema = driver.findElement(By.xpath("//*[@id=\":kt\"]/div[1]/div[2]/form/div/a[2]"));
            buttonAcessarSistema.click();


            TestLinkUtils.reportResult("Verificar gerentes de cadastro", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			TestLinkUtils.reportResult("Verificar gerentes de cadastro", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());
        }
    }
}