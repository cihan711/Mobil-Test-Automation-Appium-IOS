package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AlertViewsPage {
	
	
IOSDriver driver;
	
	public   AlertViewsPage (IOSDriver driver) {
		
		
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	} 
	
	@iOSXCUITFindBy(iOSNsPredicate = "label == \"Alert Views\"")
	private WebElement openAlert;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")
	private WebElement textEntryMenu;
	
	
	@iOSXCUITFindBy(iOSNsPredicate = "label == 'Confirm / Cancel'")
	private WebElement confirmMenuItem;
	
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell")
	private WebElement textBox;
	
	@iOSXCUITFindBy(accessibility = "OK")
	private WebElement acceptPopup;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'A message'")
	private WebElement confirmMessage;
	
	
	@iOSXCUITFindBy(iOSNsPredicate = "label == 'Confirm'")
	private WebElement submit;
	
	@iOSXCUITFindBy(xpath  = "//XCUIElementTypeButton[@name=\"UIKitCatalog\"]")
	private WebElement backhome;
	
	
	public void OpenAlerts() {
		
		openAlert.click();
	}
	
	public void AlertfillTextLabel( String name) {
		
		textEntryMenu.click();
		textBox.sendKeys(name);
		acceptPopup.click();
	}
	
	public String AlertgetConfirmMessage() {
		
		confirmMenuItem.click();
		return confirmMessage.getText();
	}
	
	public void AlertSubmit() throws InterruptedException {
		
		submit.click();
		Thread.sleep(1000);
		backhome.click();
		
	}
	
	
	
	

	
}
