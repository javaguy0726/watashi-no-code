package headfirst.my.simplefactory;

public class SFTestDrive {
	public static void main(String[] args) {

		Tavern tavern;
		TavernLocator locator = new TavernLocator( new SimpleTavernFactory());
		
		tavern = locator.locateTavern("light");
		
		System.out.println(tavern);
		
	}
}
