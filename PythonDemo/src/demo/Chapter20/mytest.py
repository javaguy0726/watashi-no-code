# -*- coding:UTF-8 -*- 
'''
Created on 2013-1-21

@author: chengkai
'''
import fileinput;

def main():
    for line in fileinput.input("test_input.txt"):
        print line+'\n'
    
    
# This is the standard boilerplate that calls the main() function.
if __name__ == '__main__':
  main()
