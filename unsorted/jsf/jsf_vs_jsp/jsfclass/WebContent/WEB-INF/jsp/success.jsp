<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<title>greeting</title>
</HEAD>
<BODY>
  <h:outputText value="#{greetingBean.greetText}"></h:outputText>
</BODY>
</HTML>
</f:view>