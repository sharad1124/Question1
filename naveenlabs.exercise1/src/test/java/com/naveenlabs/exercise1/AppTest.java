package com.naveenlabs.exercise1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AppTest {
	
public static WebDriver driver;
public static String driverPath = "/Users/sharadgupta/Documents/automation/naveenlabs.exercise1/chromedriver";


public static void main(String[] args) throws Exception {
    // Setting up Chrome driver path.
    System.setProperty("webdriver.chrome.driver", "/Users/sharadgupta/Documents/automation/naveenlabs.exercise1/chromedriver");
    // Launching Chrome browser.
    driver = new ChromeDriver();

    driver.get("https://www.zoopla.co.uk/");
    
    Thread.sleep(10000);
  
    //driver.findElement(By.xpath("//button[@class='ui-button-primary ui-cookie-accept-all-medium-large']"));
    driver.findElement(By.xpath("//button[@class='ui-button-secondary']")).click();
    Thread.sleep(5000);
    System.out.println("cookies clicked");
    
    driver.findElement(By.name("q")).sendKeys("london");
    Thread.sleep(10000);
    
  List <WebElement> list = driver.findElements(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content']//li[@class='ui-menu-item']"));

  System.out.println("Country list: " + list.size());
  Thread.sleep(5000);
  for(int i=0;i<list.size();i++) {
	  
	  String listitem = list.get(i).getText();
	  System.out.println("List Item : " + listitem);
	  if(listitem.contains("London")) {
		  list.get(i).click();
		  break;
	  }
	  
  }
  
    Thread.sleep(5000);
    driver.findElement(By.xpath("//button[@id='search-submit']")).click();
    Thread.sleep(5000);
    String getUrl = driver.getCurrentUrl();
    
    System.out.println("URL>>> : " + getUrl);
    
//    if(getUrl.contentEquals("londoan")) {
//    	
//    	Assert.assertEquals(true, getUrl);
//    	
//    }
       
//    List <WebElement> list1 = driver.findElements(By.xpath("//*[@id=\"content\"]/ul/li//div[@class='listing-results-right clearfix']/a"));
//
//    System.out.println("house list: " + list1.size());
//    
//    list1.get(5).click();
    
    Thread.sleep(5000);
    
    
    ArrayList<String> obtainedList = new ArrayList<>(); 
    List<WebElement> elementList= driver.findElements(By.xpath("//*[@id=\"content\"]/ul/li//div[@class='listing-results-right clearfix']/a"));
    for(WebElement we:elementList){
       obtainedList.add(we.getText());
       
       System.out.println("house list: " + we.getText());
    }
    ArrayList<String> sortedList = new ArrayList<>();   
    for(String s:obtainedList){
    sortedList.add(s);
    }
    Collections.sort(sortedList);
    System.out.println("list in sorted :>>>>> " + " " + "\n" + sortedList + "\n");
    
    elementList.get(4).click();
    
    
    //Assert.assertTrue(sortedList.equals(obtainedList));
    
//    for(int i=0;i<list1.size();i++) {
//    	
//    	  String listitem1 = list1.get(i).getText();
//    	  System.out.println("List Item amount: " + listitem1);
//    	  if(listitem1.contains("£350,000")) {
//    		  list1.get(i).click();
//    		  break;
//    	  }
//    	}
    Thread.sleep(5000);
    
    String getValue = driver.findElement(By.xpath("//article[@class='dp-sidebar-wrapper__summary']//div[@class='ui-pricing']")).getText();
    
    System.out.println("Amount:>>>>> " + getValue);
    
   String getName = driver.findElement(By.xpath("//div[@class='dp-sidebar-wrapper__contact']//div[@class='ui-agent__text']")).getText();
    
    System.out.println("Name:>>>>> " + getName);
    
 String getPhone = driver.findElement(By.xpath("//div[@class='dp-grid-wrapper']//p[@class='ui-agent__tel ui-agent__text']//a[1]")).getText();
    
    System.out.println("Phone Number:>>>>> " + getPhone);
    
    driver.findElement(By.xpath("//div[@class='dp-sidebar-wrapper__contact']//div[@class='ui-agent__text']")).click();
    Thread.sleep(5000);
  String getfullName = driver.findElement(By.xpath("//h1[@class='bottom-half']")).getText();
    
    System.out.println("Full Name:>>>>> " + getfullName);
    
    if(getName.equals(getfullName)) {
    	System.out.println("Both are same");
    	
    }
    else {
    	System.out.println("Both are not same");
    }
   	
    driver.quit();
    
}}




