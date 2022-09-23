package stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;

import driverSetup.driversetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage {
	
	driversetup ds = new driversetup();
	String HomeProductExpected = "";
	String LaptopFirstProduct = "Sony vaio i5";
	String CartAssert = "Place Order";
	String MonitorsProduct = "Apple monitor 24";
	
	
	
	@Given("User Navigated to Website after browser initialisation")
	public void homePage() {
		ds.open_chrome();
	}

	@When("Click on {string} Category")
	public void click_on_category(String PageClick) throws Exception {
		
		String Expected_ProductAssert = "";

		ds.get_driver().findElement(By.xpath("//a[contains(text(),'" + PageClick + "')]")).click();
		Thread.sleep(3000);

		// assert if traversed to proper Categorry
		if (PageClick.equalsIgnoreCase("Laptop")) {
			String ActualAssert = ds.get_driver().findElement(By.xpath("(//a[@class='hrefch'])[1]")).getText();
			Expected_ProductAssert = LaptopFirstProduct;
			
			// assert if Traversed to page properly by verifying text of Pages
			Assert.assertEquals(Expected_ProductAssert, ActualAssert);

		}

		else if (PageClick.equalsIgnoreCase("Monitors")) {
			String ActualAssert = ds.get_driver().findElement(By.xpath("(//a[@class='hrefch'])[1]")).getText();
			Expected_ProductAssert = MonitorsProduct;
			Assert.assertEquals(Expected_ProductAssert, ActualAssert);
		}

		else if (PageClick.equalsIgnoreCase("cart")) {
			String ActualAssert = ds.get_driver().findElement(By.xpath("//button[contains(text(),'Place Order')]"))
					.getText();
			Expected_ProductAssert = CartAssert;
			Assert.assertEquals(Expected_ProductAssert, ActualAssert);
		}

	}

	@Then("Click on Home Page Button")
	public void HomePage() throws InterruptedException {
		ds.get_driver().findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		Thread.sleep(2000);
		HomeProductExpected="Samsung galaxy s6";
		String ActualAssert = ds.get_driver().findElement(By.xpath("(//a[@class='hrefch'])[1]")).getText();
		
		//Assert home page traverse by checking Product which was present on homepage
		Assert.assertEquals(HomeProductExpected, ActualAssert);
		ds.close_chrome();
	    
	}

}
