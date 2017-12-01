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

public class avaliarPlanoDisponivelTest {

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
public void avaliarPlanoDisponivelTest() {
    try {
        this.driver.get(PropertyReader.read("url.inicial"));
        WebElement campoDeEmail = this.driver.findElement(By.id("formularioDeLogin:emailInput"));
        campoDeEmail.sendKeys(PropertyReader.read("emailElder"));

        Thread.sleep(1000);

        WebElement campoDeSenha = this.driver.findElement(By.id("formularioDeLogin:senhaInput"));
        campoDeSenha.sendKeys(PropertyReader.read("senhaElder"));

        campoDeSenha.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//a[contains(.,'Planos de negócio')]")).click();

        Thread.sleep(1000);
        
        

        driver.findElement(By.xpath("//*[@id=\'j_idt14\']/nav/div/div[2]/ul/li[2]/ul/li/a")).click();


        driver.findElement(By.xpath("//*[@id=\'locovelho:tabelaDeNegocios:5:avaliarPlano\']/span[2]")).click();

        TestLinkIntegration.updateResults("Avaliar Plano de Negócio disponível", null, TestLinkAPIResults.TEST_PASSED);

    } catch (Exception exception) {

    }
}

}
