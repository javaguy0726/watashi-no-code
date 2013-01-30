package noframe.cases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleExampleModified_1 {
	public static void main(String[] args) {
		WebDriver driver=  new FirefoxDriver();
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
        System.out.println("by class name: "+branch_address_1.getText());
        
        // by css selector
        WebElement branch_address_2 = driver.findElement(By.cssSelector("p.ar"));
        System.out.println("by css selector: "+branch_address_2.getText());
        
        // by link text
        WebElement about_us = driver.findElement(By.linkText("关于我们"));
        System.out.println("by link text: "+about_us.getText());
        
        //by tag name
        WebElement jd_report = driver.findElement(By.id("jdnews")).findElement(By.tagName("h2"));
        System.out.println("by tag name: "+jd_report.getText());
        
        input_search.sendKeys("12.12");

        button_search.click();

        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("plist")).isDisplayed();
            }
        });
        
        List<WebElement> products_name = driver.findElements(By.xpath("//div[@id='plist']//li/div[2]"));
        for(WebElement product: products_name){
//        	System.out.println(product.getText());
        }
        driver.quit();
	}
	
}
