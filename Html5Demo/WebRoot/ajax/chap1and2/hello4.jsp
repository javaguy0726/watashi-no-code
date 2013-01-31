<jsp:directive.page contentType="text/plain" pageEncoding="utf-8"/>
<%
	String name = new String(request.getParameter("name").getBytes("iso8859-1"), "utf-8");
	boolean isLong = (name.length() > 8);
%>
updateName("<%=name%>",<%=isLong%>);
