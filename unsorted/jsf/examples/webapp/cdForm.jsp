<!doctype html public "-//w3c//dtd html 4.01 transitional//en">
<!--
 Copyright 2004 ArcMind, Inc. All Rights Reserved.
-->
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib prefix="arcmind" 
         uri="http://arcmind.com/jsf/component/tags" %>
         
<html>

    <head> 
    	<title>CD Form</title> 
	    <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    
    <body bgcolor="white">
    
    <f:view>
      <h2>CD Form</h2>
      
      <h:form id="cdForm">
        
        <h:inputHidden id="rowIndex" value="#{CDManagerBean.rowIndex}" /> 
        
        <arcmind:slabel label="this is a label"></arcmind:slabel>
        <br />
      
		<arcmind:field  id="title"
						value="#{CDManagerBean.title}"  
						label="Title:"
						errorStyleClass="errorText"
						required="true" /> <br />
		
		<arcmind:field id="artist"
					   value="#{CDManagerBean.artist}"  
					   label="Artist:"
					   errorStyleClass="errorText"
					   required="true" /> <br />
					   
		<arcmind:field id="price"
					   value="#{CDManagerBean.price}"  
					   label="CD Price:"
					   errorStyleClass="errorText"
					   required="true">
					   <f:validateDoubleRange maximum="1000.0" minimum="1.0"/>
		</arcmind:field>
      	
      	
      	<br />

        <h:commandButton id="submitAdd" 
        								 action="#{CDManagerBean.addCD}" 
        								 value="Add CD" 
        								 rendered="#{not CDManagerBean.editMode}" 
        								 />
        								 
        <h:commandButton id="submitUpdate" 
        								 action="#{CDManagerBean.updateCD}" 
        								 value="Update CD" 
        								 rendered="#{CDManagerBean.editMode}" 
        								 />

      </h:form>
    </f:view>
</html>  
