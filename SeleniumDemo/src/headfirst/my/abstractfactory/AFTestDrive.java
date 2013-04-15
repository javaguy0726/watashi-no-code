package headfirst.my.abstractfactory;

public class AFTestDrive {
	public static void main(String[] args) {

		Hero_Chooser middle_chooser = new Hero_MiddleRoad_Chooser();
		Hero_Chooser tank_chooser = new Hero_Tank_Chooser();
		
		middle_chooser.controlHero("TF");
	}
}
