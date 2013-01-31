<%--
simple JSP to generate some questions - and answers--%>
<jsp:directive.page contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8" />

<%
	String name = new String(request.getParameter("name").getBytes("iso8859-1"), "utf-8");
%>
<h1>
	Hello
	<%=name%>
</h1>
<p>
	中文乱码： <b><i><%=name%></i></b>. Are you related?
</p>