package johnbryce.lab5.solution;

import java.util.Date;

public class ExampleClass {
	private Date date;
	private String value;
	private int num;

	public ExampleClass (String value,Date date, int num){
		this.value=value;
		this.date=date;
		this.num=num;
	}

	public String toString(){
		return "String value: "+value +"\n"+"Date: "+date+"\n"+"Int value: "+num;
	}
}
