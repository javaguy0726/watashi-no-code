package noframe.cases;

import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.thoughtworks.selenium.Selenium;

public class SimpleExample2 {
	private WebDriver driver;
	private JavascriptExecutor js;
	public SimpleExample2(RemoteWebDriver driver){
		this.driver = driver;
	}
	
	public static void setSystemProperties(){
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "c:\\IEDriverServer.exe");
	}
	
	public static void main(String[] args) {
		SimpleExample2 example2 = null;
		
		try {
		     setSystemProperties();
		     example2 = new SimpleExample2(new ChromeDriver());
		     example2.js= (JavascriptExecutor) example2.driver;
		     example2.driver.get("http://www.baidu.com/");
		     URL jqueryUrl = Resources.getResource("jquery-1.8.3.js");
		     String jqueryText = Resources.toString(jqueryUrl, Charsets.UTF_8);
		     example2.js.executeScript(jqueryText);
		     
		     String jsript = "return $(\"#kw\").val('aaaaaaaaaa')";
		     example2.js.executeScript(jsript);
		     Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			example2.driver.quit();
		}
	}
}
