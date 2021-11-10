package org.tasks;

import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class JunitTask extends BaseClass {

	@BeforeClass
	public static void beforeClass() throws Exception {

		browserLaunch();
		enterUrl("https://adactinhotelapp.com/SearchHotel.php");
		fullWindow();
	}

	@Before
	public void beforeMethod() {
		Date date = new Date();
		System.out.println(date);

	}

	@After
	public void aftermethod() {
		Date date = new Date();
		System.out.println(date);
	}

	@Test
	public void executeStage() throws IOException {

		WebElement txtUser = findElementById("username");
		String user = getData(1, 0);
		enterText(txtUser, user);

		WebElement txtPass = findElementById("password");
		String pass = getData(1, 1);
		enterText(txtPass, pass);

		WebElement btnLogin = findElementById("login");
		click(btnLogin);
		
		WebElement location = findElementById("location");
		String city = getData(1, 2);
		selectByText(location, city);

		WebElement hotels = findElementById("hotels");
		String hotel = getData(1, 3);
		selectByText(hotels, hotel);

		WebElement roomType = findElementById("room_type");
		String room = getData(1, 4);
		selectByText(roomType, room);

		WebElement noOfRooms = findElementById("room_nos");
		String roomCount = getData(1, 5);
		selectByText(noOfRooms, roomCount);

		WebElement adults = findElementById("adult_room");
		String adultsCount = getData(1, 8);
		selectByText(adults, adultsCount);

		WebElement child = findElementById("child_room");
		String childCount = getData(1, 9);
		selectByText(child, childCount);

		WebElement btnSearch = findElementById("Submit");
		click(btnSearch);

		WebElement btnSelect = findElementById("radiobutton_0");
		click(btnSelect);

		WebElement btnContinue = findElementById("continue");
		click(btnContinue);

		WebElement txtFirstName = findElementById("first_name");
		String firstName = getData(1, 10);
		enterText(txtFirstName, firstName);

		WebElement txtLastName = findElementById("last_name");
		String lastName = getData(1, 11);
		enterText(txtLastName, lastName);

		WebElement txtAddress = findElementById("address");
		String address = getData(1, 12);
		enterText(txtAddress, address);

		WebElement txtCCNum = findElementById("cc_num");
		String ccNum = getData(1, 13);
		enterText(txtCCNum, ccNum);

		WebElement dDnCCtype = findElementById("cc_type");
		String ccType = getData(1, 14);
		selectByText(dDnCCtype, ccType);

		WebElement dDnCCExpMonth = findElementById("cc_exp_month");
		String expMonth = getData(1, 15);
		selectByText(dDnCCExpMonth, expMonth);

		WebElement dDnCCExpYear = findElementById("cc_exp_year");
		String data = getData(1, 16);
		selectByText(dDnCCExpYear, data);

		WebElement txtCVV = findElementByXpath("//input[@id='cc_cvv']");
		String cvv = getData(1, 17);
		enterText(txtCVV, cvv);

		WebElement btnBookNow = findElementById("book_now");
		click(btnBookNow);

	}

	@AfterClass
	public static void afterClass() throws IOException {
		
		waitUntil();
		
		WebElement orderId = findElementById("order_no");
		String dataorder = orderId.getAttribute("value");
		writeData(dataorder, 1, 18);
		System.out.println("Completed");
	}

}
