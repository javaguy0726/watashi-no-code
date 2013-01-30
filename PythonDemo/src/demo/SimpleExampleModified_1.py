# -*- coding:UTF-8 -*-

'''
Created on 2012-12-18

@author: chengkai
'''

from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait 
from selenium.common.exceptions import ElementNotVisibleException
import time



def main():
    try:
#        driver= webdriver.Chrome()
        driver= webdriver.Firefox()
        
        driver.get('http://www.360buy.com/')
     
        WebDriverWait(driver, 20, 1, (ElementNotVisibleException)).until
        (lambda driber: driver.find_element_by_id('subscription-submit').is_displayed())
#     by id
        input_search = driver.find_element_by_id('key');
#     by xpath
        button_search = driver.find_element_by_xpath("//*[@id='search']//input[@type='button']")
#     by class name  
        branch_address_1 = driver.find_element_by_class_name("ar")
        print 'by class name: '+branch_address_1.text
#     by css selector
        branch_address_2 = driver.find_element_by_css_selector("p.ar")
        print 'by css selector: '+branch_address_2.text
#     by link text  
        about_us = driver.find_element_by_link_text('关于我们')
        print 'by link text: ' + about_us.text
#     by tag name  
        jd_report = driver.find_element_by_id("jdnews").find_element_by_tag_name("h2")
        print 'by tag name: ' + jd_report.text
        
        input_search.send_keys("12.12")
        button_search.click()
      
        WebDriverWait(driver, 20, 1, (ElementNotVisibleException)).until
        (lambda driver: driver.find_element_by_xpath("//*[@id='plist']").is_displayed())
    except:
        print 'has an error!'
        raise
    finally:
        driver.quit()

if __name__ == '__main__':
    main()
    
