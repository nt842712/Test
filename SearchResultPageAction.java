package com.makemytrip.action;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.makemytrip.pom.SearchResultPage;

public class SearchResultPageAction {

	public static boolean verifySearchResult(WebDriver driver, SearchResultPage search, String fromCity, String toCity){
		
		List<WebElement> searchResultList=search.getsearchResultList();
		if(searchResultList.size()>0){
		
		for (int i=1;i<=searchResultList.size();i++){
	      
			String fromContainer=driver.findElement(By.xpath("//div[@id='sortingRow']/following-sibling::div[contains(@class,'listing_row')]["+i+"]/div/div[2]/div[3]")).getText();
			String toContainer=driver.findElement(By.xpath("//div[@id='sortingRow']/following-sibling::div[contains(@class,'listing_row')]["+i+"]/div/div[2]/div[4]")).getText();
	      
			if(fromContainer.contains(fromCity)){
				if(toContainer.contains(toCity)){
					continue;
				}else{
					System.out.println("To City, doesn't match with search record : "+i);
					return false;
				}
			}else{
				System.out.println("From City, doesn't match with search record : "+i);
				return false;
			}
	    }
		
		}else{
			System.out.println("No any Search Result Found...");
		}
		return true;
	}
	
	public static void adjustPriceSlider(WebDriver driver, SearchResultPage search){
		//Actions move = new Actions(driver);
       // Action action = (Action) move.dragAndDropBy(search.getPriceSlider(), 30, 0).build();
       // action.perform();
		WebElement slider=search.getPriceSlider();
		double range=6000;
        String maxPrice=search.getMaxPrice().replaceAll(",", "");
        double maxpriceNum=Double.parseDouble(maxPrice);
        System.out.println(maxpriceNum);
        if(maxpriceNum>6000){
        	for (int i = 1; maxpriceNum>6000 ; i++) {
                slider.sendKeys(Keys.ARROW_LEFT);
            }
        }else{
        for (int i = 1; maxpriceNum<6000 ; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        }
	}
}
