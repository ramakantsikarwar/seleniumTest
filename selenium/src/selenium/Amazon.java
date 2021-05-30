
package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","F:\\Softwares\\Driver\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		WebElement Mobiles = driver.findElement(By.xpath("//a[normalize-space()='Mobiles']"));
		System.out.println(Mobiles.getText());
		driver.quit();

	}

}
