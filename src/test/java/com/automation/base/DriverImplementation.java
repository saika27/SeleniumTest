package com.automation.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.automation.utilities.ExcelReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverImplementation {

	public static WebDriver driver = null;
	public static WebDriverWait wait ;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"//src//test//resources//excel//testdata.xlsx");
	
	
	public DriverImplementation()
	{
		this.driver= driver;
		
		
	}
	
	
	@BeforeSuite
	public void setUp()
	{
		if (driver==null){
			
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"//src//test/resources//properties//Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 try {
				fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//properties//OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if (config.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
		}
		else if (config.getProperty("browser").equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			
		}
		else if (config.getProperty("browser").equalsIgnoreCase("ie")){
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
			DesiredCapabilities capabilities= DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true );
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		}
		else if (config.getProperty("browser").equalsIgnoreCase("safari")){
			driver= new SafariDriver();
		}
		
		driver.get(config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@AfterSuite
	public void tearDown()
	{
		if(driver!=null){
		driver.quit();
		}
	}
	
	
}
