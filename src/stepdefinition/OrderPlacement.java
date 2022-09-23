package stepdefinition;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.interactions.Actions;
import org.junit.*;
import driverSetup.driversetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderPlacement {

	driversetup ds = new driversetup();

	@Given("User Navigated to Website")
	public void user_navigated_to_website() {

		System.out.println("Navigating to our Website");
		ds.open_chrome();

	}
	
	
	@Given("User is logged in")
	public void user_loggedin() throws Exception {
		String usercred = "suyeta_patra1234";

		ds.open_chrome();
		System.out.println("User logging in ");
		ds.get_driver().findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
		Thread.sleep(2000);
		ds.get_driver().findElement(By.xpath("//input[@id='loginusername']")).sendKeys(usercred);
		Thread.sleep(2000);
		ds.get_driver().findElement(By.xpath("//input[@id='loginpassword']")).sendKeys(usercred);
		Thread.sleep(2000);
		ds.get_driver().findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		
		
		String Expected = ds.get_driver().findElement(By.xpath("//a[@id='nameofuser']")).toString().replaceAll(" ", "").replaceAll("Welcome", "");
		//Asserting if user is logged in 
		Assert.assertEquals(Expected,usercred);
		Thread.sleep(4000);
	}

	@When("Click on {string} Category and add {string} to Cart")
	public void category_cart(String Category, String ProductName) throws InterruptedException {

		System.out.println("Clicking on Category");
		Thread.sleep(4000);
		ds.get_driver().findElement(By.xpath("//a[contains(text(),'" + Category + "')]")).click();
		Thread.sleep(2000);
		System.out.println("Clicking on Product Name as " + ProductName);
		ds.get_driver().findElement(By.xpath("//a[contains(text(),'" + ProductName + "')]")).click();
		Thread.sleep(2000);

		//Asserting if user is logged in to proper Product
		String Expected = ds.get_driver().findElement(By.xpath("//h2[@class='name']")).toString().replaceAll(" ", "");
		Assert.assertEquals(Expected,ProductName);
		
		
		String price = ds.get_driver().findElement(By.xpath("//h3[@class='price-container']")).getText();
		System.out.println("Price of Product " + ProductName + " is " + price);
		ds.get_driver().findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();

		// pressing escape
		try {
			// Add to cart
			Thread.sleep(4000);
			Alert alert = ds.get_driver().switchTo().alert();
			String alertText = alert.getText();
			System.out.println("Alert data: " + alertText);
			alert.accept();

			Actions action = new Actions(ds.get_driver());
			action.sendKeys(Keys.ESCAPE).build().perform();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

		Thread.sleep(2000);

		ds.get_driver().findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
		Thread.sleep(2000);

	}

	@Then("Product {string} should be added to cart and Order must be placed")
	public void orderplacment(String ProductName) throws Exception {
		//Asserting if product is traversed properly to cart
		String Expected = ds.get_driver().findElement(By.xpath("//tr[@class='success']/td[2]")).getText();
		Assert.assertEquals(Expected, ProductName);
		
		
		
		
		
		ds.get_driver().findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		Thread.sleep(2000);

		ds.get_driver().findElement(By.xpath("//input[@id='name']")).sendKeys("Suyeta");
		ds.get_driver().findElement(By.xpath("//input[@id='country']")).sendKeys("India");
		ds.get_driver().findElement(By.xpath("//input[@id='city']")).sendKeys("Mumbai");
		ds.get_driver().findElement(By.xpath("//input[@id='card']")).sendKeys("44444444444");
		ds.get_driver().findElement(By.xpath("//input[@id='month']")).sendKeys("12");
		ds.get_driver().findElement(By.xpath("//input[@id='year']")).sendKeys("2022");

		ds.get_driver().findElement(By.xpath("//button[contains(text(),'Purchase')]")).click();
		Thread.sleep(2000);
	
		
		String ExpectedName = ds.get_driver().findElement(By.xpath("")).getText();
		Assert.assertEquals(ExpectedName, ProductName);
		
		
		Thread.sleep(2000);
		ds.get_driver().findElement(By.xpath("//button[contains(text(),'OK')]")).click();

		ds.close_chrome();
	}

}
