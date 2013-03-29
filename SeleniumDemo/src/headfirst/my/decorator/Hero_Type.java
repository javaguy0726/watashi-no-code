package headfirst.my.decorator;

public abstract class Hero_Type {
	int power;
	int agility;
	int intelligence;
	
	String description;
	
	public String getDescription() {
		return this.description;
	}
	
	public abstract int damage();

}
