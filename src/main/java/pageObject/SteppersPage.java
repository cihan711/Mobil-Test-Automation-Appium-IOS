package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SteppersPage {
	
IOSDriver driver;
	
	public   SteppersPage (IOSDriver driver) {
		
		
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	} 
	
	
	@iOSXCUITFindBy(iOSNsPredicate = "label == \"Steppers\"")
	private WebElement openSteppers;

	
	@iOSXCUITFindBy(xpath  = "(//XCUIElementTypeButton[@name=\"Increment\"])[1]")
	private WebElement defaultincrement;
	
	@iOSXCUITFindBy(xpath  = "(//XCUIElementTypeButton[@name=\"Increment\"])[2]")
	private WebElement tindetincrement;
	
	@iOSXCUITFindBy(xpath  = "(//XCUIElementTypeButton[@name=\"Increment\"])[3]")
	private WebElement customincrement;
	
	
	
	public void OpenStepper() {
		
		openSteppers.click();
	}
	
	public void Increments() throws InterruptedException {
		
		defaultincrement.click();
		Thread.sleep(1000);
		tindetincrement.click();
		Thread.sleep(1000);
		customincrement.click();
		
	}
}
