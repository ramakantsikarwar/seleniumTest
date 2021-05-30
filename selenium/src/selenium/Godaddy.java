package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Godaddy {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.godaddy.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		String getTitledir = driver.getTitle();
		System.out.println(driver.getCurrentUrl());
		WebElement Ttle = driver.findElement(By.tagName("title"));
		String ScrTitle = Ttle.getAttribute("textContent");
		System.out.println(ScrTitle);
		
		if(ScrTitle==getTitledir)
			System.out.println("Titles Match");
		else
			System.out.println("Titles Does not Match");
		//System.out.println(driver.getPageSource());
		Thread.sleep(2000);
		driver.close();
	}

}
