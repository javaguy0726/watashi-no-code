package headfirst.my.decorator;

public class Hero_Agility extends Hero_Type{

	public Hero_Agility(){
		this.description="This is an original A-hero!";
		this.power= 40;
		this.intelligence= 40;
		this.agility= 60;
	}
	
	@Override
	public int damage() {
		// TODO Auto-generated method stub
		return (this.power+this.intelligence+this.agility*2)/3;
	}

}
