package flipkart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkart {

	public static void main(String[] args) {
		
		//Initalize Driver
		System.setProperty("webdriver.chrome.driver", "F:\\Softwares\\Driver\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		
		//Enter URl
		driver.get("https://www.flipkart.com/");
		
		//Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[contains(@class,'_2KpZ6l _2doB4z')]")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Mobiles')]")).click();
		
		//Actions Class
		Actions action = new Actions(driver);
		WebElement hoveri = driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"));
		action.moveToElement(hoveri).perform();
		
		//Provide item name
		String item = "Soundbars";
		String xpathitem = "//*[contains(text(),'"+item+"')]";
		driver.findElement(By.xpath(xpathitem)).click();
//		driver.findElement(By.xpath("//div[@title='Core i7']")).click();
//		driver.findElement(By.xpath("//div[@title='Ryzen 7 Octa Core']")).click();
//		driver.findElement(By.xpath("//div[@title='Core i9']")).click();
		
//		driver.findElement(By.xpath("//div[@title='64 GB']")).click();
//		driver.findElement(By.xpath("//div[@title='8 GB']")).click();
//		driver.findElement(By.xpath("//div[@title='32 GB']")).click();
		
		
		
		
		

	}

}
