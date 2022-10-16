package Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObject.LoginApp;



public class Actions   {

	
	AndroidDriver driver;

public Actions (AndroidDriver driver) {
		
		
		
		this.driver = driver;
		

		}
	
	public void Swipe(String value) {
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+value+"\"));"));
		
	}
	
	
	
	
	public void Longpress() {
		
		
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(), "duration",2000
			));
	}
	
	public void Longpress2(WebElement ele) {
		
		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(), "duration",2000
			));
	}
	
	
	public void createTxtFile(String value) {
		
		
		try {
		      FileWriter myWriter = new FileWriter("variables.txt");
		      myWriter.write(value);
		      myWriter.write(" ");
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		      
		    } 
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
	}
	
	
	public String readTxtFile() throws IOException {
		
		FileReader fr = new FileReader("variables.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        line = br.readLine();
        String[] arrayLine=line.split("\\s+");
         String   price1 = arrayLine[0];
         return price1;
	}
}

