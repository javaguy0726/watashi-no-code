package noframe.cases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.SeleneseTestBase;

public class Solutions {
	private WebDriver driver = null;
	private SeleneseTestBase testbase = null; 
	
	@Before
	public void setUpBeforeMethod() {
		driver=  new FirefoxDriver();
		testbase = new SeleneseTestBase();
	}
	
//    @Test
	public void assertIframe(){
   	    
        driver.get("http://www.360buy.com/");
        
        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("subscription-submit")).isDisplayed();
            }
        });
       
        WebElement trip_frame = driver.findElement(By.xpath("//iframe[@src]")); 
       
        driver.switchTo().frame(trip_frame);
        
        WebElement select_card_price = driver.findElement(By.xpath("//*[@id='traveltab']/li[3]")); 
        System.out.println(select_card_price.getText());
        driver.switchTo().defaultContent();
	}
    
//    @Test
    public void assertPopups(){
   	    
        driver.get("http://www.360buy.com/");
        
        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("subscription-submit")).isDisplayed();
            }
        });
       
        WebElement link = driver.findElement(By.xpath("//*[@id='jdnews']/div[2]/ul/li[2]/a")); 
       
        link.click();
        
       Set<String> window_handles = driver.getWindowHandles();
       Iterator<String> ite = window_handles.iterator();
       ite.next();
       driver.switchTo().window(ite.next());
       System.out.println(driver.getTitle());
	}

//    @Test
	public void assertDropdown() {

		driver.get("http://www.360buy.com/");

		(new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.id("subscription-submit"))
						.isDisplayed();
			}
		});

		WebElement trip_frame = driver.findElement(By.xpath("//iframe[@src]"));

		driver.switchTo().frame(trip_frame);

		driver.findElement(By.xpath("//*[@id='traveltab']/li[2]")).click();
		
		Select city_inhabit = new Select(driver.findElement(By.id("hotel-city")));
		
		
		List<WebElement> options = city_inhabit.getOptions();
		
		for(WebElement element: options){
			System.out.println(element.getText());
		}
		
		driver.switchTo().defaultContent();
	}

//    @Test
	public void assertPageWait() {

		driver.get("http://www.360buy.com/");

		// implicity wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement trip_frame = driver.findElement(By.xpath("//iframe[@src]"));

		driver.switchTo().frame(trip_frame);

		driver.findElement(By.xpath("//*[@id='traveltab']/li[2]")).click();
		
		Select city_inhabit = new Select(driver.findElement(By.id("hotel-city")));
		
		List<WebElement> options = city_inhabit.getOptions();
		
		for(WebElement element: options){
			System.out.println(element.getText());
		}
		
		driver.switchTo().defaultContent();
	}
    
    @Test
    public void assertScreenshot() {
    	
         driver.get("http://www.360buy.com/");
        
        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("subscription-submit")).isDisplayed();
            }
        });
       
        WebElement link = driver.findElement(By.xpath("//*[@id='jdnews']/div[2]/ul/li[2]/a")); 
       
        link.click();
        
       Set<String> window_handles = driver.getWindowHandles();
       Iterator<String> ite = window_handles.iterator();
       ite.next();
       driver.switchTo().window(ite.next());
       
       (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
           public Boolean apply(WebDriver d) {
               return d.getTitle().startsWith("京东商城新闻");
           }
       });
       
       File pic = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       try {
		FileUtils.copyFile(pic, new File("C:/img/screenshot.jpg"));
	   } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
    }
    
	@After
	public void tearDownAfterMethod() {
		driver.quit();
	}
    
}
