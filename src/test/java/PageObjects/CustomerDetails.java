package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerDetails {
	
	WebDriver ldriver;
	
	public CustomerDetails(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="//button[text()='Home']")
	WebElement btnHome;
	
	@FindBy(xpath="//button[@ng-click='addCust()']")
	WebElement AddCustomerbtn;
	
	@FindBy(xpath="//button[@ng-click='openAccount()']")
	WebElement OpenAcctbtn;
	
	@FindBy(xpath="//button[@ng-click='showCust()']")
	WebElement CustmBtn;
	
	@FindBy(xpath="//input[@ng-model='fName']")
	WebElement txtFName;
	
	@FindBy(xpath="//input[@ng-model='lName']")
	WebElement txtLName;
	
	@FindBy(xpath="//input[@ng-model='postCd']")
	WebElement txtPostalCode;
	
	@FindBy(xpath="//button[text()='Add Customer']")
	WebElement BtnSubmitCust;
	
	@FindBy(xpath="//input[@ng-model='searchCustomer']")
	WebElement txtSearch;
	
	@FindBy(xpath="//tbody/tr[@class='ng-scope']/td[1]")
	WebElement ColmValue;
	
	@FindBy(xpath="//select[@ng-model='custId']")
	WebElement DrpdwnCustomerName;
	
	@FindBy(xpath="//select[@ng-model='currency']")
	WebElement DrpdwnCurrency;
	
	@FindBy(xpath="//button[text()='Process']")
	WebElement BtnProcess;
	
	public void WaiforElement() {
		WebDriverWait wait = new WebDriverWait (ldriver,60);
		wait.until(ExpectedConditions.visibilityOf(btnHome));
	}
	
	public void ClickAddCustomer() {
		AddCustomerbtn.click();
	}
	
	public void SeFirstName() {
		txtFName.sendKeys("DattaSai");
	}
	
	public void SetLastName() {
		txtLName.sendKeys("Sukumar");
	}
	
	public void SetPostalCode() {
		txtPostalCode.sendKeys("500057");
	}
	
	public void ClickSubmit() {
		BtnSubmitCust.click();
	}
	
	public void OpenAcct() {
		OpenAcctbtn.click();
	}
	
	public void SelectCustomerName() {
		Select customername = new Select(DrpdwnCustomerName);
		customername.selectByVisibleText("DattaSai Sukumar");
	}
	
	public void SelectCurrency() {
		Select CurrencyType = new Select(DrpdwnCurrency);
		CurrencyType.selectByVisibleText("Rupee");
		
	}
	
	public void ClickProcessbtn() {
		BtnProcess.click();
	}
	
	public void ClickCustmrBtn() {
		CustmBtn.click();
	}
	public void SearchCustomer() {
		txtSearch.sendKeys("DattaSai");
	}
	
	public String customerSearchName () {
		String CustomerName=ColmValue.getText();
		return CustomerName;
	}
	
}
