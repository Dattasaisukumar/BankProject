package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver Driver;
	public static void LaunchBrowser(String BrowserName,String Url) {
		if(BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			Driver = new ChromeDriver();
			Driver.get(Url);
		}else if(BrowserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			Driver = new FirefoxDriver();
			Driver.get(Url);
		}else if(BrowserName.equalsIgnoreCase("edge")) {
			Driver = new EdgeDriver();
			WebDriverManager.edgedriver().setup();
			Driver.get(Url);
		}else {
			System.out.println("Brower Type is Invalid");
		}
	}
	
	public static  void AcceptAlert() {
		Driver.switchTo().alert().accept();
	}

}
