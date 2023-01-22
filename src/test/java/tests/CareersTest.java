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

class CareersTest {

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
		
		webDriver.findElement(By.linkText("Careers")).click();
		Thread.sleep(2000);
		
		webDriver.findElement(By.linkText("Culture")).click();
		
		Thread.sleep(2000);
		
		WebElement c = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div/div[2]/div/div/div/h1"));
		String text = c.getText();
		
		assertEquals("Culture", text);
		
		String url = webDriver.getCurrentUrl();
		assertEquals("https://www.atlantbh.com/category/culture/", url);
	}

}
