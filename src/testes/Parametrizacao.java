package testes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
import utils.TestLinkUtils;

public class Parametrizacao {
	public static WebDriver driver;
	
	@Test
	public void test() throws BiffException, IOException, InterruptedException {
		// Open MyDataSheet.xls file from given location.
		FileInputStream fileinput = new FileInputStream("D:\\MyDataSheet.xls");
		// Access first data sheet. getSheet(0) describes first sheet.
		Workbook wbk = Workbook.getWorkbook(fileinput);
		Sheet sheet = wbk.getSheet(0);

		// Read data from the first data sheet of xls file and store it in
		// array.
		String TestData[][] = new String[sheet.getRows()][sheet.getColumns()];

		// To enable Last Name text box.
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		String toenable = "document.getElementsByName('lname')[0].removeAttribute('disabled');";
		javascript.executeScript(toenable);

		// Type data in first name and last name text box from array.
		for (int i = 0; i < sheet.getRows(); i++) {
			for (int j = 0; j < sheet.getColumns(); j++) {
				TestData[i][j] = sheet.getCell(j, i).getContents();
				if (j % 2 == 0) {
					driver.findElement(By.xpath("//input[@name='fname']")).sendKeys(TestData[i][j]);
				} else {
					driver.findElement(By.xpath("//input[@name='lname']")).sendKeys(TestData[i][j]);
				}
			}
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='fname']")).clear();
			driver.findElement(By.xpath("//input[@name='lname']")).clear();
		}
		Thread.sleep(1000);

	}
}
