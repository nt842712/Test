package com.makemytrip.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(id="hp-widget__depart")
	public WebElement departDate;
	
	@FindBy(id="hp-widget__paxCounter_pot")
	public WebElement passengerField;
	
	@FindBy(xpath="//div[@class='dateFilter hasDatepicker' and contains(@style,'block;')]/descendant::a[@title='Prev']")
	public WebElement prevButton;
	
	@FindBy(xpath="//ul[@id='js-adult_counter']/li")
	private List<WebElement> adultCountsList;
	
	@FindBy(xpath="//ul[@id='js-child_counter']/li")
	private List<WebElement> childCountsList;
	
	public static final String classSelect="//div[@id='pot_class']/descendant::span[text()='%s']";
	
	@FindBy(xpath="//div[@id='pot_class']/descendant::a[text()='Done']")
	private WebElement doneLink;
	
	@FindBy(id="searchBtn")
	private WebElement searchButton;
	
	public HomePage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickDepartDate(){
		departDate.click();
	}

	public void clickPassengerField(){
		passengerField.click();
	}
	public List<WebElement> getAdultSelectionList(){
		return adultCountsList;
	}
	public List<WebElement> getchildSelectionList(){
		return childCountsList;
	}
	public void clickDone(){
		doneLink.click();
	}
	public void clickSearchButton(){
		searchButton.click();
	}
}
