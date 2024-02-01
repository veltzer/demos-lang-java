package jsf.solutions_and_examples.AjaxComponents.src.com.acme.autocomplete;

import javax.faces.context.FacesContext;
import com.sun.j2ee.blueprints.ui.autocomplete.CompletionResult;

public class PersonBean {
	private String name;
	private String[] availableNames = {
			"Ran", "Ron", "Ronald", "Randolf", "Rafael", "Romeo"
	};

	public String getName() {
		return name;
	}

	public void setName(String iname) {
		name = iname;
	}

	public void completeName(FacesContext ctx, String prefix,
			CompletionResult completionResult) {
		for (String availableName : availableNames) {
			if (availableName.startsWith(prefix)) {
				completionResult.addItem(availableName);
			}
		}
	}
}
