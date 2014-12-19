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
				<!-- Debug output element. See the CalculatorBean
				     source for details.
				     
					<h:outputText id="debug" value="" />
					<br />
				-->
				<h:inputText id="displayValue" value="#{calc.displayValue}" />
				<br />
				<h:commandButton value="+" id="plus"  actionListener="#{calc.doPlus}" />
				<h:commandButton value="-" id="minus" actionListener="#{calc.doMinus}" />
				<h:commandButton value="/" id="div"   actionListener="#{calc.doDiv}" />
				<h:commandButton value="*" id="times" actionListener="#{calc.doTimes}" />
				<h:commandButton value="=" id="eq"    actionListener="#{calc.doEq}" />
				<br />
				<h:panelGroup rendered="#{calc.scientificRendered}">
					<h:commandButton image="images/p2.gif"   id="p2"   actionListener="#{calc.doPower2}" />
					<h:outputText value=" " /> <%-- In some browsers, there's no self-generated space between image buttons --%>
					<h:commandButton image="images/sqrt.gif" id="sqrt" actionListener="#{calc.doSqrt}" />
				</h:panelGroup>
				<br />
				<h:commandLink id="flipModeLink" actionListener="#{calc.flipMode}">
					<h:outputText id="flipModeText" value="#{calc.changeModeMessage}" />
				</h:commandLink>
		
			</h:form>
		</div>
	</body>
</html>
</f:view>
