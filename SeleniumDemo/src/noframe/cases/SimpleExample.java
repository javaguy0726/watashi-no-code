package noframe.cases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.SeleneseTestBase;

public class SimpleExample {
	public static void main(String[] args) {
		
		WebDriver driver=  new ChromeDriver();
        driver.get("http://www.360buy.com/");
        
        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("subscription-submit")).isDisplayed();
            }
        });
       
        WebElement input_search = driver.findElement(By.id("key"));
        
        WebElement button_search = driver.findElement(By.xpath("//*[@id='search']//input[@type='button']"));

        input_search.sendKeys("12.12");

        button_search.click();

        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("plist")).isDisplayed();
            }
        });
        
        List<WebElement> products_name = driver.findElements(By.xpath("//div[@id='plist']//li/div[2]"));
        for(WebElement product: products_name){
        	System.out.println(product.getText());
        }
        driver.quit();
	}
}
