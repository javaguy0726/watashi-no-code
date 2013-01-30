package test.com.sitename.selenium.base;


import org.junit.After;
import org.junit.Before;

import test.com.sitename.selenium.util.Selenium_Util;


public class SeleniumTestAbstract {
	@Before
	public void setUpBeforeClass() {
		Selenium_Util.startWebDriver();
//		Selenium_Util.maximize();
		Selenium_Util.implicitlyWait();
//		Selenium_Util.pageLoadTimeout();
		
	}
    @After
	public void tearDownAfterClass() {
		Selenium_Util.quit();
    	
	}
}
