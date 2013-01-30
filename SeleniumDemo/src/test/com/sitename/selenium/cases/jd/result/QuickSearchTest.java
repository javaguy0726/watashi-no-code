package test.com.sitename.selenium.cases.jd.result;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import test.com.sitename.selenium.base.SeleniumTestAbstract;
import test.com.sitename.selenium.cases.jd.pageutil.HomePage_Util;
import test.com.sitename.selenium.cases.jd.pageutil.ResultPage_Util;
import test.com.sitename.selenium.util.Selenium_Util;

public class QuickSearchTest extends SeleniumTestAbstract {

	@Test
	public void assert1212OnSales() {
		try{
		Selenium_Util.get("http://www.360buy.com/");
		Selenium_Util.waitForElementLoad(HomePage_Util.HOMEPAGE_BUTTON_SEARCH);
		Selenium_Util.sendKeys(Selenium_Util.findElement(HomePage_Util.HOMEPAGE_INPUT_SEARCH), "12.12");
		Selenium_Util.click(Selenium_Util.findElement(HomePage_Util.HOMEPAGE_BUTTON_SEARCH));
		Selenium_Util.waitForElementLoad(ResultPage_Util.RESULTPAGE_SECTION_PRODUCTS);
		List<WebElement> products_name = Selenium_Util.findElements(ResultPage_Util.RESULTPAGE_LINK_PRODUCTS_NAME);
		
		for(WebElement product: products_name){
			 Selenium_Util.assertTrue(product.getText().contains("12.12"));
	        }
		}
		catch(Exception e){
			Selenium_Util.getScreenShot(e);
		}
	}
}
