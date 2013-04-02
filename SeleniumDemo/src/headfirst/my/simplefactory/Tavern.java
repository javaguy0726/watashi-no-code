package headfirst.my.simplefactory;

public abstract class Tavern {
	String name;

	public String toString() {
		StringBuffer description = new StringBuffer();
	    description.append("The ");
	    description.append(name);
	    description.append(" is loacated!");
	    
	    return description.toString();
	}

}
