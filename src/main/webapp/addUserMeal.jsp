<%@ page import="ru.javawebinar.topjava.model.UserMeal" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Add</title>
</head>
<body>

<c:choose>
<c:when test="${not empty userMeal}">
<h2>Edit User Meal</h2>

<form accept-charset="UTF-8" method="post" action="${pageContext.request.contextPath}/edit">
    <input type="hidden" name="date" value="<%=request.getParameter("date")%>">
    </c:when>
    <c:otherwise><h2>Add User Meal</h2>

    <form accept-charset="UTF-8" method="post" action="${pageContext.request.contextPath}/add">
        </c:otherwise>
        </c:choose>

        <table>

            <tr>
                <td>Description</td>
                <%
                    String datetime = "";
                    if (request.getAttribute("userMeal") != null) {
                        final DateTimeFormatter formatter =
                                DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
                        datetime = ((UserMeal) request.getAttribute("userMeal")).getDateTime().format(formatter);

                    }
                %>

                <td><input type="text" name="description" value="<c:out value="${userMeal.description}"/>"></td>
            </tr>
            <tr>
                <td>Date/Time (DD/MM/YYYY HH:MM)</td>

                <td><input type="text" name="datetime" value="<%=datetime%>"></td>
            </tr>
            <tr>
                <td>Calories</td>
                <td><input type="text" name="calories" value="<c:out value="${userMeal.calories}"/>"></td>
            </tr>
        </table>
        <input type="submit" value="OK">
    </form>
</body>
</html>
