package demo.cases.demo2;

import junit.framework.Assert;

import org.junit.Test;

import demo.abstr.DemoTestAbstract;

public class Demo_1_Test extends DemoTestAbstract{
	@Test
	public void testDemo1() {

		Assert.assertEquals(42011888, person.getId());
		
	}
}
