package headfirst.my.strategy;

public class WitchDoctor extends Hero {

	public WitchDoctor(){
		conBehav= new ConWithDrug();
		aoeBehav = null;
	}
	
	
	@Override
	public void info() {
		// TODO Auto-generated method stub
		System.out.println("I'm Witch Doctor.");
	}

}
