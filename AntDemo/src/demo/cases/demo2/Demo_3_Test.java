package demo.cases.demo2;

import junit.framework.Assert;

import org.junit.Test;

import demo.abstr.DemoTestAbstract;

public class Demo_3_Test extends DemoTestAbstract{
	@Test
	public void testDemo3() {

		Assert.assertEquals(17, car.getWheelbase());
		
	}
}
