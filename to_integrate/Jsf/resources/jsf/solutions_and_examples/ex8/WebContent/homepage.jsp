<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
	
	<html>
	<head>
		<title><h:outputText value="Birthday Cake Application" /></title>
	</head>
	<body>
		<h1>Welcome</h1>
		<h:form>
			<h:commandLink action="login" value="Login"/><br/>
			<h:commandLink action="help" value="Help"/>
		</h:form>
	</body>
	
	</html>


</f:view>