package IOSTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import catalogapp.Resources.Base;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import pageObject.AlertViewsPage;
import pageObject.SteppersPage;


public class testUIKit extends Base {
	
	
	
	@Test(priority = 1)
	public void AlertViews() throws IOException, InterruptedException {
		
	
		AlertViewsPage hm= new AlertViewsPage(driver);
		hm.OpenAlerts();
		Thread.sleep(1000);
		hm.AlertfillTextLabel("hello world");
		Thread.sleep(1000);
		System.out.println(hm.AlertgetConfirmMessage());
		hm.AlertSubmit();

}
	
	@Test(priority = 2)
	public void Steppers() throws InterruptedException {
		SteppersPage st = new SteppersPage(driver);
		st.OpenStepper();
		Thread.sleep(1000);
		st.Increments();
		
	}

	
	


		
		
		
		
	}


