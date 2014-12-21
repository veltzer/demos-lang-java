package jsf.solutions_and_examples.ex8.src.com.acme.birthday;

import java.util.List;

import javax.faces.application.FacesMessage;
//import javax.faces.component.*;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

public class BirthdayCakeBean {
	private static final int MIN_AGE = 1;
	private static final int MAX_AGE = 120;
	private int userAge;

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int iuserAge) {
		userAge = iuserAge;
	}

	@SuppressWarnings("unchecked")
	public void showCake(ActionEvent event) {
		UIComponent root = FacesContext.getCurrentInstance().getViewRoot();
		UIPanel cake = (UIPanel) root.findComponent("cake");
		cake.setRendered(true);
		List cakeParts = cake.getChildren();
		cakeParts.clear();

		HtmlGraphicImage cakeLeftSide = new HtmlGraphicImage();
		cakeLeftSide.setUrl("images/cake_left.gif");
		cakeParts.add(cakeLeftSide);

		for (int i = 0; i < userAge; i++) {
			HtmlGraphicImage candle = new HtmlGraphicImage();
			candle.setUrl("images/candle_on.gif");
			cakeParts.add(candle);
		}

		HtmlGraphicImage cakeRightSide = new HtmlGraphicImage();
		cakeRightSide.setUrl("images/cake_right.gif");
		cakeParts.add(cakeRightSide);
	}

	public void clearCake() {
		UIComponent root = FacesContext.getCurrentInstance().getViewRoot();
		UIPanel cake = (UIPanel) root.findComponent("cake");
		cake.setRendered(false);
		cake.getChildren().clear();
	}

	public void validateAge(FacesContext context, UIComponent component, Object newValue) {
		int newVal = ((Integer) newValue).intValue();
		if (newVal < MIN_AGE) {
			clearCake();
			throw new ValidatorException(new FacesMessage("Too young."));
		}
		if (newVal > MAX_AGE) {
			clearCake();
			throw new ValidatorException(new FacesMessage("Too old."));
		}
	}
}

