package demo.abstr;

import org.junit.After;
import org.junit.Before;

import demo.entity.Car;
import demo.entity.Person;

public class DemoTestAbstract {
	protected Person person = null;
	protected Car car = null;

	@Before
	public void setUp() {
		person = new Person(42011888, "jordan", "male", 23);
		car = new Car("lancer", "mitsubishi", 2.0f, 17, false);
	}

	@After
	public void tearDown() {

	}
	
}
