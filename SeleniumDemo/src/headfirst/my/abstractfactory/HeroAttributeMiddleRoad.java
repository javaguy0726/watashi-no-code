package headfirst.my.abstractfactory;

public class HeroAttributeMiddleRoad implements HeroAttributeFactory {

	@Override
	public AttackSpeed selectAttackSpeed() {
		// TODO Auto-generated method stub
		return new AttackSpeed_Fast();
	}

	@Override
	public Range selectRange() {
		// TODO Auto-generated method stub
		return new Range_Far();
	}

	@Override
	public Resistance selectResistance() {
		// TODO Auto-generated method stub
		return new Resistance_Weak();
	}

	@Override
	public GrowSpeed selectGrowSpeed() {
		// TODO Auto-generated method stub
		return new GrowSpeed_Normal();
	}

}
