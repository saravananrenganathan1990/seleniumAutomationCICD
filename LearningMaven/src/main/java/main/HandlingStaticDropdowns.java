package main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class HandlingStaticDropdowns {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//*[text()='Currency']/following-sibling::div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Currency']/parent::div/following-sibling::div/descendant::div[text()='OMR']")).click();
		driver.findElement(By.xpath("//*[text()='Passengers']/following-sibling::div")).click();
		/*int w = 1;
		while (w < 5) {

			driver.findElement(By.id("hrefIncAdt")).click();

			w++;

		}*/
		System.out.println(driver.findElement(By.xpath("//*[text()='Passengers']/following-sibling::div/*")).getText());

		for (int i = 1; i < 5; i++)

		{

			driver.findElement(By.cssSelector("[data-testid='Adult-testID-plus-one-cta']")).click();

		}
		driver.findElement(By.xpath("//*[text()='Passengers']/following-sibling::div")).click();

//		driver.findElement(By.id("btnclosepaxoption")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//*[text()='Passengers']/following-sibling::div/*")).getText(),
				"5 Adults");
		System.out.println(driver.findElement(By.xpath("//*[text()='Passengers']/following-sibling::div/*")).getText());
	}

}
