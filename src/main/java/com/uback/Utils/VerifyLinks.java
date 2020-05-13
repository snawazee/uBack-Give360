package com.uback.Utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyLinks {
    public static void main(String[] args) {
    	System.setProperty("webdriver.gecko.driver", "D://QA/geckodriver.exe");
    	WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize(); 
        driver.get("https://staging.mygive360.com/#!/login");
        List< WebElement > allLink = driver.findElements(By.tagName("a")); 
        System.out.println("Total links are " + allLink.size());
        for (int i = 0; i < allLink.size(); i++) {
        WebElement ele = allLink.get(i); 
        String url = ele.getAttribute("href"); 
        verifyLinkActive(url);
    }
}
    public static void verifyLinkActive(String linkurl) {
        try {
           URL url = new URL(linkurl);
           HttpURLConnection httpUrlConnect = (HttpURLConnection) url.openConnection(); 
           httpUrlConnect.setConnectTimeout(3000); 
           httpUrlConnect.connect();
           if (httpUrlConnect.getResponseCode() == 200) {
              System.out.println(linkurl + " - " + httpUrlConnect.getResponseMessage());
           }
              if (httpUrlConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
                  System.out.println(linkurl + " - " + httpUrlConnect.getResponseMessage() 
                                     + " - " + HttpURLConnection.HTTP_NOT_FOUND);
              }
       }
       catch (Exception e) {
       }
   }
}