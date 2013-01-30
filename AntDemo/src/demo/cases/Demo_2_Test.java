package demo.cases;

import junit.framework.Assert;

import org.junit.Test;

import demo.abstr.DemoTestAbstract;

public class Demo_2_Test extends DemoTestAbstract{
	@Test
	public void testDemo2() {

		Assert.assertFalse("Expected Turbo is true; Actual is false",car.isTurbo());
	}
}
