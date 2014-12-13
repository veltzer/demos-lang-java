
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.01 transitional//en">
<!--
 Copyright 2004 ArcMind, Inc. All Rights Reserved.
-->
<%@ taglib uri="http://java.sun.com/jsf/html"  prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core"  prefix="f" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
  <head>
    <title>CD Listing</title>
    <style type="text/css">
		.oddRow {background-color: gray}
		.evenRow {background-color: lightblue}
		.ocean {background-color: cyan}
		.tableHeader {background-color: white}
    </style>
    
    
  </head>
  <body class="ocean">
     
    <f:view>
			<h:form>	
				<h:dataTable id="items" 
				             value="#{CDManagerBean.cds}" 
				             var="cd"
				             rowClasses="oddRow, evenRow" 
										 headerClass="tableHeader" 
				             >
				  
				  <h:column>
				    <f:facet name="header">
				        <h:outputText value="Title"/>
				    </f:facet>
				    
				    <!--TODO change this into a link -->
				    <h:commandLink action="#{CDManagerBean.editCD}">
				        <h:outputText value="#{cd.title}"/>
				    </h:commandLink>
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
				
				</h:dataTable> 
    		
    		<br/>
    		<h:outputLink value="cdForm.jsp" >
            <f:verbatim>Add CD</f:verbatim>
        </h:outputLink> 
    		
    	</h:form>		
    </f:view>
  </body>

</html>