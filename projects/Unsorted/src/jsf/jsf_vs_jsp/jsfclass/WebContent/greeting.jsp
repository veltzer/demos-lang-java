<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD><TITLE>greeting</TITLE>
</HEAD>
<BODY>
<h:form>
	
  <h:outputText value="#{greetingBean.businessProblem}"></h:outputText>
  <BR>
  Name: 
  <h:inputText value="#{greetingBean.name}"></h:inputText>
  <BR>
  Cell: 
  <h:inputText value="#{greetingBean.cell}"></h:inputText>
  <BR>
  <h:commandButton value="greet" action="#{greetingBean.greet}"></h:commandButton>
</h:form>
</BODY>
</HTML>
</f:view>