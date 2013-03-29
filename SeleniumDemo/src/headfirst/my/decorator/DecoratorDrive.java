package headfirst.my.decorator;

public class DecoratorDrive {
	public static void main(String[] args) {
		Hero_Type intelligence = new Hero_Intelligence();
		Hero_Type agility = new Hero_Agility();
		Hero_Type power = new Hero_Power();
		System.out.println(intelligence.getDescription()+"    "+intelligence.damage());
		System.out.println(agility.getDescription()+"    "+agility.damage());
		System.out.println(power.getDescription()+"    "+power.damage());
	
		Hero_Type intelWithClaymore =  new Hero_With_Claymore(intelligence);
		System.out.println(intelWithClaymore.getDescription()+"    "+intelWithClaymore.damage());
		intelWithClaymore = new Hero_With_Gauntlet(intelWithClaymore);
		System.out.println(intelWithClaymore.getDescription()+"    "+intelWithClaymore.damage());
		
	}
	
}
