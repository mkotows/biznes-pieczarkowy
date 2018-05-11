<%@include file="/resources/header.jsp" %>




<h2> Raport for One Mushroom Hall</h2>
<br><br>
<form method="post" action="/raport/one">

    <select name="halls">

        <c:forEach items="${mushroomHalls}" var="hall">
            <option value="${hall.id}"> ${hall.name} </option>
        </c:forEach>

    </select>
    <br><br>

    <input type="text" name="tekst">

    <label> Start date <input type="date" name="start">
    </label> <br><br>

    <label> End date <input type="date" name="end">
    </label> <br><br>
    <input type="submit" value="Create raport">
</form>



<br><br>
<h2> Raport for Mushroom Company</h2>

<form method="post" action="/raport/two">
    <label> Start date <input type="date" name="start">
    </label> <br><br>

    <label> End date <input type="date" name="end">
    </label> <br><br>
    <input type="submit" value="Create raport">
</form>


<%@include file="/resources/footer.jsp" %>

