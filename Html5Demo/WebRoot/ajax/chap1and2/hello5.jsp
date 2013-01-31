<%--
simple JSP to generate some questions - and answers--%>
<jsp:directive.page contentType="application/javascript"/>
<%
String name=request.getParameter("name");
%>
{
  name: "<%=name%>",
  initial: "<%=name.substring(0,2).toUpperCase()%>",
  likes: ["JavaScript", "Java", "Google"],
  ingredients: {
    apples: "3kg",
    sugar: "1kg",
    pastry: "2.4kg",
    bestEaten: "outdoors"
  }
}
