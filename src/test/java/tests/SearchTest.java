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

class SearchTest {

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
		Actions builder = new Actions(webDriver);
		Action action = builder
				.moveToElement(webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/"
						+ "div/div/div[2]/nav/ul[1]/li[7]/a"))).click()
				.moveToElement(webDriver.findElement(By.id("is-search-input-0"))).click()
				.sendKeys("ux/ui design")
				.pause(Duration.ofSeconds(2))
				.moveToElement(webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/"
						+ "header/div/div/div[2]/nav/ul[1]/li[7]/form/button/span[2]"))).click()
				.pause(Duration.ofSeconds(3))
				.build();		
		action.perform();
		Thread.sleep(2000);
		WebElement num = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div/div/div/div/span"));
		String text = num.getText();
		assertEquals("13 results found", text);
		String url = webDriver.getCurrentUrl();
		assertEquals("https://www.atlantbh.com/?s=ux%2Fui+design", url);
		Action clickLink = builder
				.moveToElement(webDriver.findElement(By.linkText("Service – UX/UI Design"))).click()
				.pause(Duration.ofSeconds(3))
				.build();	
		clickLink.perform();
		Thread.sleep(3000);
		String url2 = webDriver.getCurrentUrl();
		assertEquals("https://www.atlantbh.com/service-ux-ui-design/", url2);
		webDriver.navigate().back();
		Thread.sleep(3000);
		webDriver.navigate().back();
		Thread.sleep(3000);
		String url3 = webDriver.getCurrentUrl();
		assertEquals("https://www.atlantbh.com/", url3);
	
	}

}
