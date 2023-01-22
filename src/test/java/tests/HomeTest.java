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

class HomeTest {

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
		
		WebElement header1 = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div/"
				+ "div/div[1]/div[2]/div[1]/div/div[2]/div/div/h1[1]"));
		String text1 = header1.getText();
		
		assertEquals("We Make Things", text1);
		
		WebElement num = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div"
				+ "/div/div[4]/div[2]/div[1]/div/div[2]/div/div/h2"));
		String text2 = num.getText();
		
		assertEquals("Atlantbh in numbers", text2);
		Thread.sleep(3000);
		
		webDriver.findElement(By.name("fields[email]")).sendKeys("example@gmail.com");
		Thread.sleep(3000);
		
		WebElement header2 = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div/div/div[7]/"
				+ "div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div/h4"));
		String text3 = header2.getText();
		
		assertEquals("Stay in the Atlantbh loop", text3);
		
		String url = webDriver.getCurrentUrl();
		assertEquals("https://www.atlantbh.com/", url);
		
	}

}
