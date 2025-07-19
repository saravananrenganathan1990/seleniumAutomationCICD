package main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Arrayaddproducts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/cares/OneDrive/Desktop/eclipse/browser/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://demowebshop.tricentis.com/apparel-shoes");

		List<WebElement> products = driver
				.findElements(By.cssSelector("h2.product-title"));

		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getText();
			if (name.contains("Blue Jeans")) {
				driver.findElements(
						By.cssSelector("input[value='Add to cart']")).get(i)
						.click();
				break;
			}

		}

		// driver.quit();
	}

}
