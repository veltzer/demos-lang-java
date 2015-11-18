package johnbryce.lab5.exercise;

import java.util.Date;

public class ExampleClass {
	private Date date;
	private String value;
	private int num;

	public ExampleClass(String ivalue, Date idate, int inum) {
		value = ivalue;
		date = idate;
		num = inum;
	}

	public String toString() {
		return "String value: " + value + "\n" + "Date: " + date + "\n"
				+ "Int value: " + num;
	}
}
