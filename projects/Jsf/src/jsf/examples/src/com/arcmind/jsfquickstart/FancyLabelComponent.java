package com.arcmind.jsfquickstart;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

public class FancyLabelComponent extends UIOutput {

	private String label;

	private String forComponent;

	private String errorStyle = "";

	private String errorStyleClass = "";

	/**
	 * @return Returns the errorStyle.
	 */
	public String getErrorStyle() {
		return errorStyle;
	}

	/**
	 * @param errorStyle The errorStyle to set.
	 */
	public void setErrorStyle(String ierrorStyle) {
		errorStyle = ierrorStyle;
	}

	/**
	 * @return Returns the label.
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label The label to set.
	 */
	public void setLabel(String ilabel) {
		label = ilabel;
	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		/* Start a label tag <label> */
		writer.startElement("label", this);
		/* Check to see if there are errors with the related component */
		if (isError()) {
			/* If there is an error write style and class attributes */
			writer.writeAttribute("style", this.errorStyle, "style");
			writer.writeAttribute("class", this.errorStyleClass, "class");
		}
		/* Write the value of the label */
		writer.write(label);
		/* Check to see if the "for" component is required if so write * */
		if (isRequired()) {
			writer.write("*");
		}
		/* End a label tag </label> */
		writer.endElement("label");
		writer.flush();
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
	}

	@Override
	public String getFamily() {
		return "arcmind.Label";
	}

	@Override
	public void decode(FacesContext context) {
		return;
	}

	private UIInput getForComponent() {
		return (UIInput) getParent().findComponent(forComponent);
	}

	private boolean isError() {
		if (getForComponent() != null) {
			return !getForComponent().isValid();
		} else {
			return false;
		}
	}

	private boolean isRequired() {
		if (getForComponent() != null) {
			return getForComponent().isRequired();
		} else {
			return false;
		}
	}

	/**
	 * @return Returns the forComponent.
	 */
	public String getFor() {
		return forComponent;
	}

	/**
	 * @param forComponent The forComponent to set.
	 */
	public void setFor(String iforComponent) {
		forComponent = iforComponent;
	}

	/**
	 * @return Returns the errorStyleClass.
	 */
	public String getErrorStyleClass() {
		return errorStyleClass;
	}

	/**
	 * @param errorStyleClass The errorStyleClass to set.
	 */
	public void setErrorStyleClass(String ierrorStyleClass) {
		errorStyleClass = ierrorStyleClass;
	}

	public void encodeChildren(FacesContext context, UIComponent component)
			throws IOException {

		Iterator children = component.getChildren().iterator();
		while (children.hasNext()) {
			UIComponent child = (UIComponent) children.next();
			child.encodeBegin(context);
			if (child.getRendersChildren()) {
				child.encodeChildren(context);
			}
			child.encodeEnd(context);
		}
	}

}
