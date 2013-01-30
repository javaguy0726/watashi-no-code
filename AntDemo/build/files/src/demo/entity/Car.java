package demo.entity;

public class Car {
	private String model;
	private String brand;
	private float cc;        //L
	private int wheelbase;    //inch
	private boolean turbo;   

	public Car() {
		System.out.println("The defult constructor of Car");
	}

	public Car(String model, String brand, float cc, int wheelbase,
			boolean turbo) {
		this.model = model;
		this.brand = brand;
		this.cc = cc;
		this.wheelbase = wheelbase;
		this.turbo = turbo;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getCc() {
		return cc;
	}

	public void setCc(float cc) {
		this.cc = cc;
	}

	public int getWheelbase() {
		return wheelbase;
	}

	public void setWheelbase(int wheelbase) {
		this.wheelbase = wheelbase;
	}

	public boolean isTurbo() {
		return turbo;
	}

	public void setTurbo(boolean turbo) {
		this.turbo = turbo;
	}

}
