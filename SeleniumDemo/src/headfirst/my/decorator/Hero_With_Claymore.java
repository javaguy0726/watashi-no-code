package headfirst.my.decorator;

public class Hero_With_Claymore extends Herp_Type_Decorator {
	Hero_Type type;

	public Hero_With_Claymore(Hero_Type type) {
		this.type = type;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.type.getDescription()+"  --Equip a ClayMore--  ";
	}
	
	@Override
	public int damage() {
		// TODO Auto-generated method stub
		return 20+ type.damage();
	}

	
	
	
}
