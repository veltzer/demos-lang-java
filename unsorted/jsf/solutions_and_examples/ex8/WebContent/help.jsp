<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
	<html>
	<head>
		<title><h:outputText value="Birthday Cake Application" /></title>
	</head>
	<body>
		<h1>Help</h1>
		<h:outputText value="This is a birthday application"/>
		
		<h:form>
			<h:commandLink action="#{login.checkLogin}" value="Enter"/>
		</h:form>
	</body>
	
	</html>


</f:view>