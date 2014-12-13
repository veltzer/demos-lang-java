package mycompany;

import java.io.Serializable;

@SuppressWarnings("serial")
public class GreetingBean implements Serializable {
	
	private String name;
	private String cell;
	private String greetText;
	private String businessProblem;

	public String greet() {
		if(!String.valueOf(cell).contains("-"))
		{
			businessProblem = "cell no must contain the - sign";
			return ("businessProblem");
		}
		
		greetText = "Dear Mr " + name + " your cell number is " + cell;
		return ("success");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public void setGreetText(String greetText) {
		this.greetText = greetText;
	}

	public String getGreetText() {
		return greetText;
	}

	public void setBusinessProblem(String businessProblem) {
		this.businessProblem = businessProblem;
	}

	public String getBusinessProblem() {
		return businessProblem;
	}
}
