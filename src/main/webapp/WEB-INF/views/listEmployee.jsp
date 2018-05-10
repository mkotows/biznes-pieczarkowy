<%@include file="/resources/header.jsp" %>



<br><br> <a href="/employee/add"> Add new Employee </a> <br><br>

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

<%@include file="/resources/footer.jsp" %>

