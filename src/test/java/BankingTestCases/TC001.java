package BankingTestCases;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.CustomerDetails;
import PageObjects.LoginPage;
import Utility.BaseClass;

public class TC001 extends BaseClass{
	  WebDriver Driver;
	@BeforeClass
	public void Setup() {
		BaseClass.LaunchBrowser("chrome", "http://www.way2automation.com/angularjs-protractor/banking/#/login");
		Driver=BaseClass.Driver;
	}
	@Test
	public void Login() throws InterruptedException {
		LoginPage lp = new LoginPage(Driver);
		Thread.sleep(5000);
		lp.clickbtn();
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods = { "Login" })
	public void CreateCustomer() {
		CustomerDetails cd = new CustomerDetails(Driver);
		try {
			cd.ClickAddCustomer();
			Thread.sleep(5000);
			cd.SeFirstName();
			Thread.sleep(5000);
			cd.SetLastName();
			Thread.sleep(5000);
			cd.SetPostalCode();
			Thread.sleep(5000);
			cd.ClickSubmit();
			Thread.sleep(5000);
			BaseClass.AcceptAlert();
			Thread.sleep(5000);
			cd.OpenAcct();
			Thread.sleep(5000);
			cd.SelectCustomerName();
			Thread.sleep(5000);
			cd.SelectCurrency();
			Thread.sleep(5000);
			cd.ClickProcessbtn();
			Thread.sleep(5000);
			BaseClass.AcceptAlert();
			Thread.sleep(5000);
			cd.ClickCustmrBtn();
			Thread.sleep(5000);
			cd.SearchCustomer();
			Thread.sleep(5000);
			String CustomerName=cd.customerSearchName();
			if(CustomerName.equalsIgnoreCase("Dattasai")) {
				System.out.println("Customer Name is Correct");
				Assert.assertTrue(true);
			}else {
				Assert.assertFalse(true);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@AfterClass
	public void TearDown() {
		Driver.close();
		Driver.quit();
	}
}
