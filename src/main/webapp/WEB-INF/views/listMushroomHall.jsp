<%@include file="/resources/header.jsp" %>



<br><br> <a href="/mushroomHall/add"> Add new Mushroom Hall </a> <br><br>

<table>
    <tr>
        <td>Name</td>
        <td>Description</td>
        <td>Edit</td>
        <td>Delete</td>

    </tr>
    <c:forEach items="${list}" var="mushroomHall">
        <tr>
            <td>${mushroomHall.name}</td>
            <td>${mushroomHall.description}</td>
            <td><a href="/mushroomHall/edit/${mushroomHall.id}"> edit </a></td>
            <td><a href="/mushroomHall/delete/${mushroomHall.id}"> delete </a> </td>
        </tr>
    </c:forEach>
</table>

<%@include file="/resources/footer.jsp" %>

