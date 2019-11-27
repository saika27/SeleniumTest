package com.automation.testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.automation.base.DriverImplementation;
import com.automation.utilities.TestUtil;

public class SearchVideos extends DriverImplementation{

	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void SearchText(String searchString) throws InterruptedException
	{
		//clicking on Video tab if no prior search performedTestIsElementPresent present = new TestIsElementPresent();
		if(isElementPresent(By.xpath(OR.getProperty("VideoLogo")))){
			
		driver.findElement(By.xpath(OR.getProperty("VideoLogo"))).click();
		System.out.println("Clicking on video button from Home Page");
		
		clickButton(searchString);
		
		
		
		
		
		
		
			
		}
		else if(isElementPresent(By.xpath(OR.getProperty("VideoTab"))))
		{
			driver.findElement(By.xpath(OR.getProperty("VideoTab"))).click();
			clickButton(searchString);
			
			
		}
        else if (isElementPresent(By.xpath(OR.getProperty("SrchBoxVid")))){
			
        	clickButton(searchString);
			
		}
		
		}
	
	public void clickButton(String searchString) throws InterruptedException{
		driver.findElement(By.xpath(OR.getProperty("SrchBoxVid"))).clear();
		driver.findElement(By.xpath(OR.getProperty("SrchBoxVid"))).sendKeys(searchString);
		
		driver.findElement(By.xpath(OR.getProperty("VideoBtn"))).click();
		Thread.sleep(1000);
		System.out.println("Displaying Video results for keyword "+" '"+searchString+"'");
	}
		
		
	}
	
