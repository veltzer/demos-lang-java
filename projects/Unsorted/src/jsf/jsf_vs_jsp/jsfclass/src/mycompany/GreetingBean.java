package mycompany;

import java.io.Serializable;

@SuppressWarnings("serial")
public class GreetingBean implements Serializable {

	private String name;
	private String cell;
	private String greetText;
	private String businessProblem;

	public String greet() {
		if (!String.valueOf(cell).contains("-")) {
			businessProblem = "cell no must contain the - sign";
			return ("businessProblem");
		}
		greetText = "Dear Mr " + name + " your cell number is " + cell;
		return ("success");
	}

	public String getName() {
		return name;
	}

	public void setName(String iname) {
		name = iname;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String icell) {
		cell = icell;
	}

	public void setGreetText(String igreetText) {
		greetText = igreetText;
	}

	public String getGreetText() {
		return greetText;
	}

	public void setBusinessProblem(String ibusinessProblem) {
		businessProblem = ibusinessProblem;
	}

	public String getBusinessProblem() {
		return businessProblem;
	}
}
