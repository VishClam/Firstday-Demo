package org.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelTask {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		WebElement dDn = driver.findElement(By.id("Skills"));
		File file = new File("C:\\Users\\Vishnu\\eclipse-workspace\\FirstDay\\Excel\\Demo1.xlsx");
		Workbook workbook = new XSSFWorkbook();
		FileOutputStream stream = new FileOutputStream(file);
		Sheet sheet = workbook.createSheet("Vishnu");

		Select select = new Select(dDn);
		String text = dDn.getText();
		System.out.println(text);
		List<WebElement> options = select.getOptions();
		System.out.println(options.size());

		for (int i = 0; i < options.size(); i++) {

			WebElement data = options.get(i);
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(data.getText());

		}

		workbook.write(stream);

	}

}
