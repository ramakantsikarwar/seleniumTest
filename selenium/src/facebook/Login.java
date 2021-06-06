package facebook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\Softwares\\Driver\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();

		// Open URl
		driver.get("https://www.facebook.com/");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement button =driver.findElement(By.name("login"));
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		  js.executeScript("arguments[0].click();", button);
		  
		  js.executeScript("alert('Errror aa rhi hai');"); 

	}

}
