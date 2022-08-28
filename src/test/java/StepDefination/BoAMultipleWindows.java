package StepDefination;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BoAMultipleWindows  {
	WebDriver driver;
	
	@Given("^Lauch BOFA application url$")
	public void lauch_BOFA_application_url() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.bankofamerica.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
	}

	@Then("^Click on Home Loans Link$")
	public void click_on_Home_Loans_Link() throws Throwable {
	WebElement homelink = driver.findElement(By.xpath("/html/body/div[1]/div/div/section[2]/div/div/div[1]/div[1]/div/nav/ul/li[4]/a/span[3]"));
	homelink.click();
	Thread.sleep(1000);
	}

	@When("^Click on Find a home Link$")
	public void click_on_Find_a_home_Link() throws Throwable {
	WebElement findhome = driver.findElement(By.linkText("Find a home"));
	findhome.click();
	Thread.sleep(1000); 
	}

	@Then("^Click on New Construction$")
	public void click_on_New_Construction() throws Throwable {
	WebElement newconstruction = driver.findElement(By.name("home_37"));
	newconstruction.click();
	Thread.sleep(1000);
	}

	@Then("^Verify user can see new construction homes$")
	public void verify_user_can_see_new_construction_homes() throws Throwable {
		
	Set <String> window = driver.getWindowHandles();
	Iterator <String> ite = window.iterator();
	String mainwindow = ite.next();
	String secondwindow = ite.next();
	driver.switchTo().window(secondwindow);
	System.out.println("We are in second window");
	
	WebDriverWait wait = new WebDriverWait(driver, 20);// command for explicity wait
	
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("newHomes")))); // waintfor upto 20 sec untill new home is clickable
	
	boolean	verifyresult = driver.findElement(By.id("newHomes")).isEnabled();
	Assert.assertTrue(verifyresult);
	Thread.sleep(2000);
	driver.quit();
	}
	

}
