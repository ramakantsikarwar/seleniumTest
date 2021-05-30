package selenium;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Sleeper;

public class Cowin {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Creating the JavascriptExecutor interface object by Type casting
		driver.get("https://www.cowin.gov.in/home");
		WebElement switchButton = driver.findElement(By.xpath("//div[@class='status-switch']"));
		switchButton.click();
		WebElement stateDropDown = driver.findElement(By.xpath("//mat-select[@formcontrolname='state_id']"));
		stateDropDown.click();
		Thread.sleep(2000);
		WebElement stateDropDownClicked = driver
				.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option[21]/span"));
		System.out.println(stateDropDownClicked.getText());
		stateDropDownClicked.click();
		Thread.sleep(2000);
		WebElement districtDropDown = driver.findElement(By.xpath("//mat-select[@formcontrolname='district_id']"));
		districtDropDown.click();
		Thread.sleep(2000);
		WebElement districtDropDownClicked = driver
				.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option[19]/span"));
		districtDropDownClicked.click();
		Thread.sleep(2000);
		WebElement Search = driver.findElement(By.xpath("//button[@class = 'pin-search-btn district-search']"));
		Search.click();
		Thread.sleep(2000);
//		WebElement Eighteen = driver.findElement(By.xpath("//label[@class='form-check-label' and contains(text(),'Age 18+') ]"));
//		Eighteen.click();
//		Thread.sleep(2000);

		List<WebElement> row = driver.findElements(By.xpath(
				"/html/body/app-root/div/app-home/div[2]/div/appointment-table/div/div/div/div/div/div/div/div/div/div/div[2]/form/div/div/div[6]/div/div/div/div"));
		System.out.println("No of cols are : " + row.size());
		int rsize = row.size();

		List<WebElement> col = driver.findElements(By.xpath(
				"/html/body/app-root/div/app-home/div[2]/div/appointment-table/div/div/div/div/div/div/div/div/div/div/div[2]/form/div/div/div[6]/div/div/div/div[13]/div/div/div[2]/ul/li"));
		System.out.println("No of cols are : " + col.size());
		int csize = col.size();

		for (int i = 1; i < rsize - 1; i++) {
			for (int j = 1; j < csize - 1; j++) {
				String elementpath = "/html/body/app-root/div/app-home/div[2]/div/appointment-table/div/div/div/div/div/div/div/div/div/div/div[2]/form/div/div/div[6]/div/div/div/div["
		+ i + "]/div/div/div[2]/ul/li[" + j + "]/div/div/";
				String hospitalpath = "/html/body/app-root/div/app-home/div[2]/div/appointment-table/div/div/div/div/div/div/div/div/div/div/div[2]/form/div/div/div[6]/div/div/div/div["+ i + "]/div/div/div[1]/div/h5";
				WebElement Element = driver.findElement(By.xpath(elementpath+"a"));
				WebElement vaccineName = driver.findElement(By.xpath(elementpath+"div[1]/h5"));
				WebElement hospitalName = driver.findElement(By.xpath(hospitalpath));
				
				String sr = Element.getText();
				String vr = vaccineName.getText();
				String hr = hospitalName.getText();
				LocalDate tday = java.time.LocalDate.now();
				LocalDate rday = tday.minusDays(j-3);
				// System.out.println(Element.getText());
				if (sr.equals("NA")) {
				} else if (sr.equals("Booked")) {
				} else {
					System.out.println(rday);
					System.out.println(hr);
					System.out.println(sr);
					System.out.println(vr);
					System.out.println("------");
				}
			}
		}
	}

}
