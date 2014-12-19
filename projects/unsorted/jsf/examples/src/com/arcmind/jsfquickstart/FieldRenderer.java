package com.arcmind.jsfquickstart;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.el.ValueBinding;
import javax.faces.render.Renderer;

public class FieldRenderer extends Renderer {
	@Override
	public Object getConvertedValue(FacesContext facesContext, UIComponent component, Object submittedValue) throws ConverterException {

        //Try to find out by value binding
        ValueBinding valueBinding = component.getValueBinding("value");
        if (valueBinding == null) return null;

        Class valueType = valueBinding.getType(facesContext);
        if (valueType == null) return null;

        if (String.class.equals(valueType)) return submittedValue;
        if (Object.class.equals(valueType)) return submittedValue;

        Converter converter = ((UIInput) component).getConverter();
        converter =  facesContext.getApplication().createConverter(valueType);
        if (converter != null ) {
        	return converter.getAsObject(facesContext, component, (String) submittedValue);
        }else {
        	return submittedValue;
        }

	}

	@Override
	public void decode(FacesContext context, UIComponent component) {
		    /* Grab the request map from the external context */
		Map requestMap = context.getExternalContext().getRequestParameterMap();
		    /* Get client ID, use client ID to grab value from parameters */
		String clientId = component.getClientId(context);
		String value = (String) requestMap.get(clientId);

		FieldComponent fieldComponent = (FieldComponent)component;
			/* Set the submitted value */
		((UIInput)component).setSubmittedValue(value);
	}

	@Override
	public void encodeBegin(FacesContext context, UIComponent component)
			throws IOException {
		FieldComponent fieldComponent = (FieldComponent) component;
		ResponseWriter writer = context.getResponseWriter();
		encodeLabel(writer,fieldComponent);
		encodeInput(writer,fieldComponent);
		encodeMessage(context, writer, fieldComponent);
		writer.flush();
	}



	private void encodeMessage(FacesContext context, ResponseWriter writer, FieldComponent fieldComponent) throws IOException {
		Iterator iter = context.getMessages(fieldComponent.getClientId(context));
		while (iter.hasNext()){
			FacesMessage message = (FacesMessage) iter.next();
			writer.write(message.getDetail());
		}
	}

	private void encodeLabel(ResponseWriter writer, FieldComponent fieldComponent) throws IOException{
		writer.startElement("label", fieldComponent);
		if (fieldComponent.isError()) {
			String errorStyleClass = (String) fieldComponent.getAttributes().get("errorStyleClass");
			String errorStyle = (String) fieldComponent.getAttributes().get("errorStyle");

			writer.writeAttribute("style", errorStyle, "style");
			writer.writeAttribute("class", errorStyleClass, "class");
		}
		writer.write("" + fieldComponent.getLabel());
		if (fieldComponent.isRequired()) {
			writer.write("*");
		}
		writer.endElement("label");
	}

	private void encodeInput(ResponseWriter writer, FieldComponent fieldComponent) throws IOException{
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		writer.startElement("input", fieldComponent);
		writer.writeAttribute("type", "text", "type");
		writer.writeAttribute("id", fieldComponent.getClientId(currentInstance), "id");
		writer.writeAttribute("name", fieldComponent.getClientId(currentInstance), "name");
		if(fieldComponent.getValue()!=null)
			writer.writeAttribute("value", fieldComponent.getValue().toString(), "value");
		writer.endElement("input");
	}

}
