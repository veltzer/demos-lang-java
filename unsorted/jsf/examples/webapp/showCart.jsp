
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.01 transitional//en">
<!--
 Copyright 2004 ArcMind, Inc. All Rights Reserved.
-->
<%@ taglib uri="http://java.sun.com/jsf/html"  prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core"  prefix="f" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
  <head>
    <title>Cart</title>
    <style type="text/css">
		.oddRow {background-color: gray}
		.evenRow {background-color: lightblue}
		.ocean {background-color: cyan}
		.tableHeader {background-color: white}
    </style>


  </head>
  <body class="ocean">
    <h1>Shopping Cart</h1>
    <f:view>
			<h:form id="cartForm">	
				<h:dataTable id="items"
				             value="#{cart.items}"
				             var="cd"
				             rowClasses="oddRow, evenRow"
										 headerClass="tableHeader"
				             >
				
				  <h:column>
				    <f:facet name="header">
				        <h:outputText value="Title"/>
				    </f:facet>
				
				    <h:outputText value="#{cd.title}"/>
				  </h:column>
				
				  <h:column>
				    <f:facet name="header">
				    	<h:outputText value="Artist"/>
				    </f:facet>
				    <h:outputText value="#{cd.artist}"/>
				  </h:column>
				
				  <h:column>
				    <f:facet name="header">
				      <h:outputText value="Price"/>
				    </f:facet>
				    <h:outputText value="#{cd.price}"/>
				  </h:column>

				  <h:column>
				    <f:facet name="header">
				        <h:outputText value="Remove"/>
				    </f:facet>
				
				    <h:commandLink action="#{cart.remove}">
				        <h:outputText value="Remove"/>
				        <f:param name="title" value="#{cd.title}" />

				    </h:commandLink>
				  </h:column>

				
				</h:dataTable>
    		
    		<br/>
    		
    		<h:commandLink  action="store">
				    <h:outputText value="Return to Store"/>
        </h:commandLink>
    		
    		
    	</h:form>		
    </f:view>
  </body>

</html>
