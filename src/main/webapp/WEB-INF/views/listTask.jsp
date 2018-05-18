<%@include file="/resources/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>


<a href="/task/add"> <button type="button" class="btn btn-success"> Dodaj nowe zadanie </button> </a> <br><br>

<table>
    <tr class="headers">
        <td>Nazwa</td>
        <td>Opis dodatkowy</td>
        <td>Data</td>
        <td>Hala pieczarkowa</td>
        <td>Pracownicy</td>
        <td>Czas trwania</td>
        <td>Wynagrodzenie</td>
        <td>Koszt całkowity</td>
        <td>Edytowanie</td>
        <td>Usuwanie</td>

    </tr>
    <c:forEach items="${list}" var="task">
        <tr>
            <td>${task.name}</td>
            <td>${task.description}</td>
            <td>${task.date}</td>
            <td> <c:choose>
                <c:when test="${task.mushroomHall==null}">Wszystkie</c:when>
                <c:otherwise>${task.mushroomHall.name}</c:otherwise>
            </c:choose> </td>
            <td>${task.employees}</td>
            <td>${task.duration}</td>
            <td>${task.salary}</td>
            <td>${task.cost}</td>
            <td><a href="/task/edit/${task.id}"> edytuj </a></td>
            <td><a href="/task/delete/${task.id}"> usuń </a> </td>
        </tr>
    </c:forEach>
</table>



<%@include file="/resources/footer.jsp" %>
