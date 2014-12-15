<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@ page 
language="java"
contentType="text/html; charset=WINDOWS-1255"
pageEncoding="WINDOWS-1255"
%>
<META http-equiv="Content-Type"
	content="text/html; charset=WINDOWS-1255">
<TITLE>Composite View</TITLE>
</HEAD>
<BODY>
<TABLE border="1" width="100%" height="100%">
	<TBODY>
		<TR height="10%">
			<TD colspan="2"> 
			<%-- Header include --%>
			<jsp:include page="header.jsp" />
			</TD>
		</TR>
		<TR>
			<TD width="20%">
			<%-- Navigation include --%>
			<jsp:include page="navigation.jsp" />
			</TD>
			<TD>
			<%-- Body include --%>
			<jsp:include page="body.jsp" />
			</TD>
		</TR>
		<TR height="10%">
			<TD colspan="2">
			<%-- Footer include --%>
			<jsp:include page="footer.jsp" />
			
			</TD>
		</TR>
	</TBODY>
</TABLE>


</BODY>
</HTML>
