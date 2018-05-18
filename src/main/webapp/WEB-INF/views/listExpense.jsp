<%@include file="/resources/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>


<a href="/expense/add"> <button type="button" class="btn btn-success"> Dodaj wydatek </button> </a> <br><br>

<table>
    <tr class="headers">
        <td>Nazwa</td>
        <td>Koszt</td>
        <td>Data</td>
        <td>Hala pieczarkowa</td>
        <td>Opis dodatkowy</td>
        <td>Edycja</td>
        <td>Usuwanie</td>
    </tr>
    <c:forEach items="${list}" var="expense">
        <tr>
            <td>${expense.name}</td>
            <td>${expense.cost}</td>
            <td>${expense.date}</td>
            <td> <c:choose>
                <c:when test="${expense.mushroomHall==null}">Wszystkie</c:when>
                <c:otherwise>${expense.mushroomHall.name}</c:otherwise>
            </c:choose> </td>
            <td>${expense.description}</td>

            <td><a href="/expense/edit/${expense.id}"> edytuj </a></td>
            <td><a href="/expense/delete/${expense.id}"> usuń </a> </td>
        </tr>
    </c:forEach>
</table>



<%@include file="/resources/footer.jsp" %>