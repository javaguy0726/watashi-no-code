package headfirst.my.decorator;

public class Hero_Intelligence extends Hero_Type{

	public Hero_Intelligence(){
		this.description="This is an original I-hero!";
		this.power= 40;
		this.intelligence= 60;
		this.agility= 45;
	}
	
	@Override
	public int damage() {
		// TODO Auto-generated method stub
		return (this.power+this.intelligence*2+this.agility)/3;
	}


}
