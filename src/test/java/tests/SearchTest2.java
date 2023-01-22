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

class SearchTest2 {

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
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div"
				+ "[2]/nav/ul[1]/li[7]/a")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.id("is-search-input-0")).sendKeys("development");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/"
				+ "nav/ul[1]/li[7]/form/button/span[2]")).click();
		Thread.sleep(4000);
		String url = webDriver.getCurrentUrl();
		assertEquals("https://www.atlantbh.com/?s=development", url);
		WebElement num = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]"
				+ "/div[1]/div[1]/div/div/div/div/span"));
		String search = num.getText();
		assertEquals("122 results found", search);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div"
				+ "/div/div/div[1]/article[2]/div/a/img")).click();
		Thread.sleep(2000);
		String url2 = webDriver.getCurrentUrl();
		assertEquals("https://www.atlantbh.com/making-peace-frontend-development-leveling-up-your-css/", url2);
		String text = webDriver.findElement(By.xpath("//*[@id=\"page-header-bg\"]/div[2]/div/div/div/h1")).getText();
		assertEquals("Making peace with frontend development: Leveling up your CSS", text);
		
		webDriver.navigate().back();
		Thread.sleep(1000);
		webDriver.navigate().back();
		Thread.sleep(1000);
	
		String url3 = webDriver.getCurrentUrl();
		assertEquals("https://www.atlantbh.com/", url3);
		
	}

}
