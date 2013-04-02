package headfirst.my.simplefactory;

public class SimpleTavernFactory {

	public Tavern buildTavern(String type) {
		Tavern tavern = null;

		if (type == "morning") {
			tavern = new MorningTavern();
		} else if (type == "sunrise") {
			tavern = new SunriseTavern();
		} else if (type == "light") {
			tavern = new LightTavern();
		}
		return tavern;

	}
}
