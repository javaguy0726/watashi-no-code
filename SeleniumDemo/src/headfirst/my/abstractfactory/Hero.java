package headfirst.my.abstractfactory;

public abstract class Hero {

	String name;

	Tavern tavern;
	Type type;
	Phase phase;

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
		if (tavern != null) {
			result.append("Tavern is: ");
			result.append(tavern);
			result.append("\n");
		}
		if (type != null) {
			result.append("Type is: ");
			result.append(type);
			result.append("\n");
		}
		if (phase != null) {
			result.append("Phase is: ");
			result.append(phase);
			result.append("\n");
		}

		return result.toString();
	}
}
