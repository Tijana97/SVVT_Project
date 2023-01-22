package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class ContactUsTest {

	private static WebDriver webDriver;
	private static String baseUrl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tbura\\OneDrive\\Desktop\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--start-maximized");
		
		webDriver = new ChromeDriver(options);
		baseUrl = "https://www.atlantbh.com";
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}

	@Test
	void test() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.findElement(By.xpath("//*[@id=\"cn-accept-cookie\"]")).click();
		Thread.sleep(2000);
		
		webDriver.findElement(By.linkText("Contact")).click();
		
		WebElement header = webDriver.findElement(By.cssSelector("#page-header-bg > div.container > div > div > div > h1"));
		String text = header.getText();
		
		assertEquals("Let’s make things happen", text);
		
		webDriver.findElement(By.name("ask-us")).sendKeys("This is my message");
		Thread.sleep(1000);
		
		webDriver.findElement(By.name("form-input-mail")).sendKeys("example@gmail.com");
		webDriver.findElement(By.name("form-input-text")).sendKeys("Sara");
		Thread.sleep(2000);
		
		String url = webDriver.getCurrentUrl();
		assertEquals("https://www.atlantbh.com/contact/", url);
		
		webDriver.navigate().back();
		Thread.sleep(2000);
		
		String url2 = webDriver.getCurrentUrl();
		assertEquals("https://www.atlantbh.com/", url2);
		
	}

}
