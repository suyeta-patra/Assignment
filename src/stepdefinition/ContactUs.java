package stepdefinition;

import org.openqa.selenium.By;

import driverSetup.driversetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUs {
	driversetup ds = new driversetup();
	
	@Given("User Navigated to Website initally")
	public void user_navigated_to_website_initally() {
		ds.open_chrome();
	}

	@When("Click Contact")
	public void click_contact() throws Exception {
	  Thread.sleep(2000);
	   ds.get_driver().findElement(By.xpath("//a[contains(text(),'Contact')]")).click();
	   Thread.sleep(2000);
	}

	@Then("Enter email , name and Message and send mail and Send Message")
	public void enterDetails() {
		ds.get_driver().findElement(By.xpath("//input[@id='recipient-email']")).sendKeys("xyz@gmail.com");
		ds.get_driver().findElement(By.xpath("//input[@id='recipient-name']")).sendKeys("Suyeta Patra");
		ds.get_driver().findElement(By.xpath("//textarea")).sendKeys("This is a testing message.....");
	    ds.close_chrome();
	}
	
	
	
}
