package headfirst.my.abstractfactory;

public class Anaphase_Agility implements HeroAttributeFactory {
//火枪， 巨魔，赏金，变体精灵，那加海妖，隐型刺客，
	@Override
	public Type selectType() {
		// TODO Auto-generated method stub
		return new Agility();
	}

	@Override
	public Phase selectPhase() {
		// TODO Auto-generated method stub
		return new Anaphase();
	}

	@Override
	public Tavern[] selectTavern() {
		// TODO Auto-generated method stub
		return new Tavern[]{ new MorningTavern(), new SunriseTavern(), new LightTavern()};
	}

}
