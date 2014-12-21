package jsf.solutions_and_examples.ex8.src.com.acme.birthday;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class BirthdayPhaseListener implements PhaseListener {

	public void afterPhase(PhaseEvent event) {
	}

	public void beforePhase(PhaseEvent event) {
		FacesContext ctx = event.getFacesContext();
		Application app = ctx.getApplication();

		if (ctx.getViewRoot().getViewId().contains("index")) {
			ValueBinding vb = app.createValueBinding("#{login.loggedIn}");
			boolean loggedIn = (Boolean) vb.getValue(ctx);

			if (!loggedIn) {
				System.out.println("Not logged in, transferred to login");
				app.getNavigationHandler().handleNavigation(ctx, null, "login");
			}

		}
	}

	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}

