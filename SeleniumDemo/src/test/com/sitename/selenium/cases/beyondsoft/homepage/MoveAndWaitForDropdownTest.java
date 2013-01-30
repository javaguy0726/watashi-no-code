package test.com.sitename.selenium.cases.beyondsoft.homepage;

import org.junit.Test;

import test.com.sitename.selenium.base.SeleniumTestAbstract;
import test.com.sitename.selenium.cases.beyondsoft.pageutil.HomePage_Util;
import test.com.sitename.selenium.util.Selenium_Util;

public class MoveAndWaitForDropdownTest extends SeleniumTestAbstract{
	@Test
	public void testMouseMove() {
		try{
		Selenium_Util.get("http://www.beyondsoft.com");
		Selenium_Util.waitForElementLoad(HomePage_Util.HOMEPAGE_MENU_RESOURCES);
		Selenium_Util.perform(Selenium_Util.contextClick(Selenium_Util.findElement(HomePage_Util.HOMEPAGE_MENU_RESOURCES)));
//		Selenium_Util.perform(Selenium_Util.moveToElement(Selenium_Util.findElement(HomePage_Util.HOMEPAGE_MENU_RESOURCES)));
		Selenium_Util.click(Selenium_Util.findElement(HomePage_Util.HOMEPAGE_MENU_RESOURCES));
		Selenium_Util.hold(5000);
		} catch (Exception e) {
			Selenium_Util.getScreenShot(e);
		}
	}
}
