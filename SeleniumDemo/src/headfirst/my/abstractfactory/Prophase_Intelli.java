package headfirst.my.abstractfactory;

public class Prophase_Intelli implements HeroAttributeFactory {
  // 宙斯，冰女，火女 ,谜团，光之守卫，修补匠，地精工程师，圣骑士，小y
	@Override
	public Type selectType() {
		// TODO Auto-generated method stub
		return new Intelligence();
	}

	@Override
	public Phase selectPhase() {
		// TODO Auto-generated method stub
		return new Prophase();
	}

	@Override
	public Tavern[] selectTavern() {
		// TODO Auto-generated method stub
		return new Tavern[]{ new MorningTavern(), new SunriseTavern(), new LightTavern()};
	}

}
