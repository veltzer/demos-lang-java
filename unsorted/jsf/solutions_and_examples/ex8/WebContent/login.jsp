<%@page contentType="text/html; charset=UTF-8"  %>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
<html>
	<head>
		<title><h:outputText value="Birthday Cake Application" /></title>
	</head>
	<body>
		<div align="center">
			<h:form id="loginForm">
				<h:outputText value="User name" />
				<h:inputText id="userName" required="true" value="#{login.userName}"/><br>
				<h:outputText value="Password" />
				<h:inputSecret id="password" value="#{login.password}"/><br>
				<h:commandButton value="Login" actionListener="#{login.loginHandler}" action="#{login.checkLogin}"/>
				<br />
				<h:message for="userName" style="color: red;" />
				<h:message for="loginForm" style="color: red;"/>
			</h:form>
			<br />
		</div>
	</body>
</html>
</f:view>
