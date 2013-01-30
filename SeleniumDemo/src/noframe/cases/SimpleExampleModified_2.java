package noframe.cases;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.SeleneseTestBase;

public class SimpleExampleModified_2 {
	private WebDriver driver = null;
	private SeleneseTestBase testbase = null; 
	
	@BeforeClass
	public static void setUpBeforeClass(){
		System.out.println("before class.");
	}
	
	@Before
	public void setUpBeforeMethod() {
		driver=  new FirefoxDriver();
		testbase = new SeleneseTestBase();
		System.out.println("before @test method.");
	}
	
    @Test
	public void assert1212OnSales(){
   	    
        driver.get("http://www.360buy.com/");
        
        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("subscription-submit")).isDisplayed();
            }
        });
       
        //by id
        WebElement input_search = driver.findElement(By.id("key")); 
        
        // by xpath
        WebElement button_search = driver.findElement(By.xpath("//*[@id='search']//input[@type='button']"));
        
        //by class name
        WebElement branch_address_1 = driver.findElement(By.className("ar"));
//        System.out.println("by class name: "+branch_address_1.getText());
        
        // by css selector
        WebElement branch_address_2 = driver.findElement(By.cssSelector("p.ar"));
//        System.out.println("by css selector: "+branch_address_2.getText());
        
        // by link text
        WebElement about_us = driver.findElement(By.linkText("关于我们"));
//        System.out.println("by link text: "+about_us.getText());
        
        //by tag name
        WebElement jd_report = driver.findElement(By.id("jdnews")).findElement(By.tagName("h2"));
//        System.out.println("by tag name: "+jd_report.getText());

        input_search.sendKeys("12.12");

        button_search.click();

        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("plist")).isDisplayed();
            }
        });

        Assert.assertTrue(driver.getTitle().startsWith("12.12"));
        
        System.out.println("the 1st case");
	}

	@Test
	public void assert1212OnSales_2() {
		System.out.println("the 2nd case");
	}

	@After
	public void tearDownAfterMethod() {
		driver.quit();
		System.out.println("after @test method");
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("after class");
	}
    
}
