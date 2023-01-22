package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

class SocialMediaTest2 {

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
		String handle1 = webDriver.getWindowHandle();
		
		Actions builder = new Actions(webDriver);
		
		Action action = builder
				.moveToElement(webDriver.findElement(By.linkText("Contact")))
				.moveByOffset(160, 0).click()
				.pause(Duration.ofSeconds(3))
				.build();
				
		action.perform();
		
		Thread.sleep(5000);
		
		for (String handle : webDriver.getWindowHandles()) {
			if(!handle.equals(handle1)){
				webDriver.switchTo().window(handle);
				break;
			}
		}
		
		Thread.sleep(2000);
		
		webDriver.findElement(By.id("username")).sendKeys("example@gmail.com");
		webDriver.findElement(By.id("password")).sendKeys("password");
		
		Thread.sleep(2000);
		
		String url = webDriver.getCurrentUrl();
		assertEquals("https://www.linkedin.com/uas/login?session_redirect=%2Fcompany%2F1485526", url);
		
		
	}

}
