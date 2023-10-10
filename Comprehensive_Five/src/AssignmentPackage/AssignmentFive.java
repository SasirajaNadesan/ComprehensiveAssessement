package AssignmentPackage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentFive {
	public static WebDriver driver;

	@BeforeTest
	public void setupWebDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.automationanywhere.com/");
		System.out.println("Driver initiatlised and URL passed to Browser");
		System.out.println(driver.getTitle());
	}

	  @AfterTest 
	  public void closeWebDriver() 
	  { driver.quit();
	  System.out.println("Driver Closed");
	  }
	  
	 @Test (priority=1) 
	 public void verifyAutomationanywherelogo_present() {
	 Assert.assertTrue( driver.findElement(By.xpath("//div[@class='coh-row-inner coh-ce-cpt_aai_site_header-c6638c7f']/div[1]")).isDisplayed()); 
	 Assert.assertTrue( driver.findElement(By.xpath("//div[@class='coh-row-inner coh-ce-cpt_aai_site_header-c6638c7f']/div[1]")).isDisplayed()); 
	 System.out.println("Element is Displayed :"); 
	 }
	 
	 @Test (priority=1) 
	 public void verifyAcceptCookiePresenceAndClick() {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
			WebElement cookiesBtn = driver.findElement(By.id("onetrust-accept-btn-handler"));
			if (cookiesBtn.isDisplayed()) {
				cookiesBtn.click();
			}
	 }
		
	 @Test (priority=2) 
	 public void verifyEachLinkIsClickedk() {
		// Passing the expected elements to a String array list
		ArrayList<String> expectedElements = new ArrayList<String>();
		expectedElements.add("Products");
		expectedElements.add("Solutions");
		expectedElements.add("Resources");
		expectedElements.add("Beyond RPA");
		expectedElements.add("Company");

		// Passing the List of actual items to a Webelement list
		List<WebElement> allElements = driver.findElements(By.xpath(
				"//ul[@class='coh" + "-menu-list-container coh-unordered-list menu-level-1 coh-ce-646fa54d']/li/a"));
		for (WebElement element : allElements) {
			String actual = element.getText();
			if (expectedElements.contains(actual)) {
				System.out.println(actual + " conatains in " + expectedElements);
			}

		}
	 
	 }
	 }
