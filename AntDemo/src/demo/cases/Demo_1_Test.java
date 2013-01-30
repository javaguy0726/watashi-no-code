package demo.cases;

import junit.framework.Assert;

import org.junit.Test;

import demo.abstr.DemoTestAbstract;

public class Demo_1_Test extends DemoTestAbstract {
	@Test
	public void testDemo1() {

		Assert.assertEquals("jordan", person.getName());
		
	}
}


