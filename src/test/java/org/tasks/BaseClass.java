package org.tasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	static WebDriver driver;

		public String getData(int rowIndex, int cellIndex) throws IOException {

		String data = null;
		File file = new File("C:\\Users\\Vishnu\\eclipse-workspace\\FirstDay\\Excel\\Demo.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("Register");
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		int type = cell.getCellType();

		if (type == 1) {
			data = cell.getStringCellValue();
		}
		if (type == 0) {

			if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
				data = dateFormat.format(date);

			} else {
				double d = cell.getNumericCellValue();
				long l = (long) d;
				String.valueOf(l);

			}
		}
		return data;

	}

	public static String writeData(String data, int rowIndex, int cellIndex) throws IOException {

		File file = new File("C:\\Users\\Vishnu\\eclipse-workspace\\FirstDay\\Excel\\Demo.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("Register");
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.createCell(cellIndex);

		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
		return data;
	}

	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void enterUrl(String data) {
		driver.get(data);
	}

	public static void fullWindow() {
		driver.manage().window().maximize();
	}

	public WebElement findElementByXpath(String data) {
		return driver.findElement(By.xpath(data));
	}

	public static WebElement findElementById(String data) {
		return driver.findElement(By.id(data));
	}

	public void enterText(WebElement element, String data) {
		element.sendKeys(data);

	}

	public void click(WebElement element) {
		element.click();

	}

	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}

	public void selectByText(WebElement element, String data) {
		Select select = new Select(element);
		select.selectByVisibleText(data);

	}

	public static void waitUntil() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}
