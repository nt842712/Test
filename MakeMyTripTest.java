package com.makemytrip.test;

import java.util.Date;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.makemytrip.action.SearchResultPageAction;
import com.makemytrip.action.homePageAction;
import com.makemytrip.pom.HomePage;
import com.makemytrip.pom.SearchResultPage;

public class MakeMyTripTest {
	WebDriver driver;
	WebDriverWait wait;
	HomePage home;
	SearchResultPage search;
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "C://Users//pupatel//Downloads//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
  }

  @SuppressWarnings("deprecation")
@Test(priority=1)
  public void f() {
	  driver.get("https://www.makemytrip.com");
	  wait = new WebDriverWait(driver, 10);
	  home=new HomePage(driver);
	  
	 // wait.until(ExpectedConditions.elementToBeClickable(home.departDate));
	  //home.clickDepartDate();
	  //String date="2-Jul-2018";
	//homePageAction.selectDepartDate(date);
	  String fromCity="Ahmedabad";
	  String toCity="Cochin";
	  home.clickPassengerField();
	  homePageAction.selectPassenger("2","1","Premium Economy",home, driver);
	  home.clickSearchButton();
	  
	  search=new SearchResultPage(driver);
	 // System.out.println(fromCity+" to "+toCity);
	  Assert.assertEquals("Search Result is not as per selected Route...", fromCity+" to "+toCity, search.getSearchResultText());
  }
  
  @Test(priority=2)
  public void checkResult(){
	  
	  boolean searchFlag=SearchResultPageAction.verifySearchResult(driver, search,"Ahmedabad","Cochin");
	  
	  Assert.assertTrue("Search result for any one/more records, looks not valid", searchFlag);
  }
  @Test(priority=3)
  public void adjustPrice(){
	  
	  SearchResultPageAction.adjustPriceSlider(driver, search);
  }
  
  @AfterClass
  public void afterClass() {
  }

}
