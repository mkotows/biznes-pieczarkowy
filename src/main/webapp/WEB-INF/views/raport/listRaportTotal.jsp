<%@include file="/resources/header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<h1>Raporty finansowy</h1>

<h2> Raport dla jednej hali pieczarkowej</h2>
<br><br>
<form method="post" action="/raport/one">

    <select name="hallId">

        <c:forEach items="${mushroomHalls}" var="hall">
            <option value="${hall.id}"> ${hall.name} </option>
        </c:forEach>

    </select>
    <br><br>

    <label> Data początkowa <input type="date" name="start">
    </label> <br><br>

    <label> Data końcowa <input type="date" name="end">
    </label> <br><br>
    <input type="submit" value="Generuj raport">
</form>



<br><br>
<h2> Raport ogólny</h2>

<form method="post" action="/raport/all">
    <label> Data początkowa <input type="date" name="start">
    </label> <br><br>

    <label> Data końcowa <input type="date" name="end">
    </label> <br><br>
    <input type="submit" value="Generuj raport">
</form>


<%@include file="/resources/footer.jsp" %>