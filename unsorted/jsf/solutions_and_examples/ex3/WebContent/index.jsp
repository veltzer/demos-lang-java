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
				<%-- Debug output element. See the CalculatorBean
				     source for details.
				    
					<h:outputText id="debug" value="" />
					<br />
				--%> 
				<h:inputText id="displayValue" value="#{calc.displayValue}" />
				<br />
				<h:commandButton value="+" id="plus"  actionListener="#{calc.doPlus}" />
				<h:commandButton value="-" id="minus" actionListener="#{calc.doMinus}" />
				<h:commandButton value="/" id="div"   actionListener="#{calc.doDiv}" />
				<h:commandButton value="*" id="times" actionListener="#{calc.doTimes}" />
				<h:commandButton value="=" id="eq"    actionListener="#{calc.doEq}" />
			</h:form>
		</div>
	</body>
</html>
</f:view>
