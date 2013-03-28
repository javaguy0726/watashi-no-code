package headfirst.my.strategy;

public abstract class Hero {

	CONBehavior conBehav;
	AOEBehavior aoeBehav;

	public Hero() {

	}

	public  void attack(){
		System.out.println("attack!");
	}

	public  void stand(){
		System.out.println("Stand!");
	}

	public void hold(){
		System.out.println("Hold!");
	}

	public void performCON() {
		if(conBehav==null){
			System.out.println("This hero doesn't has this skill.");
			return;
		}
		conBehav.control();
	}

	public void performAOE() {
		if(aoeBehav==null){
			System.out.println("This hero doesn't has this skill.");
			return;
		}
		aoeBehav.areaDamage();
	}
	
	public abstract void info();
	
	public void setCONBehavior(CONBehavior conB){
		this.conBehav = conB;
	}
	public void setAOEBehavior(AOEBehavior aoeB){
		this.aoeBehav=aoeB;
	}
	
}
