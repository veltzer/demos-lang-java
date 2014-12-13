<%@page contentType="text/html; charset=UTF-8"  %>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:loadBundle basename="birthday" var="str" /> 

<f:view>
<html>
	<head>
		<title><h:outputText value="#{str.title}" /></title>
	</head>
	<h:outputText escape="false" value="<body dir='#{str.dir}'>" />
		<div align="center">
			<h:form id="ageForm">
				<h:commandLink value="en" actionListener="#{cake.setCurLocale}" immediate="true"/>
				<h:commandLink value="fr" actionListener="#{cake.setCurLocale}" immediate="true"/>
				<h:commandLink value="he" actionListener="#{cake.setCurLocale}" immediate="true"/>
				<br>
				<h:outputText value="#{str.how_old}" />
				<h:inputText id="userAge" size="4" value="#{cake.userAge}" required="true" validator="#{cake.validateAge}" />
				<h:commandButton value="#{str.birthday}" id="birthday"  actionListener="#{cake.showCake}" />
				<br />
				<h:message for="userAge" style="color: red;" />
			</h:form>
			<br />
			<h:panelGroup id="cake" rendered="false" dir="ltr" /> <!-- Java code will add children to this element -->
		</div>
	<h:outputText escape="false" value="</body>" />
</html>
</f:view>
