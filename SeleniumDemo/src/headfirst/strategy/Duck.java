package headfirst.strategy;

public abstract class Duck {
	FlyBehavior flyBehavior;   //变化的部分移出来交给了实现 FlyBehavior和QuackBehavior接口的 类了；
	QuackBehavior quackBehavior;
 
	public Duck() {
		
	}
 
	public void setFlyBehavior (FlyBehavior fb) {
		flyBehavior = fb;
	}
 
	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}
 
	abstract void display();
 
	public void performFly() {
		flyBehavior.fly();
	}
 
	public void performQuack() {
		quackBehavior.quack();
	}
 
	public void swim() {
		System.out.println("All ducks float, even decoys!");
	}
}
