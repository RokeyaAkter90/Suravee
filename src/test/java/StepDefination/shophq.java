package StepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class shophq {
	WebDriver driver;
	@Given("^Launche application url$")
	public void launche_application_url() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	    
	}

	@When("^user searches invicta watch$")
	public void user_searches_invicta_watch() throws Throwable {
		WebElement sam1 = driver.findElement(By.id("twotabsearchtextbox"));
		sam1.sendKeys("helmet");
	
	}

	@When("^Click on search button$")
	public void click_on_search_button() throws Throwable {
		WebElement search1 = driver.findElement(By.id("nav-search-submit-button"));
		search1.click();
				
	}
	@Then("^user able to see invicta watches$")
	public void user_able_to_see_invicta_watches() throws Throwable {
		boolean helmet1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div[3]/div[2]/h2")).isDisplayed();
		Assert.assertTrue(helmet1);
		Thread.sleep(3000);
		driver.close();
	}



}
