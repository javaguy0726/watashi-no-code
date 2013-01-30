package demo.cases.demo1;

import junit.framework.Assert;

import org.junit.Test;

import demo.abstr.DemoTestAbstract;

public class Demo_1_Test extends DemoTestAbstract{
	@Test
	public void testDemo1() {

		Assert.assertEquals("mitsubishi", car.getBrand());
		
	}
}
