<%@include file="/resources/header.jsp" %>

${resultText}

<br>
<h2> Salaries </h2>
<br>

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
    <c:forEach items="${tasks}" var="task">
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


<br>
<h2> Expenses </h2>
<br>

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
    <c:forEach items="${expenses}" var="expense">
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