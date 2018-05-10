<%@include file="/resources/header.jsp" %>


<form:form method="post" modelAttribute="mushroomHall">
    <label>Name <form:input path="name"/></label>
    <p><form:errors path="name" cssClass="error"/> </p>
    <label>Description <form:input path="description"/></label><br>

    <input type="submit" value="Add">
</form:form>



<%@include file="/resources/footer.jsp" %>

