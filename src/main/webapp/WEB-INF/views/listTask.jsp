<%@include file="/resources/header.jsp" %>

<br><br> <a href="/task/add"> Add new Task </a> <br><br>

<table>
    <tr>
        <td>Task</td>
        <td>Description</td>
        <td>Date</td>
        <td>Mushroom Hall</td>
        <td>Employees</td>
        <td>Duration</td>
        <td>Salary</td>
        <td>Total cost</td>
    </tr>
    <c:forEach items="${list}" var="task">
        <tr>
            <td>${task.task}</td>
            <td>${task.description}</td>
            <td>${task.date}</td>
            <td>${task.mushroomHall}</td>
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
