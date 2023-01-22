package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

class BlogTest2 {

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
		
		Actions builder = new Actions(webDriver);
		
		Action action = builder
				.moveToElement(webDriver.findElement(By.linkText("Blog")))
				.moveByOffset(0, 400)
				.click()
				.pause(Duration.ofSeconds(3))
				.build();
				
		action.perform();
		
		WebElement header = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div/div[2]/div/div/div/h1"));
		String text = header.getText();
		assertEquals("Tech Bites", text);
			
		Thread.sleep(3000);
		
		Action linkClick = builder
				.moveToElement(webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div/div[2]/div/div/div/h1")))
				.moveByOffset(0, 200)
				.click()
				.pause(Duration.ofSeconds(3))
				.build();
				
		linkClick.perform();
		
		Thread.sleep(3000);
				
		String url = webDriver.getCurrentUrl();
		assertEquals("https://www.atlantbh.com/category/tech-bites/", url);
		
		webDriver.navigate().back();
		
		Thread.sleep(3000);
		String url2 = webDriver.getCurrentUrl();
		assertEquals("https://www.atlantbh.com/", url2);
		
	}
}
