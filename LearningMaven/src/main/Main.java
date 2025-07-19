package main;

//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Main {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
//		WebElement body = driver.findElement(By.tagName("body"));
//		body.sendKeys(Keys.CONTROL+"N");
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
//		driver.close();
		
		
		
		
//		driver.close();

	}

}