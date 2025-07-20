package test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Automatedtests {

	WebDriver driver;
	WebDriverWait dw;
	Actions a;

	@BeforeTest
	public void browserInitiate() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\cares\\OneDrive\\Desktop\\eclipse\\browser\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dw = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@AfterTest
	public void browserClose() {
		driver.quit();
	}

	@Test
	public void fluentwait() {
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("div#start button")).click();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);
		@SuppressWarnings("unused")
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				if (driver.findElement(By.cssSelector("div#finish h4"))
						.isDisplayed()) {
					return driver.findElement(By.cssSelector("div#finish h4"));
				} else
					return null;
			}
		});
		System.out.println(driver.findElement(By.cssSelector("div#finish h4"))
				.isDisplayed());
	}

	@Test
	public void mouseActions() throws InterruptedException {
		a = new Actions(driver);
		driver.get(
				"https://www.cibc.com/en/personal-banking/credit-cards.html");
		WebElement acceptCookies = driver
				.findElement(By.id("onetrust-accept-btn-handler"));
		WebElement learnMore = driver.findElement(By.xpath(
				"(//span[contains(text(),'Aeroplan Visa')]/preceding-sibling::span)[1]"));
		dw.until(ExpectedConditions.elementToBeClickable(acceptCookies))
				.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,2500)");
		js.executeScript("arguments[0].scrollIntoView(true);", learnMore);
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"(//span[contains(text(),'Aeroplan Visa')]/preceding-sibling::span)[1]"))
				.click();
		// a.scrollToElement(learnMore).build().perform();
		// a.click(learnMore).build().perform();
	}

	@Test
	public void windowHandles() {
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String parentId = it.next();
		String childID = it.next();
		driver.switchTo().window(childID);
		System.out.println(
				driver.findElement(By.cssSelector("div h3")).getText());
		driver.switchTo().window(parentId);
		System.out.println(
				driver.findElement(By.cssSelector("div h3")).getText());
	}

	@Test
	public void frameHandle() {
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo()
				.frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		a = new Actions(driver);
		a.dragAndDrop(driver.findElement(By.id("draggable")),
				driver.findElement(By.id("droppable"))).build().perform();
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Accept")).click();

	}

	@Test
	public void calendarPick() {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		String Year = "2028";
		String Month = "August";
		String Day = "16";
		driver.findElement(By.cssSelector(
				".react-date-picker__calendar-button.react-date-picker__button"))
				.click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label"))
				.click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label"))
				.click();
		List<WebElement> yearList = driver.findElements(
				By.cssSelector(".react-calendar__decade-view__years button"));

		for (int i = 0; i < yearList.size(); i++) {
			if (yearList.get(i).getText().equals(Year)) {
				yearList.get(i).click();
				break;
			}
		}
		List<WebElement> monthList = driver.findElements(By
				.cssSelector(".react-calendar__year-view__months button abbr"));
		for (int i = 0; i < monthList.size(); i++) {
			if (monthList.get(i).getText().equals(Month)) {
				monthList.get(i).click();
				break;
			}
		}
		List<WebElement> dayList = driver.findElements(By
				.cssSelector(".react-calendar__month-view__days button abbr"));
		for (int i = 0; i < dayList.size(); i++) {
			if (dayList.get(i).getText().equals(Day)) {
				dayList.get(i).click();
				break;
			}
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\cares\\OneDrive\\Desktop\\eclipse\\browser\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait dw = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement emptable = driver.findElement(By.className("tableFixHead"));
		js.executeScript("arguments[0].scrollIntoView(true);", emptable);
		List<WebElement> amount = driver
				.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		for (int i = 0; i < amount.size(); i++) {
			sum = sum + Integer.parseInt(amount.get(i).getText());
		}
		driver.findElement(By.cssSelector(".totalAmount")).getText();
		int expected = Integer
				.parseInt(driver.findElement(By.cssSelector(".totalAmount"))
						.getText().split(":")[1].trim());
		Assert.assertEquals(sum, expected);

	}

}