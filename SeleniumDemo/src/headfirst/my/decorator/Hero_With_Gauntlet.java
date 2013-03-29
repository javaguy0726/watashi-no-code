package headfirst.my.decorator;

public class Hero_With_Gauntlet extends Herp_Type_Decorator{

	Hero_Type type;

	public Hero_With_Gauntlet(Hero_Type type) {
		this.type = type;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.type.getDescription()+"  --Equip a Gauntlet--  ";
	}

	@Override
	public int damage() {
		// TODO Auto-generated method stub
		return 3+ type.damage();
	}
	

}
