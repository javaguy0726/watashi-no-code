package headfirst.my.abstractfactory;

public class Hero_Prophase extends Hero {
	HeroAttributeFactory heroAttribute;

	public Hero_Prophase(HeroAttributeFactory heroAttribute) {
		this.heroAttribute = heroAttribute;
	}

	@Override
	void attributes() {
		// TODO Auto-generated method stub
		range = heroAttribute.selectRange();
	}

}
