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

public class Cart {
	WebDriver driver;
	@Given("^Lauch application url$")
	public void lauch_application_url() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	@Then("^Click on SamsunggalaxyS(\\d+)$") 
	public void click_on_SamsunggalaxyS(int arg1) throws Throwable {
	WebElement sam = driver.findElement(By.linkText("Samsung galaxy s6"));
	sam.click();
	}

	@When("^Click on AddtoCart$")
	public void click_on_AddtoCart() throws Throwable {
	WebElement clickaddcart = driver.findElement(By.linkText("Add to cart"));
	clickaddcart.click(); 
	Thread.sleep(300);
	driver.switchTo().alert().accept();
	
	}

	@Then("^Click Cart$")
	public void click_Cart() throws Throwable {
	WebElement cart = driver.findElement(By.linkText("Cart")); 
	cart.click();
	}

	@Then("^Verify item added in Cart$")
	public void verify_item_added_in_Cart() throws Throwable {
	boolean cartresult = driver.findElement(By.xpath("//td[text()='Samsung galaxy s6']")).isDisplayed();
	Assert.assertTrue(cartresult);
	
	Thread.sleep(300);
	driver.close();
	}

}
