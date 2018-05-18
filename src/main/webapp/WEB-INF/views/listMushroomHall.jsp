<%@include file="/resources/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>


<a href="/mushroomHall/add"> <button type="button" class="btn btn-success"> Dodaj halę pieczarkową </button> </a> <br><br>

<table>
    <tr class="headers">
        <td>Nazwa</td>
        <td>Opis dodatkowy</td>
        <td>Edycja</td>
        <td>Usuwanie</td>

    </tr>
    <c:forEach items="${list}" var="mushroomHall">
        <tr>
            <td>${mushroomHall.name}</td>
            <td>${mushroomHall.description}</td>
            <td><a href="/mushroomHall/edit/${mushroomHall.id}"> edytuj </a></td>
            <td><a href="/mushroomHall/delete/${mushroomHall.id}"> usuń </a> </td>
        </tr>
    </c:forEach>
</table>

<%@include file="/resources/footer.jsp" %>

