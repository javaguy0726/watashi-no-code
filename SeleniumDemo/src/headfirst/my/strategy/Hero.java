package headfirst.my.strategy;

public abstract class Hero {
 
	CONBehavior conBehav;
	AOEBehavior aoeBehav;
	
	public Hero(){
		
	}
	
	public abstract void attack();
    public abstract void stand();
    public abstract void hold();
  
   
    public void performCON(){
    	
    }
    public void performAOE(){
    	
    }
}
