<%@include file="/resources/header.jsp" %>


<br><br> <a href="/expense/add"> Add new Expense </a> <br><br>

<table>
    <tr>
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
            <td>${expense.mushroomHall.name}</td>
            <td>${expense.description}</td>

            <td><a href="/expense/edit/${expense.id}"> edit </a></td>
            <td><a href="/expense/delete/${expense.id}"> delete </a> </td>
        </tr>
    </c:forEach>
</table>



<%@include file="/resources/footer.jsp" %>