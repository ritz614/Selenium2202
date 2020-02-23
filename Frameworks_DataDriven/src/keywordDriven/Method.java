package keywordDriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Method {
	
	static WebDriver driver;
	
	public static void Launch_App(String url) {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();	
	}
	
	public static void Imp_Wait () {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void Set_TextBox(String LocVal, String TestData) {
		driver.findElement(By.id(LocVal)).sendKeys(TestData);
	}
	
	public static void Click_Submit(String LocVal) {
		driver.findElement(By.id(LocVal)).click();
	}
	
	public static String Verify_Msg (String LocVal) {
		String ErrMsg = driver.findElement(By.cssSelector(LocVal)).getText();
	    return ErrMsg;
	}

    public static void Close_App() {
    	driver.close();
    }
}
