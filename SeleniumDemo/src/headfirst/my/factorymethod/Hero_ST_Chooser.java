package headfirst.my.factorymethod;

public class Hero_ST_Chooser extends Hero_Chooser {

	@Override
	Hero selectHero(String name) {
		// TODO Auto-generated method stub
		if (name.equals("silencer")) {
			return new ST_Silencer();
		} else if (name.equals("tk")) {
			return new ST_Tinker();
		} else if (name.equals("tiny")) {
			return new ST_Tiny();
		} else 
			return null;
	}

}
