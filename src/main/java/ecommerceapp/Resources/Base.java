package ecommerceapp.Resources;

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
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base  {
	
	public AndroidDriver driver;
	//public FormPage formpage;
	AppiumDriverLocalService service;
	
	@BeforeClass(alwaysRun = true)
	public void ConfigureAppium() throws IOException {
		
		
	    //Prop file dan oku
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//ecommerceapp//Resources//data.properties");
		prop.load(fis);
		String ipAdress = prop.getProperty("ipAdress");
		String port = prop.getProperty("port");
		
		service= startAppiumServer(ipAdress,Integer.parseInt(port));
		
		//service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		
		options.setDeviceName(prop.getProperty("AndroidDeviceName"));
		options.setChromedriverExecutable("/Users/cihan/Documents/chromedriver");
	    
	
		
		//E-Commerce APP
		options.setApp(System.getProperty("user.dir")+ "//src//test//java//allapp//apps//General-Store.apk");
		
		 driver = new AndroidDriver(service.getUrl(), options);
		 
		 //Implicit wait
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//  formpage = new FormPage(driver);
	}
	

	public AppiumDriverLocalService startAppiumServer(String ipAddress,int port) {
		
		service = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress(ipAddress).usingPort(port).build();
		
		return service;
	}

	
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		
		driver.quit();
	}
}
