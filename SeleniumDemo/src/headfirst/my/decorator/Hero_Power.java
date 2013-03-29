package headfirst.my.decorator;

public class Hero_Power extends Hero_Type{

	public Hero_Power(){
		this.description="This is an original P-hero!";
		this.power= 55;
		this.intelligence= 40;
		this.agility= 45;
	}
	
	@Override
	public int damage() {
		// TODO Auto-generated method stub
		return (this.power*2+this.intelligence+this.agility)/3;
	}

}
