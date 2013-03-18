package headfirst.my.strategy;

public class TwinHeadDragon extends Hero {

	public TwinHeadDragon(){
		conBehav= new ConWithIce();
		aoeBehav=new AoeWithFire();
	}
	
	@Override
	public void info() {
		// TODO Auto-generated method stub
		System.out.println("I'm twin head dragon.");
	}

	

}
