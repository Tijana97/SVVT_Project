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

class SlaaskTest {

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
		
		webDriver.findElement(By.xpath("//*[@id=\"cn-accept-cookie\"]")).click();
		Thread.sleep(3000);
		
		webDriver.findElement(By.xpath("/html/body/div[3]/div[2]")).click();
		Thread.sleep(3000);
		
		WebElement iframe = webDriver.findElement(By.cssSelector("#slaask-widget > iframe"));
		webDriver.switchTo().frame(iframe);
		
		String text = webDriver.findElement(By.xpath("//*[@id=\"slaask-whitelabel\"]/a")).getText();
		assertEquals("Powered by Slaask", text);
		
		webDriver.findElement(By.xpath("//*[@id=\"slaask-whitelabel\"]/a")).click();
		Thread.sleep(3000);
		
		webDriver.findElement(By.xpath("//*[@id=\"slaask-widget-view-about\"]/div/a")).click();
		
		Thread.sleep(3000);
		
		for (String handle : webDriver.getWindowHandles()) {
			if(!handle.equals(handle1)){
				webDriver.switchTo().window(handle);
				break;
			}
		}
		
		String url = webDriver.getCurrentUrl();
		assertEquals("https://get.slaask.com/?partner=a52163a3060be6a17cf7b72d9ca813e"
				+ "9&utm_source&utm_medium=livechat&utm_campaign=livechat-referral&company_name=Atlantbh", url);
		
	}

}
