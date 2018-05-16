package com.makemytrip.action;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.makemytrip.pom.HomePage;

public class homePageAction {

	public static void selectDepartDate(String date){
		
		//String[] data=date.split("-");
		//System.out.println(data[0].toString());
		
	}
	
	public static void selectPassenger(String adult, String child, String classVal, HomePage home, WebDriver driver){
		
		List<WebElement> adultSelectionList=home.getAdultSelectionList();
		for (WebElement adultVal : adultSelectionList){
	        String val = adultVal.getText();
	        if (val.equals(adult)) {
	            adultVal.click();
	        }
	    }
		
		List<WebElement> childSelectionList=home.getchildSelectionList();	
		for (WebElement childVal : childSelectionList){
	        String val = childVal.getText();
	        if (val.equals(child)) {
	        	childVal.click();
	        }
	    }
		
		WebElement selectedClass=driver.findElement(By.xpath(String.format(home.classSelect, classVal)));
		new Actions(driver).click(selectedClass).perform();
		
		home.clickDone();
		
	}
}
