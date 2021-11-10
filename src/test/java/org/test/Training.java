package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Training {
	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\Vishnu\\eclipse-workspace\\FirstDay\\Excel\\Demo.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("Details");

		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

			Row row = sheet.getRow(i);

			System.out.println("***********");
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				int type = cell.getCellType();
				if (type == 1) {
					String data = cell.getStringCellValue();
					System.out.println(data);

				}
				if (type == 0) {
					if (DateUtil.isCellDateFormatted(cell)) {
						java.util.Date date = cell.getDateCellValue();
						SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yy");
						String format = dateformat.format(date);
						System.out.println(format);
					} else {
						double d = cell.getNumericCellValue();
						long l = (long) d;
						String string = String.valueOf(l);
						System.out.println(string);
					}
				}

			}
		}

	}

}
