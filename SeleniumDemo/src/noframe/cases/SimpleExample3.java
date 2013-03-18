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

class MyDriver extends ChromeDriver implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}

public class SimpleExample3{
	private WebDriver driver;
	private WebDriver driver2;
	private JavascriptExecutor js1;
	private JavascriptExecutor js2;

	public SimpleExample3(WebDriver driver) {
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
			example2 = new SimpleExample3(new MyDriver());
			example2.js1 = (JavascriptExecutor) example2.driver;
			example2.driver.get("http://www.baidu.com/");

			URL jqueryUrl = Resources.getResource("jquery-1.8.3.js");
			String jqueryText = Resources.toString(jqueryUrl, Charsets.UTF_8);
			example2.js1.executeScript(jqueryText);

			example2.driver2 = example2.clone(example2.driver);
			System.out.println(example2.driver2 == example2.driver);
			
			
			example2.js1 = (JavascriptExecutor) example2.driver2;
			String jsript = "return $(\"#kw\").val('aaaaaaaaaa')";
			example2.js1.executeScript(jsript);
			Thread.sleep(5000);
			
			example2.js2 = (JavascriptExecutor) example2.driver2;
			String jsript2 = "return $(\"#kw\").val('bbbbbbbbbb')";
			example2.js2.executeScript(jsript);
			Thread.sleep(5000);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			example2.driver.quit();
		}
	}

	public MyDriver clone(WebDriver driver) {
		
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

			return (MyDriver)objIn.readObject();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Clone Object failed in IO.", e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Class not found.", e);
		} finally {
			try {
				byteIn = null;
				byteOut = null;
				if (objOut != null)
					objOut.close();
				if (objIn != null)
					objIn.close();
			} catch (IOException e) {
			}
		}
	}
}
