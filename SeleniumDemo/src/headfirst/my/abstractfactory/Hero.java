package headfirst.my.abstractfactory;

public abstract class Hero {

	String name;

	AttackSpeed atk_speed;
	Range range;
	Resistance resist;
	GrowSpeed grow_speed;
	
	
	abstract void attributes();
	
	void attack() {
		System.out.println(name + " is attacking!");
	}

	void stand() {
		System.out.println(name + " is standing!");
	}

	void hold() {
		System.out.println(name + " is holding!");
	}

	void setName(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("---- " + name + " ----\n");
		if (atk_speed != null) {
			result.append("Attack Speed is: ");
			result.append(atk_speed);
			result.append("\n");
		}
		if (range != null) {
			result.append("Range is: ");
			result.append(range);
			result.append("\n");
		}
		if (resist != null) {
			result.append("Resist is: ");
			result.append(resist);
			result.append("\n");
		}
		if (grow_speed != null) {
			result.append("Grow Speed is: ");
			result.append(grow_speed);
			result.append("\n");
		}
		return result.toString();
	}
}
