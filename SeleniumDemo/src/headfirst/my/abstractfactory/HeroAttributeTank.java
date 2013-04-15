package headfirst.my.abstractfactory;

public class HeroAttributeTank implements HeroAttributeFactory {

	@Override
	public AttackSpeed selectAttackSpeed() {
		// TODO Auto-generated method stub
		return new AttackSpeed_Slow();
	}

	@Override
	public Range selectRange() {
		// TODO Auto-generated method stub
		return new Range_Close();
	}

	@Override
	public Resistance selectResistance() {
		// TODO Auto-generated method stub
		return new Resistance_Strong();
	}

	@Override
	public GrowSpeed selectGrowSpeed() {
		// TODO Auto-generated method stub
		return new GrowSpeed_Normal();
	}

}
