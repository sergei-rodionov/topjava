<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<header><a href="meals"><fmt:message key="app.title"/></a> &nbsp;&nbsp;&nbsp; [ Language:
        <a href="${pageContext.request.contextPath}?lang=en">Eng</a> | <a href="${pageContext.request.contextPath}?lang=ru">Rus</a>
     ]</header>
