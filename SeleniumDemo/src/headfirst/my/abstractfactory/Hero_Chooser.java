package headfirst.my.abstractfactory;

public abstract class Hero_Chooser {

	protected abstract Hero selectHero(String name);

	public void controlHero(String name) {
		Hero hero;
		hero = selectHero(name);
		
		hero.attack();
		hero.hold();
		
	}
}
