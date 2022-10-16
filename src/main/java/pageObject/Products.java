package pageObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.Actions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Products extends Actions {
	
	AndroidDriver driver;	
	
	
	public Products(AndroidDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}




	
	
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/productAddCart")
	private List<WebElement>  addToCard;
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/productName")
	private List<WebElement>  productNames;
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement  addBasket;

	@AndroidFindBy(id ="com.androidsample.generalstore:id/productPrice")
	private List<WebElement>  productprice;
	
	
	public void Findshoes(String shoesName) throws InterruptedException  {
		Swipe(shoesName);
	
		int productcount = productNames.size();

		for(int i =0;i<productcount;i++) {
		String productName = productNames.get(i).getText();

		if (productName.equalsIgnoreCase(shoesName)) {
		addToCard.get(i).click();
		}}
		
		
		Thread.sleep(1000);
		addBasket.click();
		
	}
	
	
	public void Prouductprice(String shoesName) throws InterruptedException {
		
		Swipe(shoesName);
		
		int productcount = productNames.size();

		for(int i =0;i<productcount;i++) {
		String productName = productNames.get(i).getText();

		if (productName.equalsIgnoreCase(shoesName)) {
	String proprice=productprice.get(i).getText();
	
	
	createTxtFile(proprice);
	Thread.sleep(2000);
	
		}}
		
	}
	
	

	

	}

