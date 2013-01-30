# -*- coding:UTF-8 -*-

'''
Created on 2012-12-16

@author: Administrator
'''
from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait 
import time
from selenium.common.exceptions import ElementNotVisibleException


def main():
    try:
#        driver= webdriver.Chrome()
        driver= webdriver.Firefox()
        
        driver.get('http://www.360buy.com/')
     
        WebDriverWait(driver, 20, 1, (ElementNotVisibleException)).until
        (lambda driver: driver.find_element_by_id('subscription-submit').is_displayed())
     
        input_search = driver.find_element_by_id('key');
        button_search = driver.find_element_by_xpath("//*[@id='search']//input[@type='button']")
        input_search.send_keys("12.12")
        button_search.click()
    
        WebDriverWait(driver, 20, 1, (ElementNotVisibleException)).until
        (lambda driver: driver.find_element_by_xpath("//*[@id='plist']").is_displayed())
    
        products_name = driver.find_elements_by_xpath("//*[@id='plist']//li/div[2]")
        
        for name in products_name:
            print name.text
   
    finally:
        driver.quit()

if __name__ == '__main__':
    main()
    
