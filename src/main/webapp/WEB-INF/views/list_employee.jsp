<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 08.05.18
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of employees</title>
    <%--<style>--%>
        <%--tr,table,td{--%>
            <%--border: black solid 1px;--%>
            <%--padding: 7px;--%>
            <%--text-align: center;--%>
        <%--}--%>
    <%--</style>--%>
    <%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/styles.css">--%>
    <link rel="stylesheet" type="text/css" href="/resources/styles.css">

</head>
<body>

<table>
    <tr>
        <td>Name</td>
        <td>Surname</td>
        <td>Phone</td>
        <td>Email</td>
        <td>Edit</td>
        <td>Delete</td>

    </tr>
    <c:forEach items="${list}" var="employee">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.phone}</td>
            <td>${employee.email}</td>
            <td><a href="/employee/edit/${employee.id}"> edit </a></td>
            <td><a href="/employee/delete/${employee.id}"> delete </a> </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
