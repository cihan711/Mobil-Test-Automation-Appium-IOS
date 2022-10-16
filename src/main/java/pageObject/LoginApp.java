package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.Actions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginApp  extends Actions  {

	AndroidDriver driver;
	
	public LoginApp(AndroidDriver driver) {
		
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

		}
	
	@AndroidFindBy(id  ="android:id/text1")
	private  WebElement findCountry;
	
	
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/nameField")
	private  WebElement  name;
	
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/radioFemale")
	private  WebElement  gender;
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/btnLetsShop")
	private  WebElement  proceedButon;
	
	
	
	public void ChooseCountry(String country) {
		findCountry.click();
		Swipe(country);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();
		
	}
	
	public void Name() {
		name.sendKeys("Elif");
	}
	
	public void Gender() {
		gender.click();
	}
	
	public void GoProductpage() {
		proceedButon.click();
	}
}
