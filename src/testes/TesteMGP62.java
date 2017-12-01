package testes;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.List;
import java.util.NoSuchElementException;
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
import org.openqa.selenium.support.ui.WebDriverWait;

import testlink.api.java.client.TestLinkAPIResults;
import utils.Geradores;
import utils.TestLinkUtils;

public class TesteMGP62 {

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
public void testEemail() throws Exception {
    try {
        driver.get("shairibeirols" + "/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=AddSession");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("div.LXRPh")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("identifierId")).click();
        driver.findElement(By.id("identifierId")).clear();
        driver.findElement(By.id("identifierId")).sendKeys("agl@gmail.com");
        driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/form/div[2]/div[1]/div/div[1]/div/div[1]/input")).sendKeys("1654g8354a");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/form/div[iv[1]/div/content/span")).click();
        Thread.sleep(2000);
     assertEquals("Gerenciador Pampatec", driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div[1]/div/div/div[6]/div/div[1]/div[2]/div/table/tbody/tr[1]/td[4]/div[2]/span")).getText());
        Thread.sleep(3000);
        TestLinkUtils.reportResult("Verificar se o empreendedor poderá se direcionar ao sistema automaticamente", null,
				TestLinkAPIResults.TEST_PASSED);
	} catch (Exception e) {
		TestLinkUtils.reportResult("Verificar se o empreendedor poderá se direcionar ao sistema automaticamente", e.getMessage(),
				TestLinkAPIResults.TEST_FAILED);
		Assert.fail(e.getMessage());
		
	}
}


@Test
public void testEemailCorrespondente1() throws Exception {
    try {
        driver.get("shairibeirols" + "/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=AddSession");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("div.LXRPh")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("identifierId")).click();
        driver.findElement(By.id("identifierId")).clear();
        driver.findElement(By.id("identifierId")).sendKeys("agl@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/form/div[2]/div/div[3]/div[1]/div[1]/div/div[1]/div/div[1]/input")).sendKeys("1654g8354a");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/form/div[2]/div/div[3]/div[2]/div[1]/div/content/span")).click();
        Thread.sleep(2000);
        assertEquals("Gerenciador Pampatec", driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[6]/div/div[1]/div[2]/div/table/tbody/tr[1]/td[4]/div[2]/span")).getText());
        assertEquals("Acessar o sistema", driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div/table/tr/td[1]/div[2]/div[2]/div/div[3]/div/div/div/div/div/div[1]/div[2]/div[7]/div/div[1]/div[2]/form/div/a[2]")).getText());
        Thread.sleep(3000);
        
        TestLinkUtils.reportResult("Verificar gerentes de cadastro", null,
				TestLinkAPIResults.TEST_PASSED);
	} catch (Exception e) {
		TestLinkUtils.reportResult("Verificar gerentes de cadastro", e.getMessage(),
				TestLinkAPIResults.TEST_FAILED);
		Assert.fail(e.getMessage());
		
	}
}
}