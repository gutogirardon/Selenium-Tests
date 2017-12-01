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

public class VisualizarPNeFiltrarTabela3 {

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
			driver.findElement(By.linkText("Planos de negócio")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Avaliar Planos de Negócio")).click();
			Thread.sleep(2000);
			new Select(driver.findElement(By.name("locovelho:tabelaDeNegocios:j_idt42")))
					.selectByVisibleText("Ressubmetido");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("option[value=\"Ressubmetido\"]")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Início")).click();

			WebElement Início = driver.findElement(By.linkText("Início"));
			Assert.assertTrue(Início.isDisplayed());

		} catch (Exception e) {

			Assert.fail(e.getMessage());
		}
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

}
