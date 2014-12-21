package com.arcmind.jsfquickstart;

import java.io.IOException;

import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

public class LabelComponent extends UIOutput {

	private String label;

	@Override
	public Object saveState(FacesContext context) {
		Object[] values = new Object[2];
		values[0] = super.saveState(context);
		values[1] = label;
		return ((Object) (values));
	}

	@Override
	public void restoreState(FacesContext context, Object state) {
		Object[] values = (Object[]) state;
		super.restoreState(context, values[0]);
		label = (String) values[1];
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

	/**
	 * @see javax.faces.component.UIComponent#encodeBegin(javax.faces.context.FacesContext)
	 */
	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		writer.startElement("label", this);
		writer.write(label);
		writer.endElement("label");
		writer.flush();
	}

	@Override
	public String getFamily() {
		return "arcmind.Label";
	}

	/**
	 * @see javax.faces.component.UIComponent#encodeEnd(javax.faces.context.FacesContext)
	 */
	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		return;
	}

	/**
	 * @see javax.faces.component.UIComponent#decode(javax.faces.context.FacesContext)
	 */
	@Override
	public void decode(FacesContext context) {
		return;
	}
}
