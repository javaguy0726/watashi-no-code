<jsp:directive.page contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="now" class="java.util.Date" />

<fmt:formatDate value="${now}" pattern="yyyy hh:mm aa" />
