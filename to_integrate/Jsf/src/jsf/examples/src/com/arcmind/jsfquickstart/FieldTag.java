package com.arcmind.jsfquickstart;

import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.webapp.UIComponentTag;

public class FieldTag extends UIComponentTag {

	private String label;
	private String errorStyleClass = "";
	private String errorStyle = "";
	private boolean required;
	private String value = "";

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
	protected void setProperties(UIComponent component) {
		/* You have to call the super class */
		super.setProperties(component);
		((FieldComponent) component).setLabel(label);
		component.getAttributes().put("errorStyleClass", errorStyleClass);
		component.getAttributes().put("errorStyle", errorStyle);
		((FieldComponent) component).setRequired(required);

		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ValueBinding binding = application.createValueBinding(value);
		System.out.printf("setProperties class=%s expression=%s\n",
				binding.getType(FacesContext.getCurrentInstance()),
				binding.getExpressionString());
		component.setValueBinding("value", binding);
	}

	@Override
	public String getComponentType() {
		return "arcmind.Field";
	}

	@Override
	public String getRendererType() {
		return "arcmind.Field";
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
	 * @return Returns the required.
	 */
	public boolean isRequired() {
		return required;
	}

	/**
	 * @param required The required to set.
	 */
	public void setRequired(boolean irequired) {
		required = irequired;
	}

	/**
	 * @return Returns the value.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value The value to set.
	 */
	public void setValue(String ivalue) {
		value = ivalue;
	}
}
