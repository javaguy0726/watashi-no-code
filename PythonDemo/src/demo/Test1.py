'''
Created on 2012-12-23

@author: Administrator
'''
class Test1:
    
    def __init__(self):
        self.a = "";
    
#    def __init__(self, name):
#        self.a = name;
    
#    def method1(self):
#        print 'method1'

    def method1(self,name="123"):
        print name;

test1 = Test1();
#test2 = Test1()
#
#test1.a.append(1)
#test2.a.append(2)

print test1.method1();
