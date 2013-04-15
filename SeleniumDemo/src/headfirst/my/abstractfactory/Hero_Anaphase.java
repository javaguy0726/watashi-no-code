package headfirst.my.abstractfactory;

public class Hero_Anaphase extends Hero {
	HeroAttributeFactory heroAttribute;

	public Hero_Anaphase(HeroAttributeFactory heroAttribute) {
		this.heroAttribute = heroAttribute;
	}

	@Override
	void attributes() {
		// TODO Auto-generated method stub
		atk_speed = heroAttribute.selectAttackSpeed();
		grow_speed = heroAttribute.selectGrowSpeed();
	}

}
