package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class LeaveAComment {

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
		
		webDriver.findElement(By.xpath("//*[@id=\"menu-item-13931\"]")).click();
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/"
				+ "div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div[2]/a")).click();
		
		Thread.sleep(3000);
		
		String url = webDriver.getCurrentUrl();
		assertEquals("https://www.atlantbh.com/delivering-quality-with-a-happy-team/", url);
		
		String text = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]"
				+ "/div[1]/div[2]/div/div[1]/div/article/div/div/div/div[2]/div[2]/"
				+ "div/div/div[3]/div[2]/div/div[2]/div[1]/div/div/h3[2]")).getText();
		assertEquals("Summary", text);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]"
				+ "/div/div[2]/div/div/div/form/div[1]/div/textarea")).sendKeys("Nice article!");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"author\"]")).sendKeys("tester");
		webDriver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("example@gmail.com");
		webDriver.findElement(By.xpath("//*[@id=\"url\"]")).sendKeys("https://www.ibu.edu.ba/");
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/"
				+ "div[2]/div/div[2]/div/div/div/form/p[1]/input")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"lstc_subscribe\"]")).click();
		Thread.sleep(2000);
		
		
	}

}
