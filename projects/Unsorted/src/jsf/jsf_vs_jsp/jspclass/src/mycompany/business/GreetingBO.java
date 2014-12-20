package jsf.jsf_vs_jsp.jspclass.src.mycompany.business;

public class GreetingBO {

	public GreetingRES doGreeting(GreetingREQ greetingREQ) {

		GreetingRES greetingRES = new GreetingRES();

		// create the greeting text
		String greetText = "welcome dear " + greetingREQ.getName() + " you cell is " + greetingREQ.getCell();

		// populate the response object
		greetingRES.setGreetText(greetText);

		return greetingRES;
	}
}
