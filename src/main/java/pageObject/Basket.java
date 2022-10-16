package pageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utils.Actions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Basket extends Actions {
	
	AndroidDriver driver;	
	
	
	public Basket(AndroidDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}




	
	
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/toolbar_title")
	private WebElement  pagecontrol;
	
	@AndroidFindBy(className ="android.widget.CheckBox")
	private WebElement  checkbox;
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/termsButton")
	private WebElement  termsbutton;
	
	@AndroidFindBy(id ="android:id/button1")
	private WebElement  close;
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/productPrice")
	private WebElement  basketprice;
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/productPrice")
	private WebElement  productprice;
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement  addBasket;
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/btnProceed")
	private WebElement  purchase;

	
	
	public void PageControl()  {
		
		
		Assert.assertEquals(pagecontrol.getText(), "Cart");
		
	}
	

	public void CheckBox()  {
		
		
		checkbox.click();
		
		
	}
	
public void TermsButton () throws InterruptedException  {
		
		
	Longpress2(termsbutton);
	Thread.sleep(1000);
	close.click();
		
	}

public void Purchase() throws InterruptedException  {
	
	
	
	purchase.click();
	Thread.sleep(1000);
	
	
}
	
public void BasketPrice() throws IOException {
	
	
	String bsprice = basketprice.getText();
	
	Assert.assertEquals(bsprice, readTxtFile());
	 System.out.println("Prices are true!");
}
	


	}

