package com.arcmind.jsfquickstart;

import javax.faces.component.UIComponent;
import javax.faces.webapp.UIComponentTag;

public class LabelTag extends UIComponentTag {

	private String label;
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
	/**
	 * @see javax.faces.webapp.UIComponentTag#setProperties(javax.faces.component.UIComponent)
	 */
	@Override
	protected void setProperties(UIComponent component) {
		/* you have to call the super class */
		super.setProperties(component);
		((LabelComponent) component).setLabel(label);
	}
	/**
	 * @see javax.faces.webapp.UIComponentTag#getComponentType()
	 */
	@Override
	public String getComponentType() {
		return "simple.Label";
	}

	/**
	 * @see javax.faces.webapp.UIComponentTag#getRendererType()
	 */
	@Override
	public String getRendererType() {
		return null;
	}

}
