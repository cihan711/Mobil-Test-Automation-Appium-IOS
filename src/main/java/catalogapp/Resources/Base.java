package catalogapp.Resources;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base  {
	
	public IOSDriver driver;

	AppiumDriverLocalService service;	
	
	
	@BeforeClass
	public void ConfigureAppium() throws IOException {
		
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/catalogapp/Resources/data.properties");
		prop.load(fis);
		String ipAdress = prop.getProperty("ipAdress");
		String port = prop.getProperty("port");
		
		service= startAppiumServer(ipAdress,Integer.parseInt(port));
		//service.start();
		
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 12 Pro");
	    options.setApp(System.getProperty("user.dir") + "/src/test/java/IOS_App/UIKitCatalog.app");
	   // options.setApp("/Users/cihan/Desktop/AppiumCourse/Appium/src/test/java/resources/TestApp 3.app");
	    options.setPlatformVersion("15.5");
	    
	    //webdriver agent için timeout
	    options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		
		 driver = new IOSDriver(service.getUrl(), options);
		 
		 //Implicit wait
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
	}

	public AppiumDriverLocalService startAppiumServer(String ipAddress,int port) {
		
		service = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress(ipAddress).usingPort(port).build();
		
		return service;
	}
	

	
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
}
