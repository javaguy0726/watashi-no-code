'''
Created on 2012-12-21

@author: chengkai
'''

from selenium.webdriver.support.ui import WebDriverWait 
from selenium.common.exceptions import ElementNotVisibleException
from selenium.webdriver.support.ui import Select
from selenium import webdriver
import string
import unittest
import os
from test.com.sitename.selenium.base.SeleniumUtilAbstract import SeleniumUtilAbstract
import traceback

class Selenium_Util(unittest.TestCase ,SeleniumUtilAbstract):
    
    IMPLICITLY_WAIT = 30
    PAGE_TIMEOUT = 60
    
    __driver = None
    
    __selenium = None
    
    @classmethod
    def startBowser(cls):
        cls.__driver = Selenium_Util.__loadDriver("firefox")
        
        return cls.__driver
  
    @classmethod
    def __loadDriver(cls,browser_name):
        if ("" != browser_name and "ie"==browser_name):
            return webdriver.Ie()
        elif ("" != browser_name and "firefox" == browser_name):
            return webdriver.Firefox()
        elif ("" != browser_name and "chrome"==browser_name):
            return webdriver.Chrome()
        else:
            return webdriver.Firefox()
    
    @classmethod
    def get(cls, url):
        cls.__driver.get(url)
    
    @classmethod
    def waitForElementsToLoad(cls, locator):   #pass xpath as the argument
        WebDriverWait(cls.__driver, cls.IMPLICITLY_WAIT, 1, (ElementNotVisibleException)).until(lambda driver: driver.find_element_by_xpath(locator).is_displayed())
    
    @classmethod
    def sendKeys(cls, keyword, element):   
        element.send_keys(keyword)
        
    @classmethod
    def click(cls, element):   
        element.click()
    
    @classmethod
    def findElement(cls, locator):   #pass xpath as the argument
        return cls.__driver.find_element_by_xpath(locator)
        
    @classmethod
    def findElements(cls,locator):   #pass xpath as the argument
        return cls.__driver.find_elements_by_xpath(locator)
    
    @classmethod
    def implicityWait(cls):  
        cls.__driver.implicitly_wait(cls.IMPLICITLY_WAIT)

    @classmethod
    def quit(cls):  
        cls.__driver.quit()

    @classmethod
    def getScreensot(cls, path):  
        try:
            if os.path.isfile(path):
                os.remove(path)
            cls.__driver.get_screenshot_as_file(path)
        except:
            traceback.print_exc()
        
