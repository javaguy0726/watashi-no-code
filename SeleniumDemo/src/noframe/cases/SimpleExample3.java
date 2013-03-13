package noframe.cases;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class SimpleExample3 implements Serializable {
	private WebDriver driver;
	private JavascriptExecutor js;
	private WebDriver driver2;
	public SimpleExample3(RemoteWebDriver driver) {
		this.driver = driver;
	}

	public static void setSystemProperties() {
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "c:\\IEDriverServer.exe");
	}

	public static void main(String[] args) {
		SimpleExample3 example2 = null;
		try {
			setSystemProperties();
			example2 = new SimpleExample3(new ChromeDriver());
			example2.js = (JavascriptExecutor) example2.driver;
			example2.driver.get("http://www.baidu.com/");
			URL jqueryUrl = Resources.getResource("jquery-1.8.3.js");
			String jqueryText = Resources.toString(jqueryUrl, Charsets.UTF_8);
			example2.js.executeScript(jqueryText);
			example2.driver2 = example2.clone(example2.driver);
			System.out.println(example2.driver2==example2.driver);
			
			example2.js = (JavascriptExecutor) example2.driver2;
			
			String jsript = "return $(\"#kw\").val('aaaaaaaaaa')";
			example2.js.executeScript(jsript);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			example2.driver.quit();
		}
	}
	
	 private WebDriver clone(WebDriver driver) {   
	        ByteArrayOutputStream byteOut = null;   
	        ObjectOutputStream objOut = null;   
	        ByteArrayInputStream byteIn = null;   
	        ObjectInputStream objIn = null;   
	           
	        try {   
	            byteOut = new ByteArrayOutputStream();    
	            objOut = new ObjectOutputStream(byteOut);    
	            objOut.writeObject(driver);   
	  
	            byteIn = new ByteArrayInputStream(byteOut.toByteArray());   
	            objIn = new ObjectInputStream(byteIn);   
	               
	            return (WebDriver) objIn.readObject();   
	        } catch (IOException e) {   
	            throw new RuntimeException("Clone Object failed in IO.",e);      
	        } catch (ClassNotFoundException e) {   
	            throw new RuntimeException("Class not found.",e);      
	        } finally{   
	            try{   
	                byteIn = null;   
	                byteOut = null;   
	                if(objOut != null) objOut.close();      
	                if(objIn != null) objIn.close();      
	            }catch(IOException e){      
	            }      
	        }   
	    }   
}
