<%@include file="/resources/header.jsp" %>


<a href="/expense/add"> <button type="button" class="btn btn-success"> Add new Expense </button> </a> <br><br>

<table>
    <tr class="headers">
        <td>Name</td>
        <td>Cost</td>
        <td>Date</td>
        <td>MushroomHall</td>
        <td>Description</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${list}" var="expense">
        <tr>
            <td>${expense.name}</td>
            <td>${expense.cost}</td>
            <td>${expense.date}</td>
            <td> <c:choose>
                <c:when test="${expense.mushroomHall==null}">All</c:when>
                <c:otherwise>${expense.mushroomHall.name}</c:otherwise>
            </c:choose> </td>
            <td>${expense.description}</td>

            <td><a href="/expense/edit/${expense.id}"> edit </a></td>
            <td><a href="/expense/delete/${expense.id}"> delete </a> </td>
        </tr>
    </c:forEach>
</table>



<%@include file="/resources/footer.jsp" %>