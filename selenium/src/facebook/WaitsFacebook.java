package facebook;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsFacebook {

	public static void main(String[] args) {
		// Initialize Driver
		System.setProperty("webdriver.chrome.driver", "F:\\Softwares\\Driver\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();

		// Open URl
		driver.get("https://www.facebook.com/");

		// Change Locale to En(US)
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		WebDriverWait wt = new WebDriverWait(driver, 6);
//		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@role='button'][@rel='dialog']"))).click();
		driver.findElement(By.xpath("//a[@role='button'][@rel='dialog']")).click();

//		wt.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//div[@class='intl-region-none selected-intl-region1']//a[contains(text(),'English (US)')]")))
//				.click();
		driver.findElement(
				By.xpath("//div[@class='intl-region-none selected-intl-region1']//a[contains(text(),'English (US)')]"))
				.click();

		// Create New Account form:

		// 1. Text Inputs
		driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Ramakant");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Sikarwar");
		driver.findElement(By.xpath("//input[@*='Mobile number or email address']"))
				.sendKeys("ramakantsikarwar@gmail.com");
		driver.findElement(By.xpath("//input[@*='Re-enter email address']")).sendKeys("ramakantsikarwar@gmail.com");
		driver.findElement(By.xpath("//input[@*='New password']")).sendKeys("Rss@1230");

		// 2. DropDown [Day]

		WebElement daydrop = driver.findElement(By.xpath("//select[@*='day']"));
		Select selectday = new Select(daydrop);

		selectday.selectByVisibleText("23");
		System.out.println("Day: " + selectday.getFirstSelectedOption().getText());

		// 2. DropDown [Month]

		WebElement monthdrop = driver.findElement(By.xpath("//select[@*='month']"));
		Select selectmonth = new Select(monthdrop);

		selectmonth.selectByVisibleText("Sep");
		System.out.println("Month: " + selectmonth.getFirstSelectedOption().getText());

		// 2. DropDown [Year]

		WebElement yeardrop = driver.findElement(By.xpath("//select[@*='year']"));
		Select selectyear = new Select(yeardrop);

		selectyear.selectByVisibleText("1994");
		System.out.println("Year: " + selectyear.getFirstSelectedOption().getText());

		//3. RadioButton [Gender]
		List<WebElement> gender = driver.findElements(By.xpath("//input[@type='radio']"));
		for(int i=0;i<gender.size();i++) {
			System.out.println("Gender value on index "+ i +" : "+ gender.get(i).getText());
		}
		gender.get(1).click();
		
		
	}

}
