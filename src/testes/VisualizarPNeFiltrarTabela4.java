/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

/**
 *
 * @author shairibeirols
 */

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static testes.VisualizarPNeFiltrarTabela.driver;
import static testes.VisualizarPNeFiltrarTabela.url;
import testlink.api.java.client.TestLinkAPIResults;
import utils.TestLinkUtils;

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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VisualizarPNeFiltrarTabela4 {

	public static WebDriver driver;

	public static String url = "http://ggirardon.com:8080/GerenciadorPampatec/";

	@Before
	public void openBrowser() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void testEsMGP59() throws Exception {

		try {
			  driver.get(url);
              
              driver.findElement(By.id("formularioDeLogin:emailInput")).clear();
  			driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("shairibeirols@gmail.com");
  			driver.findElement(By.id("formularioDeLogin:senhaInput")).clear();
  			driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123");
              Thread.sleep(2000);
              driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
              Thread.sleep(2000);
              driver.findElement(By.linkText("Planos de neg�cio")).click();
              Thread.sleep(2000);
              driver.findElement(By.linkText("Avaliar Planos de Neg�cio")).click();
              Thread.sleep(2000);
              new Select(driver.findElement(By.name("locovelho:tabelaDeNegocios:j_idt42"))).selectByVisibleText("Em Pr�-Avalia��o");
             Thread.sleep(2000);
              driver.findElement(By.cssSelector("option[value=\"Em Pr�-Avalia��o\"]")).click();
              Thread.sleep(2000);
              driver.findElement(By.linkText("In�cio")).click();
		    
          

            WebElement In�cio = driver.findElement(By.linkText("In�cio"));
            Assert.assertTrue(In�cio.isDisplayed());

            {
            }
    		TestLinkUtils.reportResult("Filtrar na tabela de PN", null,
    				TestLinkAPIResults.TEST_PASSED);
    	} catch (Exception e) {
    		TestLinkUtils.reportResult("Filtrar na tabela de PN", e.getMessage(),
    				TestLinkAPIResults.TEST_FAILED);
    		Assert.fail(e.getMessage());
    	}
    	
    	}

    	
    }

            