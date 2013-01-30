# -*- coding:UTF-8 -*-

'''
Created on 2012-12-18

@author: chengkai
'''

from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait 
from selenium.common.exceptions import ElementNotVisibleException
from selenium.webdriver.support.ui import Select
import time
import unittest
import os.path
import os


class SearchPoductsTest(unittest.TestCase):
    

    def setUp(self):
#        self.driver= webdriver.Chrome()
        self.driver= webdriver.Firefox()
        self.driver.get('http://www.360buy.com/')
        print 'preparing this test.'
   
    def tearDown(self):
        self.driver.quit()
        print 'end this test.'

    def testIFrame(self):
        
        WebDriverWait(self.driver, 20, 1, (ElementNotVisibleException)).until
        (lambda driver: driver.find_element_by_id('subscription-submit').is_displayed())
        
        trip_frame = self.driver.find_element_by_xpath("//iframe[@src]")
        self.driver.switch_to_frame(trip_frame)
        
        select_card_price = self.driver.find_element_by_xpath("//*[@id='traveltab']/li[3]")
        print select_card_price.text
        self.driver.switch_to_default_content()
    
    def testMutipleWindow(self):
        WebDriverWait(self.driver, 20, 1, (ElementNotVisibleException)).until
        (lambda driver: driver.find_element_by_id('subscription-submit').is_displayed())
        
        link = self.driver.find_element_by_xpath("//*[@id='jdnews']/div[2]/ul/li[2]/a")
        link.click()
        
        window_handles = self.driver.window_handles
        self.driver.switch_to_window(window_handles[1])
        print self.driver.title
    
    def testDropdown(self):
        WebDriverWait(self.driver, 20, 1, (ElementNotVisibleException)).until
        (lambda driver: driver.find_element_by_id('subscription-submit').is_displayed())
        
        trip_frame = self.driver.find_element_by_xpath("//iframe[@src]")
        self.driver.switch_to_frame(trip_frame)
        self.driver.find_element_by_xpath("//*[@id='traveltab']/li[2]").click()
        dropdown = Select(self.driver.find_element_by_id("hotel-city"))
        options = dropdown.options
        
        for option in options:
            print option.text
        
        self.driver.switch_to_default_content()
    
    def testPageWait(self):
        
        self.driver.implicitly_wait(20)
        trip_frame = self.driver.find_element_by_xpath("//iframe[@src]")
        self.driver.switch_to_frame(trip_frame)
        
        select_card_price = self.driver.find_element_by_xpath("//*[@id='traveltab']/li[3]")
        print select_card_price.text
        self.driver.switch_to_default_content()
        
    def testScreenshot(self):
        WebDriverWait(self.driver, 20, 1, (ElementNotVisibleException)).until
        (lambda driver: driver.find_element_by_id('subscription-submit').is_displayed())
        
        link = self.driver.find_element_by_xpath("//*[@id='jdnews']/div[2]/ul/li[2]/a")
        link.click()
        
        window_handles = self.driver.window_handles
        self.driver.switch_to_window(window_handles[1])
        
        WebDriverWait(self.driver, 20, 1, (ElementNotVisibleException)).until
        (lambda driver: driver.title.startswith('京东商城新闻'))

        print self.driver.title[:6]
        
        try:
            dir = 'c:/img'
            pic_name = '/pic-python.jpg'
            if os.path.isfile(dir+pic_name):
                os.remove(dir+pic_name)
            
            self.driver.get_screenshot_as_file(dir+pic_name)
        except:
            print "fail to get screenshot"
            raise
    
def testSuite():
    suite = unittest.TestSuite()
#    suite.addTest(SearchPoductsTest("testIFrame"))
#    suite.addTest(SearchPoductsTest("testMutipleWindow"))
#    suite.addTest(SearchPoductsTest("testDropdown"))
#    suite.addTest(SearchPoductsTest("testPageWait"))
    suite.addTest(SearchPoductsTest("testScreenshot"))
    return suite
        
        
if __name__ == '__main__':
#    unittest.main()
    suite = testSuite()
    runner = unittest.TextTestRunner()
    runner.run(suite)
