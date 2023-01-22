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

class ServicesTest {

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
		
		webDriver.findElement(By.linkText("Services")).click();
		
		Thread.sleep(3000);
		
		WebElement t = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/"
				+ "div[1]/div[1]/div/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[2]/h2"));
		String text1 = t.getText();
		
		assertEquals("Full solution - tailored to your needs", text1);
		
		String url1 = webDriver.getCurrentUrl();
		
		assertEquals("https://www.atlantbh.com/services/", url1);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/"
				+ "div[1]/div/div/div[4]/div[2]/div[2]/div/div[2]/div/div/a")).click();
		
		WebElement ds = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]"
				+ "/div[1]/div[1]/div/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/div/div[2]/h2"));
		String text2 = ds.getText();
		
		assertEquals("Data Science", text2);
		
		String url2 = webDriver.getCurrentUrl();
		
		assertEquals("https://www.atlantbh.com/service-data-science/", url2);
		
	}

}
