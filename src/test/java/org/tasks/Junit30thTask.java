package org.tasks;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Junit30thTask {

	static WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();

	}

	@AfterClass
	public static void afterClass() {
		driver.quit();
	}

	@Before
	public void beforeTest() {
		Date date = new Date();
		System.out.println(date);
	}

	@After
	public void afterTest() {
		Date date = new Date();
		System.out.println(date);
	}

	@Test
	public void test() {
		String url = driver.getCurrentUrl();
		boolean contains = url.contains("hotel");
		Assert.assertTrue("Website", contains);

		WebElement txtUser = driver.findElement(By.id("username"));
		txtUser.sendKeys("VishnuClam");
		String user = txtUser.getAttribute("value");
		Assert.assertEquals("User Name", "VishnuClam", user);
		WebElement txtPass = driver.findElement(By.id("password"));
		txtPass.sendKeys("Vishnu.8");
		String pass = txtPass.getAttribute("value");
		Assert.assertEquals("Password", "Vishnu.8", pass);

		WebElement btnLogin = driver.findElement(By.id("login"));
		btnLogin.click();
	}

}
