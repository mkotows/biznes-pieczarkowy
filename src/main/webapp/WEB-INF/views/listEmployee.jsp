<%@include file="/resources/header.jsp" %>



<a href="/employee/add"><button type="button" class="btn btn-success"> Add new Employee </button> </a> <br><br>

<table>
    <tr class="headers">
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

