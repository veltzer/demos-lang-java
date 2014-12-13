<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
<html>
	<head>
		<title>JSF Calculator</title>
	</head>
	<body>
		<div align="center">
			<h:form id="calc">
				<h:inputText id="value" />
				<br />
				<h:commandButton value="+" id="plus" />
				<h:commandButton value="-" id="minus" />
				<h:commandButton value="/" id="div" />
				<h:commandButton value="*" id="times" />
				<h:commandButton value="=" id="eq" />
			</h:form>
		</div>
	</body>
</html>
</f:view>
