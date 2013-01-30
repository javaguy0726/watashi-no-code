package test.com.sitename.selenium.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.thoughtworks.selenium.SeleneseTestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.com.sitename.selenium.base.SeleniumUtilAbstract;

public class Selenium_Util extends SeleniumUtilAbstract {

	
	private static final int IMPLICITLY_WAIT = 30; // 30 second
	private static final int PAGE_TIMEOUT = 60; // 60 second
	
	private static SeleneseTestBase testbase = null;
	private static WebDriver driver = null;
	private static Actions actions = null;
	
	public static final WebDriver startWebDriver(){
		 driver = loadDriver("chrome");
		 actions = new Actions(driver);
		 testbase = new SeleneseTestBase();
		 return driver;
	}
	
	private enum IsMethod {
		IS_ENABLED, IS_DISPLAYED, IS_SELECTED
	}
	
	private static WebDriver loadDriver(String browser) {
		if (browser != "" && "ie".equals(browser)) {
			System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			return new InternetExplorerDriver(capabilities);
			}
		else if (browser != "" && "firefox".equals(browser))
			return new FirefoxDriver();
		
		else if (browser != "" && "safari".equals(browser)) {
			return new SafariDriver();
		
		} else if (browser != "" && "chrome".equals(browser)){
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			return new ChromeDriver();
		}
		
		return new FirefoxDriver();
	}

	private static final boolean isExecuted(Enum isMethod, WebElement element) {
		long timer = 0;
		while (true) {
			try {
				if ((IsMethod.IS_ENABLED.equals(isMethod) && element
						.isEnabled())
						|| (IsMethod.IS_DISPLAYED.equals(isMethod) && element
								.isDisplayed())
						|| (IsMethod.IS_SELECTED.equals(isMethod) && element
								.isSelected())) {
					return true;
				} else {
					Thread.sleep(DEFAULT_WAIT);
				}
			} 
			  catch (Exception e) {
			}
			timer += DEFAULT_WAIT;
			if (timer > DEFAULT_TIMEOUT) {
				break;
			}
		}
		return false;
	}

	public static final void get(String baseUrl) {
		driver.get(baseUrl);
	}

	public static final void quit() {
		driver.quit();
	}
	
	public static final void close() {
		driver.close();
	}
	
	public static void waitForElementLoad(By by) {
		final By locator = by;
		(new WebDriverWait(driver, IMPLICITLY_WAIT))
		        .withMessage("More than" + IMPLICITLY_WAIT+ " seconds that required elelment not loaded.")
				.until(new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver d) {
						return d.findElement(locator).isDisplayed();
					}
				});
	}
	
	public static final WebElement findElement(By by) {
		return driver.findElement(by);
	}
	
	public static final WebElement findElement(WebElement element, By by) {
		return element.findElement(by);
	}
	
	public static final By xPath(String xpath) {
		return  By.xpath(xpath);
	}
	
	public static final Actions moveToElement(WebElement toElement) {
		return actions.moveToElement(toElement);
	}
	
	public static final Actions contextClick(WebElement toElement) {
		return actions.contextClick(toElement);
	}
	
	public static final void perform(Actions action) {
		action.perform();
	}
	
	public static final void hold(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static final By linkText(String link) {
		return  By.linkText(link);
	}
	
	public static final By iD(String id) {
		return  By.id(id);
	}
	
	public static final By className(String className) {
		return  By.className(className);
	}
	
	public static final List<WebElement> findElements(By by) {
		return driver.findElements(by);
	}
	
	public static final List<WebElement> findElements(WebElement element, By by) {
		return element.findElements(by);
	}
	
	public static final String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public static final String getPageSource() {
		return driver.getPageSource();
	}
	
	public static final void navigateTo(String url) {
		 driver.navigate().to(url);
	}

	public static final String getTitle() {
		return driver.getTitle();
	}

	public static final WebDriver.Options manage() {
		return driver.manage();
	}
	
	public static final WebDriver window(String handle) {
		return driver.switchTo().window(handle);
	}

	public static final void maximize() {
		driver.manage().window().maximize();
	}

	public static final void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);
	}
	
	public static final void pageLoadTimeout() {
		driver.manage().timeouts().pageLoadTimeout(PAGE_TIMEOUT, TimeUnit.SECONDS);
	}

	public static final void sendKeys(WebElement element, String keys) {
		element.sendKeys(keys);
	}

	public static final void clear(WebElement element) {
		element.clear();
	}

	public static final void click(WebElement element) {
		element.click();
	}
	
	public static final void actionsClick(WebElement element) {
		actions.click(element).perform();
	}
	
	public static final void submit(WebElement element) {
		element.submit();
	}
	
	public static final String getAttribute(WebElement element, String name) {
		return element.getAttribute(name);
	}
	
	public static final String getWindowHandle() {
		return driver.getWindowHandle();
	}
	
	public static final Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}
	
	public static final void selectByVisibleText(Select select, String text){
		select.selectByVisibleText(text);
	}
	
	public static final boolean isDisplayed(WebElement element) {
		return isExecuted(IsMethod.IS_DISPLAYED, element);
	}

	public static final boolean isEnabled(WebElement element) {
		return isExecuted(IsMethod.IS_ENABLED, element);
	}

	public static final boolean isSelected(WebElement element) {
		return isExecuted(IsMethod.IS_SELECTED, element);
	}

	public static final void waitPageToLoad(WebElement element) {
	       assertTrue(isDisplayed(element));		
		}
	
	/**Like JUnit's Assert.assertEquals, compare two objects */
	public static final void assertEquals(Object expected, Object actual) {
		SeleneseTestBase.assertEquals(expected, actual);
	}

	/**Like JUnit's Assert.assertEquals, compare two strings */
	public static final void assertEquals(String expected, String actual) {
		SeleneseTestBase.assertEquals(expected, actual);
	}

	/**Like JUnit's Assert.assertEquals, compare two string arrays */
	public static final void assertEquals(String[] expected, String[] actual) {
		SeleneseTestBase.assertEquals(expected, actual);
	}
	
	/**Like JUnit's Assert.assertTrue, if true then pass*/
	public static final void assertTrue(boolean condition) {
		SeleneseTestBase.assertTrue(condition);
	}
	
	/**Like JUnit's Assert.assertTrue with message, if true then pass*/
	public static final void assertTrue(String message, boolean condition) {
		SeleneseTestBase.assertTrue(message, condition);
	}
	
	/**Like JUnit's Assert.assertFalse, if false then pass*/
	public static final void assertFalse(boolean condition) {
		SeleneseTestBase.assertFalse(condition);
	}

	/**Asserts that two boolean values are not the same*/
	public static final void assertNotEquals(boolean expected, boolean actual) {
		SeleneseTestBase.assertNotEquals(expected, actual);
	}

	/**Asserts that two objects are not the same*/
	public static final void assertNotEquals(Object expected, Object actual) {
		SeleneseTestBase.assertNotEquals(expected, actual);
	}

	/**Like assertEquals, but fails at the end of the test (during tearDown)*/
	public static final void verifyEquals(Object expected, Object actual) {
		testbase.verifyEquals(expected, actual);
	}

	/**Like assertEquals, but fails at the end of the test (during tearDown)*/
	public static final void verifyEquals(boolean expected, boolean actual) {
		testbase.verifyEquals(expected, actual);
	}
	
	/**Like assertFalse, but fails at the end of the test (during tearDown)*/
	public static final void verifyFalse(boolean actual) {
		testbase.verifyFalse(actual);
	}

	/**Like assertTrue, but fails at the end of the test (during tearDown)*/
	public static final void verifyTrue(boolean actual) {
		testbase.verifyTrue(actual);
	}

	/**Like assertNotEquals, but fails at the end of the test (during tearDown)*/
	public static final void verifyNotEquals(Object expected, Object actual) {
		testbase.verifyNotEquals(expected, actual);
	}
	
	public static void getScreenShot(Exception e) {
		 getScreenShot();
		 throw new WebDriverException(e);
	}
	
	private static void getScreenShot() {
		Calendar date = Calendar.getInstance();
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH);
		int day = date.get(Calendar.DATE);
		int hour = date.get(Calendar.HOUR);
		int min = date.get(Calendar.MINUTE);
		int sec = date.get(Calendar.SECOND);
		int msec = date.get(Calendar.MILLISECOND);
		String today = "" + year + "" + month + "" + day + "" + hour + "" + min
				+ "" + sec + "" + msec;
		String path = "c:/img";
		File screenshot = null;
		if (!(driver instanceof TakesScreenshot)) {
			WebDriver augmentDriver = new Augmenter().augment(driver);
			screenshot = ((TakesScreenshot) augmentDriver).getScreenshotAs(OutputType.FILE);
		} else
			screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileInputStream fis;

		try {
			File dic = new File(path);
			fis = new FileInputStream(screenshot);
			if (!dic.exists() && !dic.isDirectory()) {
				dic.mkdir();
			}
			File caseDic = new File(path + "/" + getRunningCaseName() + "/");
			fis = new FileInputStream(screenshot);
			if (!caseDic.exists() && !caseDic.isDirectory()) {
				caseDic.mkdir();
			}
			FileOutputStream fos = new FileOutputStream(path + "/"
					+ getRunningCaseName() + "/" + today + ".png");

			FileChannel fcin = fis.getChannel();
			FileChannel fcout = fos.getChannel();
			fcin.transferTo(0, fcin.size(), fcout);
			fcin.close();
			fcout.close();
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** get name of the current running case*/
	private static String getRunningCaseName() {
		StackTraceElement stack[] = (new Throwable()).getStackTrace();
		String casename = "";
		for (int i = 0; i < stack.length; i++) {
			String temp = stack[i].getClassName();
			if (temp.endsWith("Test")) {
				casename = temp;
				break;
			}
	   }
	   casename=casename.substring(casename.lastIndexOf(".")+1);
	   return casename;
	}
}
