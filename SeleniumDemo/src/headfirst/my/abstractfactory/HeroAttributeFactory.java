package headfirst.my.abstractfactory;

public interface HeroAttributeFactory {
	public Type selectType();

	public Phase selectPhase();

	public Tavern[] selectTavern();

}
