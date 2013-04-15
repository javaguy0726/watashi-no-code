package headfirst.my.abstractfactory;

public interface HeroAttributeFactory {
	public AttackSpeed selectAttackSpeed();
	public Range selectRange();
	public Resistance selectResistance();
	public GrowSpeed selectGrowSpeed();

}
