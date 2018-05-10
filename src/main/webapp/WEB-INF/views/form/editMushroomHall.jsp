<%@include file="/resources/header.jsp" %>


<form:form method="post" modelAttribute="mushroomHall">
    <label>Name <form:input path="name"/></label>
    <p><form:errors path="name" cssClass="error"/> </p>
    <label>Description <form:input path="description"/></label>

    <input type="submit" value="Save">
</form:form>



<%@include file="/resources/footer.jsp" %>

