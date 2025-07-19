package main;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args)
			throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/cares/OneDrive/Desktop/eclipse/browser/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("name")).sendKeys("text");

		getScreenshot(driver);

		driver.findElement(By.cssSelector("[id='alertbtn']")).click();

		Thread.sleep(3000);

		System.out.println(driver.switchTo().alert().getText());

		assertTrue((driver.switchTo().alert().getText()).contains("text"));

		driver.switchTo().alert().accept();

		getScreenshot(driver);

		driver.findElement(By.id("confirmbtn")).click();

		Thread.sleep(3000);

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().dismiss();
	}

	public static void getScreenshot(WebDriver driver) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
				.format(new Date());
		FileUtils.copyFile(src, new File(
				"C:\\Users\\cares\\OneDrive\\Desktop\\eclipse\\screenshots\\Alerts\\screenshot"
						+ timestamp + ".png"));

	}

}
