package demo.entity;

/**
 * @author Renta
 * Information of a person
 */
public class Person {

	private long id; 
	private String name;
	private String gender; // male or female
	private int age;

	public Person() {
		System.out.println("The default constructor of Person");
	}
	
	public Person(long id, String name, String gender, int age) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
