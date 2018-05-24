<%@include file="/resources/header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<h1>Raporty przychodów</h1>

<h2> Raport dla jednej hali pieczarkowej</h2>
<br><br>
<form method="post" action="/raport/incomes/one">

    <select name="hallId" required>

        <c:forEach items="${mushroomHalls}" var="hall">
            <option value="${hall.id}"> ${hall.name} </option>
        </c:forEach>

    </select>
    <br><br>

    <label> Data początkowa <input type="date" name="start" required>
    </label> <br><br>

    <label> Data końcowa <input type="date" name="end" required>
    </label> <br><br>
    <input type="submit" value="Generuj raport">
</form>



<br><br>
<h2> Ogólny raport przychodów</h2>

<form method="post" action="/raport/incomes/all">
    <label> Data początkowa <input type="date" name="start" required>
    </label> <br><br>

    <label> Data końcowa <input type="date" name="end" required>
    </label> <br><br>
    <input type="submit" value="Generuj raport">
</form>


<%@include file="/resources/footer.jsp" %>