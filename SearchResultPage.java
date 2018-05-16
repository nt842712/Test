package com.makemytrip.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	WebDriver driver;
	
public SearchResultPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//div[contains(@class,'modify_search')]/descendant::p[contains(@class,'modify_city_name')]")
private WebElement searchResultText;

@FindBy(xpath="//div[@id='sortingRow']/following-sibling::div[contains(@class,'listing_row')]")
private List<WebElement> searchResultList;

@FindBy(xpath="//div[@id='price_slider']/a")
private WebElement priceRangeSlider;

@FindBy(id="max_price")
private WebElement maxPrice;

public String getSearchResultText(){
	return searchResultText.getText();
}

public List<WebElement> getsearchResultList(){
	return searchResultList;
}

public WebElement getPriceSlider(){
	return priceRangeSlider;
}

public String getMaxPrice(){
	return maxPrice.getText();
}
}
