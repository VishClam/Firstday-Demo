package org.tasks;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public class TaskExcel {

	public static void main(String[] args) throws IOException, Exception {

		BaseClass b = new BaseClass();
		b.browserLaunch();
		b.enterUrl("https://adactinhotelapp.com/SearchHotel.php");
		b.fullWindow();
		
		WebElement txtUser = b.findElementById("username");
		String user = b.getData(1, 0);
		b.enterText(txtUser, user);

		WebElement txtPass = b.findElementById("password");
		String pass = b.getData(1, 1);
		b.enterText(txtPass, pass);

		WebElement btnLogin = b.findElementById("login");
		b.click(btnLogin);
		WebElement location = b.findElementById("location");
		String city = b.getData(1, 2);
		b.selectByText(location, city);

		WebElement hotels = b.findElementById("hotels");
		String hotel = b.getData(1, 3);
		b.selectByText(hotels, hotel);

		WebElement roomType = b.findElementById("room_type");
		String room = b.getData(1, 4);
		b.selectByText(roomType, room);

		WebElement noOfRooms = b.findElementById("room_nos");
		String roomCount = b.getData(1, 5);
		b.selectByText(noOfRooms, roomCount);

		WebElement adults = b.findElementById("adult_room");
		String adultsCount = b.getData(1, 8);
		b.selectByText(adults, adultsCount);

		WebElement child = b.findElementById("child_room");
		String childCount = b.getData(1, 9);
		b.selectByText(child, childCount);

		WebElement btnSearch = b.findElementById("Submit");
		b.click(btnSearch);

		WebElement btnSelect = b.findElementById("radiobutton_0");
		b.click(btnSelect);

		WebElement btnContinue = b.findElementById("continue");
		b.click(btnContinue);

		WebElement txtFirstName = b.findElementById("first_name");
		String firstName = b.getData(1, 10);
		b.enterText(txtFirstName, firstName);

		WebElement txtLastName = b.findElementById("last_name");
		String lastName = b.getData(1, 11);
		b.enterText(txtLastName, lastName);

		WebElement txtAddress = b.findElementById("address");
		String address = b.getData(1, 12);
		b.enterText(txtAddress, address);

		WebElement txtCCNum = b.findElementById("cc_num");
		String ccNum = b.getData(1, 13);
		b.enterText(txtCCNum, ccNum);

		WebElement dDnCCtype = b.findElementById("cc_type");
		String ccType = b.getData(1, 14);
		b.selectByText(dDnCCtype, ccType);

		WebElement dDnCCExpMonth = b.findElementById("cc_exp_month");
		String expMonth = b.getData(1, 15);
		b.selectByText(dDnCCExpMonth, expMonth);

		WebElement dDnCCExpYear = b.findElementById("cc_exp_year");
		String data = b.getData(1, 16);
		b.selectByText(dDnCCExpYear, data);

		WebElement txtCVV = b.findElementByXpath("//input[@id='cc_cvv']");
		String cvv = b.getData(1, 17);
		b.enterText(txtCVV, cvv);

		WebElement btnBookNow = b.findElementById("book_now");
		b.click(btnBookNow);
		
		b.waitUntil();
		
		WebElement orderId = b.findElementById("order_no");
		String dataorder = orderId.getAttribute("value");
		b.writeData(dataorder, 1, 18);
		System.out.println("Completed");
	}

}
