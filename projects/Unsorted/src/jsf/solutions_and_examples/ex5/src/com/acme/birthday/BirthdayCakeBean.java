package jsf.solutions_and_examples.ex5.src.com.acme.birthday;

import java.util.List;

//import javax.faces.component.*;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class BirthdayCakeBean {
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
}
