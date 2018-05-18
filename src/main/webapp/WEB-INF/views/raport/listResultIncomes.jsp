<%@include file="/resources/header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<h1> Raport przychodów </h1>

${resultText}

<br>

<br>


<table>
    <tr class="headers">
        <td>Grzyb</td>
        <td>Data</td>
        <td>Cena za kg</td>
        <td>Waga</td>
        <td>Przychód całkowity</td>
        <td>Hala pieczarkowa</td>
        <td>Opis dodatkowy</td>
        <td>Edycja</td>
        <td>Usuwanie</td>
    </tr>
    <c:forEach items="${list}" var="income">
        <tr>
            <td>${income.mushroom}</td>
            <td>${income.date}</td>
            <td>${income.pricePerKg}</td>
            <td>${income.weight}</td>
            <td>${income.totalIncome}</td>
            <td> <c:choose>
                <c:when test="${income.mushroomHall==null}">Wszystkie</c:when>
                <c:otherwise>${income.mushroomHall.name}</c:otherwise>
            </c:choose> </td>
            <td>${income.description}</td>

            <td><a href="/income/edit/${income.id}"> edytuj </a></td>
            <td><a href="/income/delete/${income.id}"> usuń </a> </td>
        </tr>
    </c:forEach>
</table>



<%@include file="/resources/footer.jsp" %>