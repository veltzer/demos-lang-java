package johnbryce.lab8.exercise;

public class Person {

	private String name;
	private int age;
	private float height;
	private float weight;

	public Person(String iname, int iage, float iweight, float iheight) {
		super();
		name = iname;
		age = iage;
		height = iheight;
		weight = iweight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int iage) {
		age = iage;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float iheight) {
		height = iheight;
	}

	public String getName() {
		return name;
	}

	public void setName(String iname) {
		name = iname;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float iweight) {
		weight = iweight;
	}

}
