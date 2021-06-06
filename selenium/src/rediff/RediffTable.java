package rediff;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RediffTable {

	public static void main(String[] args) {

		// Initialize Driver
		System.setProperty("webdriver.chrome.driver", "F:\\Softwares\\Driver\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();

		// Open URl
		driver.get("https://money.rediff.com/gainers");

		List<WebElement> allcompanies = driver.findElements(By.xpath("//table [@class='dataTable']/tbody/tr/td[1]/a"));
		System.out.println(allcompanies.size());

		List<WebElement> currentPrice = driver.findElements(By.xpath("//table [@class='dataTable']/tbody/tr/td[4]"));
		System.out.println(currentPrice.size());

//		String expected = "South India Pape";

		double temp = Double.valueOf(currentPrice.get(0).getText());
		for (int i = 1; i < allcompanies.size(); i++) {
			String pri = currentPrice.get(i).getText().replaceAll(",", "");
			double price = Double.valueOf(pri);
			if (price > temp) {
				temp = price;
			}

			

//			if(allcompanies.get(i).getText().equalsIgnoreCase(expected)) {
//				System.out.println(allcompanies.get(i).getText()+"===="+currentPrice.get(i).getText());
//				allcompanies.get(i).click();
//				break;
//			}
		}
		System.out.println(temp);
		

	}

}
