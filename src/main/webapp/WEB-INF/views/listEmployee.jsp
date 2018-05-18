<%@include file="/resources/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>



<a href="/employee/add"><button type="button" class="btn btn-success"> Dodaj pracownika </button> </a> <br><br>

<table>
    <tr class="headers">
        <td>Imię</td>
        <td>Nazwisko</td>
        <td>Nr telefonu</td>
        <td>Email</td>
        <td>Edycja</td>
        <td>Usuwanie</td>

    </tr>
    <c:forEach items="${list}" var="employee">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.phone}</td>
            <td>${employee.email}</td>
            <td><a href="/employee/edit/${employee.id}"> edytuj </a></td>
            <td><a href="/employee/delete/${employee.id}"> usuń </a> </td>
        </tr>
    </c:forEach>
</table>

<%@include file="/resources/footer.jsp" %>

