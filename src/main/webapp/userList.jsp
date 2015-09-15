<%@ page import="ru.javawebinar.topjava.model.UserMeal" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>User list</title>
</head>
<body>
<h2>User list</h2><br/>
<a href="${pageContext.request.contextPath}/meal">Meal list</a>
<br/><br/>
<a href="${pageContext.request.contextPath}/index.html">Index</a>
<br/><br/>
<a href="${pageContext.request.contextPath}/add">Add</a>
<hr/>
<%
    final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
%>
<c:if test="${not empty message}">
    <strong>${message}</strong>
    <br/>
</c:if>

<table border="1">
    <tr>
        <th>Date/Time</th>
        <th>Description</th>
        <th>Calories</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
    <%
        List<UserMeal> list = (List<UserMeal>) request.getAttribute("userMeal");
        for (UserMeal meal : list) {
    %>
    <tr>
        <td><%=meal.getDateTime().format(formatter)%>
        </td>
        <td><%=meal.getDescription()%>
        </td>
        <td><%=meal.getCalories()%>
        </td>
        <td><a href="${pageContext.request.contextPath}/delete?date=<%=meal.getDateTime()%>">Del</a></td>
        <td><a href="${pageContext.request.contextPath}/edit?date=<%=meal.getDateTime()%>">Edit</a></td>
    </tr>
    <% } %>
</table>
</body>
</html>
