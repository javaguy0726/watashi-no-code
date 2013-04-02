package headfirst.my.factorymethod;

public class FMTestDriver {
	public static void main(String[] args) {
		Hero_Chooser st_chooser= new Hero_ST_Chooser();
		Hero_Chooser mt_chooser = new Hero_MT_Chooser();
		
		st_chooser.controlHero("tk");
		mt_chooser.controlHero("sven");
	}
}
