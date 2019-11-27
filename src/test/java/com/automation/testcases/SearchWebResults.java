package com.automation.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.automation.base.DriverImplementation;
import com.automation.utilities.TestUtil;

public class SearchWebResults extends DriverImplementation {
	

	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void SearchText(String searchString) throws InterruptedException{
		
		//clicking on search text box
		if(TestIsElementPresent.isElementPresent(By.xpath(OR.getProperty("SrchBoxMain")))){
		driver.findElement(By.xpath(OR.getProperty("SrchBoxMain"))).sendKeys(searchString);
		
		Thread.sleep(2000);
		//clicking on search button
		driver.findElement(By.xpath(OR.getProperty("SrchBtn"))).click();
		System.out.println("Displaying web results for keyword "+" '"+searchString+"'");
		
		Thread.sleep(1000);
		}
		else if (TestIsElementPresent.isElementPresent(By.xpath(OR.getProperty("SrchBoxVid")))){
			
			driver.findElement(By.xpath(OR.getProperty("SrchBoxVid"))).clear();
			driver.findElement(By.xpath(OR.getProperty("SrchBoxVid"))).sendKeys(searchString);
			driver.findElement(By.xpath(OR.getProperty("VideoBtn"))).click();
			
			System.out.println("Displaying web results for keyword "+" '"+searchString+"'");
		}
		
	}
	

	
	
}
