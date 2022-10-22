package com.lucianobrito.infnet.qualityassurencebdd;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InfnetQualityAsurrenceBddApplicationTests {

	  private WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  
	  @BeforeEach
	  public void setUp() throws MalformedURLException {
	    driver = new 
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }
	  
	  @AfterEach
	  public void tearDown() {
	    driver.quit();
	  }
	  
	  @Test
	  public void testGoogleUsability() {
	    driver.get("https://www.google.com/");
	    //driver.manage().window().setSize(new Dimension(1324, 709));
	    driver.findElement(By.name("q")).click();
	    driver.findElement(By.name("q")).sendKeys("selenium");
	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	    driver.findElement(By.linkText("Schedule test automation")).click();
	    driver.findElement(By.cssSelector(".HalfImageSection_HalfImageSection__1gPG0:nth-child(2) .RoundedButton_RoundedButton__label__1EGOT")).click();
	  }

}
