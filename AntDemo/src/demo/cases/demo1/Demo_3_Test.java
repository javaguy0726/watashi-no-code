package demo.cases.demo1;

import junit.framework.Assert;

import org.junit.Test;

import demo.abstr.DemoTestAbstract;

public class Demo_3_Test extends DemoTestAbstract{
	@Test
	public void testDemo3() {

		Assert.assertEquals(23, person.getAge());
		
	}
}
