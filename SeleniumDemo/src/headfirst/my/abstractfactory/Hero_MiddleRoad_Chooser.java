package headfirst.my.abstractfactory;

public class Hero_MiddleRoad_Chooser extends Hero_Chooser {

	@Override
	protected Hero selectHero(String name) {
		// TODO Auto-generated method stub
		Hero hero = null;
		HeroAttributeFactory attribute = new HeroAttributeMiddleRoad();

		if ("TF".equals(name)) {
			hero = new Hero_Anaphase(attribute);
			hero.setName("Pudge");
		} else if ("BS".equals(name)) {
			hero = new Hero_Prophase(attribute);
			hero.setName("Blood Seeker");
		}
		return hero;
	}

}
