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

	public class FuncionalidadesDoSistema53 {
		
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
		public void CadastrarPlano() throws Exception {
		try {

           driver.get(url);
            WebElement campoDeEmail = driver.findElement(By.id("formularioDeLogin:emailInput"));
            campoDeEmail.sendKeys("shairibeirols@gmail.com");

            WebElement campoDeSenha = driver.findElement(By.id("formularioDeLogin:senhaInput"));
            campoDeSenha.sendKeys("99128591");

            campoDeSenha.sendKeys(Keys.ENTER);

            driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();

            Thread.sleep(1000);

            driver.findElement(By.id("lista_planos:singleDT:1:visualizar")).click();

            driver.findElement(By.xpath("//*[@id=\"formulario_cadastro_projeto:botaoSalvar2\"]")).click();

            driver.findElement(By.xpath("//*[@id=\"modalInfoSalvar\"]/div/div/div[3]/input")).submit();


            
        } catch (Exception exception) {

        
        }
	}
		
		@Test
	 	public void EditarPlano() throws Exception {
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

	            WebElement editarPlano = driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto"));
	            editarPlano.sendKeys("RPRP Iv4");
	            
	            driver.findElement(By.xpath("//*[@id=\"formulario_cadastro_projeto:botaoSalvar2\"]")).click();

	            driver.findElement(By.xpath("//*[@id=\"modalInfoSalvar\"]/div/div/div[3]/input")).submit();
			}
		
			catch(Exception exception) {}
		
		
		
		}
		
		
		@Test
	    public void LogarPlano() {
	        try {
	            driver.get(url);
	            WebElement campoDeEmail = driver.findElement(By.id("formularioDeLogin:emailInput"));
	            campoDeEmail.sendKeys("shairibeirols@gmail.com");

	            WebElement campoDeSenha = driver.findElement(By.id("formularioDeLogin:senhaInput"));
	            campoDeSenha.sendKeys("99128591");

	            campoDeSenha.sendKeys(Keys.ENTER);

	            
	        } catch (Exception exception) {

	        }
	    }
		
		@Test
	 	public void EditarDadosUsuario() throws Exception {
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

	            WebElement editarPlano = driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto"));
	            editarPlano.sendKeys("RPRP Iv4");
	            
	            driver.findElement(By.xpath("//*[@id=\"formulario_cadastro_projeto:botaoSalvar2\"]")).click();

	            driver.findElement(By.xpath("//*[@id=\"modalInfoSalvar\"]/div/div/div[3]/input")).submit();
			}
		
			catch(Exception exception) {}
		
		
		
	}
		
		
		@Test
	 	public void SubmeterPlanoNegocio() throws Exception {
			try {
				driver.get(url);
	            WebElement campoDeEmail = driver.findElement(By.id("formularioDeLogin:emailInput"));
	            campoDeEmail.sendKeys("shairibeirols@gmail.com");

	            WebElement campoDeSenha = driver.findElement(By.id("formularioDeLogin:senhaInput"));
	            campoDeSenha.sendKeys("99128591");

	            campoDeSenha.sendKeys(Keys.ENTER);

	            driver.findElement(By.xpath("//a[contains(.,'Planos de Negócio')]")).click();

	            driver.findElement(By.name("menuSuperior:menuSuperior:j_idt28")).click();
	            
	            driver.findElement(By.id("name=\"menuSuperior:menuSuperior:j_idt26\"")).click();

	            
	           	            driver.findElement(By.xpath("//*[@id=\"modalInfoSalvar\"]/div/div/div[3]/input")).submit();
			}
		
			catch(Exception exception) {}
		
		
		
	}
	}
	
