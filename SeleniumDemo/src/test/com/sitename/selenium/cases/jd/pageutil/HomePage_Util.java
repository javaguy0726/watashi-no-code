package test.com.sitename.selenium.cases.jd.pageutil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import test.com.sitename.selenium.util.Selenium_Util;


public class HomePage_Util {
	   // elements locators
		public static final By HOMEPAGE_INPUT_SEARCH = By.id("key");
		public static final By HOMEPAGE_BUTTON_SEARCH = By.xpath("//*[@id='search']//input[@type='button']");
		public static final By HOMEPAGE_LINK_BRANCH_ADDRESS = By.cssSelector("p.ar");
		public static final By HOMEPAGE_LINK_NEWS = By.id("jdnews");
		public static final By HOMEPAGE_LINK_FAST_REPORTS = By.tagName("h2"); //sub search of HOMEPAGE_LINK_NEWS.
		
}
