# -*- coding:UTF-8 -*-

'''
Created on 2012-12-18

@author: chengkai
'''

from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait 
from selenium.common.exceptions import ElementNotVisibleException
import time
import unittest

class SearchPoductsTest(unittest.TestCase):
    
    def setUp(self):
#        driver= webdriver.Chrome()
        self.driver= webdriver.Firefox()
        print 'run before test.'
   
    def tearDown(self):
        self.driver.quit()
        print 'run after test.'

    def testProductsNameEqual(self):
        
        self.driver.get('http://www.360buy.com/')
        WebDriverWait(self.driver, 20, 1, (ElementNotVisibleException)).until
        (lambda driber: self.driver.find_element_by_id('subscription-submit').is_displayed())
        initiate = self.initiateElement
        initiate()
        self.input_search.send_keys("12.12")
        self.button_search.click()
       
        WebDriverWait(self.driver, 20, 1, (ElementNotVisibleException)).until
        (lambda driber: self.driver.find_element_by_xpath("//*[@id='plist']").is_displayed())

        products_name = self.driver.find_elements_by_xpath("//*[@id='plist']//li/div[2]")
        
        for name in products_name:
            print name.text
            self.assertTrue(name.text.startswith('京东12.12'))
    
    def initiateElement(self):
    #     by id
        self.input_search = self.driver.find_element_by_id('key');
    #     by xpath
        self.button_search = self.driver.find_element_by_xpath("//*[@id='search']//input[@type='button']")

if __name__ == '__main__':
    unittest.main()
#    test = SearchPoductsTest("testProductsNameEqual")
#    runner = unittest.TextTestRunner()
#    runner.run(test)
