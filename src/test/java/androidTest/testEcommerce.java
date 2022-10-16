package androidTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ecommerceapp.Resources.Base;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import pageObject.Basket;
import pageObject.LoginApp;
import pageObject.Products;

public class testEcommerce extends Base {
	
	
	
	@Test(priority = 1)
	public void Login() throws IOException, InterruptedException {
		
		LoginApp log = new LoginApp(driver);
		log.ChooseCountry("Antarctica");
		log.Name();
		log.Gender();
		
		log.GoProductpage();
		Thread.sleep(2000);
		
		
		

}
	
	@Test(priority = 2)
	public void productList() throws InterruptedException {
		
		Products pro = new Products(driver);
		pro.Prouductprice("Converse All Star");
		pro.Findshoes("Converse All Star");
		Thread.sleep(2000);
		
	
	}
	

	
	@Test(priority = 3)
	public void Basketpage() throws InterruptedException, IOException {
		
		Basket bs = new Basket(driver);
		bs.PageControl();
		bs.CheckBox();
		bs.TermsButton();	
		bs.BasketPrice();
		Thread.sleep(1000);
		bs.Purchase();
		Thread.sleep(2000);
		
		
		
		
	}

}
