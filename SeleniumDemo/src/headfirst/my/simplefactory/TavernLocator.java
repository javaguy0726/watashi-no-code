package headfirst.my.simplefactory;

public class TavernLocator {
	SimpleTavernFactory tavernFactory;

	TavernLocator(SimpleTavernFactory factory) {
		this.tavernFactory = factory;
	}

	public Tavern locateTavern(String type) {
		Tavern tavern;

		tavern = tavernFactory.buildTavern(type);

		return tavern;
	}

}
