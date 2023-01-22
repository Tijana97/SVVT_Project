package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class BlogTest {

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
		Thread.sleep(1000);
		
		webDriver.findElement(By.xpath("//*[@id=\"menu-item-13931\"]/a")).click();
		
		Thread.sleep(3000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div/"
				+ "div/div/div[2]/div/div/div[2]/div/div/ul/li[3]/a")).click();
		
		Thread.sleep(3000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div/"
				+ "div/div/div[2]/div/div/div[2]/div/div/div[3]/div/div/div/article[2]/div/div/div/a")).click();
			
		Thread.sleep(3000);
		
		String url = webDriver.getCurrentUrl();
		assertEquals("https://www.atlantbh.com/data-hunters-how-big-data-changed-the-world-of-golf/", url);
		
		String author = webDriver.findElement(By.xpath("//*[@id=\"single-below-header\"]/span[1]")).getText();
		assertTrue(author.contains("Tanja Micic"));
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div/"
				+ "div[2]/div/div/div/div/span[1]/span/a")).click();
		Thread.sleep(2000);
		String url2 = webDriver.getCurrentUrl();
		assertEquals("https://www.atlantbh.com/author/tanja-micic/", url2);
		
		webDriver.navigate().back();
		webDriver.navigate().back();
		webDriver.navigate().back();
		
		Thread.sleep(3000);
		String url3 = webDriver.getCurrentUrl();
		assertEquals("https://www.atlantbh.com/", url3);
		
	}

}
