package headfirst.my.factorymethod;

public class Hero_MT_Chooser extends Hero_Chooser {

	@Override
	Hero selectHero(String name) {
		// TODO Auto-generated method stub
		if (name.equals("sven")) {
			return new MT_Sven();
		} else if (name.equals("vs")) {
			return new MT_VengefulSpirit();
		} else if (name.equals("zeus")) {
			return new MT_Zeus();
		} else 
			return null;
		
	}

}
