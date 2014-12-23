<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="arcmind" uri="http://arcmind.com/jsf/component/tags" %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>

<body>
<h1>IBM DEVELOPER WORKS</h1>
<f:view> 
	<arcmind:slabel label="Form Test"/>
	
	<h:form id="test">
	
	<%--
		<arcmind:label for="name" label="Name" errorStyleClass="errorText" >
         	<h:inputText id="name"  required="true" />				
		</arcmind:label>
		
		<h:message for="name" />
		--%>
		
		<br />
		
		<br />
		
		<br />
		<h:commandButton value="Submit" action="success"/>
	</h:form>
</f:view>

</body>
</html>