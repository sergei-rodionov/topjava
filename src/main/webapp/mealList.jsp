<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Meal list</title>
    <style>
        .normal {
            color: green;
        }

        .exceeded {
            color: red;
        }
    </style>
</head>
<body>
<section>
    <h2><a href="index.html">Home</a></h2>

    <h3>Meal list</h3>
    <a href="meals?action=create">Add Meal</a>
    <hr>
    <form id="filter" charset="utf-8" class="form-horizontal" accept-charset="UTF-8" method="post">
        <%--<div class="form-group">
            <label class="col-sm-2">From Date</label>
            <div class="col-sm-2"><input id="startDate" name="startDate" placeholder="Start Date"
                                         class="form-control date-picker" type="text" value=""/></div>
            <label class="col-sm-2">To Date</label>
            <div class="col-sm-2"><input id="endDate" name="endDate" placeholder="End Date"
                                         class="form-control date-picker" type="text" value=""/></div>
        </div>
        <div class="form-group">
            <label class="col-sm-2">From Time</label>
            <div class="col-sm-2"><input id="startTime" name="startTime" placeholder="Start Time"
                                         class="form-control time-picker" type="text" value=""/></div>
            <label class="col-sm-2">To Time</label>
            <div class="col-sm-2"><input id="endTime" name="endTime" placeholder="End Time"
                                         class="form-control time-picker" type="text" value=""/></div>
        </div>--%>
        <div class="form-group">
            <input type="hidden" name="filter" value="on">
            <label>Select user:</label>
            <div class="col-sm-2">
                <select name="user">
                    <c:forEach items="${userList}" var="user">
                        <jsp:useBean id="user" scope="page" type="ru.javawebinar.topjava.model.User"/>
                        <option value="${user.id}">${user.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
            <br/>
        <div class="form-group">
            <div class="col-sm-8">
                <button type="submit" class="btn btn-primary pull-right">Filter</button>
            </div>
        </div>
    </form>

    <hr/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${mealList}" var="meal">
            <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.UserMealWithExceed"/>
            <tr class="${meal.exceed ? 'exceeded' : 'normal'}">
                <td>
                        <%--<fmt:parseDate value="${meal.dateTime}" pattern="y-M-dd'T'H:m" var="parsedDate"/>--%>
                        <%--<fmt:formatDate value="${parsedDate}" pattern="yyyy.MM.dd HH:mm" />--%>
                    <%=TimeUtil.toString(meal.getDateTime())%>
                </td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td><a href="meals?action=update&id=${meal.id}">Update</a></td>
                <td><a href="meals?action=delete&id=${meal.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>