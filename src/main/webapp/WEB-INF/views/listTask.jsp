<%@include file="/resources/header.jsp" %>


<a href="/task/add"> <button type="button" class="btn btn-success"> Add new Task </button> </a> <br><br>

<table>
    <tr class="headers">
        <td>Name</td>
        <td>Description</td>
        <td>Date</td>
        <td>Mushroom Hall</td>
        <td>Employees</td>
        <td>Duration</td>
        <td>Salary</td>
        <td>Total cost</td>
        <td>Edit</td>
        <td>Delete</td>

    </tr>
    <c:forEach items="${list}" var="task">
        <tr>
            <td>${task.name}</td>
            <td>${task.description}</td>
            <td>${task.date}</td>
            <td> <c:choose>
                <c:when test="${task.mushroomHall==null}">All</c:when>
                <c:otherwise>${task.mushroomHall.name}</c:otherwise>
            </c:choose> </td>
            <td>${task.employees}</td>
            <td>${task.duration}</td>
            <td>${task.salary}</td>
            <td>${task.cost}</td>
            <td><a href="/task/edit/${task.id}"> edit </a></td>
            <td><a href="/task/delete/${task.id}"> delete </a> </td>
        </tr>
    </c:forEach>
</table>



<%@include file="/resources/footer.jsp" %>
