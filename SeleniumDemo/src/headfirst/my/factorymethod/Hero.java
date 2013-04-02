package headfirst.my.factorymethod;

public abstract class Hero {
	String name;
	String type;
	String phase;
	
	void attack(){
		System.out.println(name+" is attacking!");
		
	}
    
	void stand(){
		System.out.println(name+" is standing!");
	}
	
	void hold(){
		System.out.println(name+" is holding!");
	}
	
	public String toString(){
		StringBuffer display = new StringBuffer();
		display.append(name);
		display.append("'s type is ");
		display.append(type);
		
		return display.toString();
	}
}
