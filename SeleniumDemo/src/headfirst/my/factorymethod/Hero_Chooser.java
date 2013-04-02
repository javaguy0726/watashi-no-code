package headfirst.my.factorymethod;

public abstract class Hero_Chooser {

	abstract Hero selectHero(String name);

	public void controlHero(String name) {
		Hero hero;
		hero = selectHero(name);
		
		hero.attack();
		hero.hold();
		
	}
}
