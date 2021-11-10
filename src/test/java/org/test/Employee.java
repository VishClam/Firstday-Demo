package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Employee {

	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\Vishnu\\eclipse-workspace\\FirstDay\\Excel\\Demo.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);

		Sheet sheet = workbook.getSheet("Details");
		int countRow = sheet.getPhysicalNumberOfRows();
		System.out.println("Total Rows:" + countRow);

		for (int i = 0; i < countRow; i++) {
			Row row = sheet.getRow(i);
			System.out.println("*******************************");
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {

				Cell cell = row.getCell(j);
				int type = cell.getCellType();

				if (type == 1) {
					String data = cell.getStringCellValue();
					System.out.println(data);
				}

				if (type == 0) {

					if (DateUtil.isCellDateFormatted(cell)) {

						String data = new SimpleDateFormat("dd-MMM-yy").format(cell.getDateCellValue());
						System.out.println(data);

					} else {
						String string = String.valueOf((long) cell.getNumericCellValue());
						System.out.println(string);
					}
				}
			}

		}

	}

}
