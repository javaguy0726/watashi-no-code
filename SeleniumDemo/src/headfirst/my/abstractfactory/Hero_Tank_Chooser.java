package headfirst.my.abstractfactory;

public class Hero_Tank_Chooser extends Hero_Chooser {

	@Override
	protected Hero selectHero(String name) {
		// TODO Auto-generated method stub
		Hero hero = null;
		HeroAttributeFactory attribute = new HeroAttributeTank();

		if ("FW".equals(name)) {
			hero = new Hero_Anaphase(attribute);
		} else if ("TH".equals(name)) {
			hero = new Hero_Prophase(attribute);
		}
		return hero;
	}

}
