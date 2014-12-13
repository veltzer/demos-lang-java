<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<%@taglib prefix="ui" uri="http://java.sun.com/blueprints/ui/14"%>

<f:view>
	<html>
		<head>
			<title>Auto complete</title>
		</head>
		<body>
			<h:form>
				<h:outputText value="Person name:" />
				<ui:autoComplete id="personName" completionMethod="#{person.completeName}"
				value="#{person.name}" ondisplay="function(item) { return item; }"/>
			</h:form>
		</body>
	</html>
</f:view>