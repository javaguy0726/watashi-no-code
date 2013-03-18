package headfirst.my.strategy;

public class Nina extends Hero {

	public Nina(){
		aoeBehav = new AoeWithFire();
		conBehav = new ConWithFire();
	}
	
	@Override
	public void info() {
		// TODO Auto-generated method stub
		System.out.println("I'm Nina Impulse.");
	}

}
