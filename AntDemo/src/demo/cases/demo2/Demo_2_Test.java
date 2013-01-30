package demo.cases.demo2;

import junit.framework.Assert;

import org.junit.Test;

import demo.abstr.DemoTestAbstract;

public class Demo_2_Test extends DemoTestAbstract{
	@Test
	public void testDemo2() {

		Assert.assertEquals("lancer", car.getModel());
		
	}
}
