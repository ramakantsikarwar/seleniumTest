package facebook;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaceBook {

	public static void main(String[] args) throws InterruptedException {
		// Initialize Driver
		System.setProperty("webdriver.chrome.driver", "F:\\Softwares\\Driver\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();

		// Open URl
		driver.get("https://www.facebook.com/");

		// Change Locale to En(US)
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@role='button'][@rel='dialog']")).click();
		WebDriverWait wt = new WebDriverWait(driver,10);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='intl-region-none selected-intl-region1']//a[contains(text(),'English (US)')]"))).click();
		
//		driver.findElement(
//				By.xpath("//div[@class='intl-region-none selected-intl-region1']//a[contains(text(),'English (US)')]"))
//				.click();

		// Create New Account form:

		// 1. Text Inputs
		driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Ramakant");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Sikarwar");
		driver.findElement(By.xpath("//input[@*='Mobile number or email address']"))
				.sendKeys("ramakantsikarwar@gmail.com");
		driver.findElement(By.xpath("//input[@*='Re-enter email address']")).sendKeys("ramakantsikarwar@gmail.com");
		driver.findElement(By.xpath("//input[@*='New password']")).sendKeys("Rss@1230");

		// 2. DropDown [Day]

		WebElement daydrop = driver.findElement(By.xpath("//select[@*='day']"));
		daydrop.click();
		List<WebElement> daylist = driver.findElements(By.xpath("//select[@*='day']"));
		for (WebElement prdaylist : daylist) {
			System.out.println(prdaylist.getText());
		}

		// To Select value By Index
		Select select = new Select(daydrop);
		select.selectByIndex(1);
		System.out.println("By Index" + select.getFirstSelectedOption().getText());
		select.selectByValue("10");
		System.out.println("By Value" + select.getFirstSelectedOption().getText());
		select.selectByVisibleText("15");
		System.out.println("By Visible text" + select.getFirstSelectedOption().getText());
	}

}
