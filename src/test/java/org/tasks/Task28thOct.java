package org.tasks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Task28thOct {
	public static void main(String[] args) throws Exception {

		BaseClass base = new BaseClass();

		base.browserLaunch();
		base.fullWindow();
		base.enterUrl("http://demo.automationtesting.in/Register.html");
		WebElement txtFirstName = base.findElementByXpath("//input[@placeholder='First Name']");
		base.enterText(txtFirstName, "Vishnu");
		WebElement txtLastName = base.findElementByXpath("//input[@placeholder='Last Name']");
		base.enterText(txtLastName, "M");
		WebElement txtAddress = base
				.findElementByXpath("//textarea[@class='form-control ng-pristine ng-untouched ng-valid']");
		base.enterText(txtAddress, "No.31, MGR Street, chennai");
		WebElement txtEmail = base.findElementByXpath("//input[@type='email']");
		base.enterText(txtEmail, "vishnu8@gamil.com");
		WebElement txtPhone = base.findElementByXpath("//input[@type='tel']");
		base.enterText(txtPhone, "9827489320");
		WebElement btnGender = base.findElementByXpath("//input[@value='Male']");
		base.click(btnGender);
		WebElement btnCricket = base.findElementById("checkbox1");
		base.click(btnCricket);
		WebElement btnMovies = base.findElementById("checkbox2");
		base.click(btnMovies);
		WebElement btnLanguage = base.findElementById("msdd");
		base.click(btnLanguage);
		Thread.sleep(300);
		WebElement btnLang1 = base.findElementByXpath("//a[text()='English']");
		base.click(btnLang1);
		WebElement btnEsc = base.findElementByXpath("//div[@class='top']");
		base.click(btnEsc);
		WebElement dDnSkills = base.findElementById("Skills");
		base.click(dDnSkills);
		base.selectByIndex(dDnSkills, 4);
		WebElement btnEsc1 = base.findElementByXpath("//div[@class='top']");
		base.click(btnEsc1);

		/*WebElement dDnCountry = base.findElementById("//span[@class='select2-selection__arrow']");
		base.click(dDnCountry);
		WebElement btnIndia = base.findElementByXpath("//li[text()='India']");
		base.click(btnIndia);
		Thread.sleep(300);
		WebElement btnEsc2 = base.findElementByXpath("//div[@class='top']");
		base.click(btnEsc2);
*/
	}

}
