package StepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class About {
	WebDriver driver;
	
	@Given("^Lauch application(\\d+) url$")
	public void lauch_application_url(int arg1) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();   
	}
	@Then("^Click on About us link$")
	public void click_on_About_us_link() throws Throwable {
	WebElement aboutus = driver.findElement(By.linkText("About us"));
	aboutus.click();
	Thread.sleep(3000);
	}
	@Then("^Verify About page dispaly$")
	public void verify_About_page_dispaly() throws Throwable {
	boolean validation1 = driver.findElement(By.xpath("//h5[text()='About us']")).isDisplayed();
	Assert.assertTrue(validation1);
	Thread.sleep(3000);
	driver.close();
	}

}
