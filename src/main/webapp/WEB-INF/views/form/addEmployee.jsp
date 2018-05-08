<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 08.05.18
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
    <link rel="stylesheet" type="text/css" href="/resources/styles.css">
</head>
<body>

<form:form method="post" modelAttribute="employee">
    <label>Name <form:input path="name"/></label>
    <p><form:errors path="name" cssClass="error"/> </p>
    <label>Surname <form:input path="surname"/></label>
    <p><form:errors path="surname" cssClass="error"/></p>
    <label>Email <form:input path="email"/></label>
    <p><form:errors path="email" cssClass="error"/></p>
    <label>Phone <form:input path="phone"/></label>
    <input type="submit" value="Add">
</form:form>

</body>
</html>
