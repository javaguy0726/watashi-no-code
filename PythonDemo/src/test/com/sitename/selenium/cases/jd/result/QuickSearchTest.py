# -*- coding:UTF-8 -*-

'''
Created on 2012-12-21

@author: chengkai
'''
from test.com.sitename.selenium.base.SeleniumTestAbstract import SeleniumTestAbstract
from test.com.sitename.selenium.util.Selenium_Util import Selenium_Util
from test.com.sitename.selenium.cases.jd.pageutil.HomePage_Util import HomePage_Util
from test.com.sitename.selenium.cases.jd.pageutil.ResultPage_Util import ResultPage_Util
import unittest
import traceback


class QuickSeachTest(SeleniumTestAbstract):
    
    def testSearch(self):
        try:
            Selenium_Util.get("http://www.360buy.com/")
            Selenium_Util.waitForElementsToLoad(HomePage_Util.HOMEPAGE_BUTTON_SEARCH)
            Selenium_Util.sendKeys("12.12", Selenium_Util.findElement(HomePage_Util.HOMEPAGE_INPUT_SEARCH))
            Selenium_Util.click(Selenium_Util.findElement(HomePage_Util.HOMEPAGE_BUTTON_SEARCH))
            Selenium_Util.waitForElementsToLoad(ResultPage_Util.RESULTPAGE_SECTION_PRODUCTS)
            products_name =   Selenium_Util.findElements(ResultPage_Util.RESULTPAGE_LINK_PRODUCTS_NAME) 
            for name in products_name:
                print name.text
                self.assertTrue(name.text.startswith('京东12.12'), "Not Mathced")
                
        except:
            Selenium_Util.getScreensot("c:/screenshot.jpg")
            traceback.print_exc()
        
        

#def testSuite():
#    suite = unittest.TestSuite()
#    suite.addTest(QuickSeachTest("testSearch"))
#    return suite
#        
#        
#if __name__ == '__main__':
#    suite = testSuite()
#    runner = unittest.TextTestRunner()
#    runner.run(suite)