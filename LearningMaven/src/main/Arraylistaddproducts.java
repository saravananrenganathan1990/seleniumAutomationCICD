package main;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Arraylistaddproducts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/cares/OneDrive/Desktop/eclipse/browser/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://demowebshop.tricentis.com/gift-cards");
		int j = 0;

		String[] itemsNeeded = {"$5", "$50 Physical Gift Card",
				"$100 Physical Gift Card"};

		List<WebElement> products = driver
				.findElements(By.cssSelector("h2.product-title"));

		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getText();
			System.out.println(products.get(i).getText());
			List<String> itemNeededList = Arrays.asList(itemsNeeded);
			if (itemNeededList.contains(name)) {
				j++;
				driver.findElements(
						By.cssSelector("input[value='Add to cart']")).get(i)
						.click();
				Thread.sleep(3000);
				driver.findElement(By.cssSelector(
						"div.add-to-cart-panel input[value='Add to cart']"))
						.click();
				driver.navigate().back();
				if (j == itemsNeeded.length) {
					break;
				}

			}
		}

		// driver.quit();
	}

}
