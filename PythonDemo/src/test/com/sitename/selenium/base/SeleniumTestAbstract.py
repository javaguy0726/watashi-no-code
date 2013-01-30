'''
Created on 2012-12-23

@author: Administrator
'''
import unittest
from test.com.sitename.selenium.util.Selenium_Util import Selenium_Util


class SeleniumTestAbstract(unittest.TestCase):
    def setUp(self):
        Selenium_Util.startBowser()
        Selenium_Util.implicityWait()
    
    def tearDown(self):
        Selenium_Util.quit()

