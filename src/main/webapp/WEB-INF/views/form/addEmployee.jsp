<%@include file="/resources/header.jsp" %>


<form:form method="post" modelAttribute="employee">
    <label>Name <form:input path="name"/></label>
    <p><form:errors path="name" cssClass="error"/> </p>
    <label>Surname <form:input path="surname"/></label>
    <p><form:errors path="surname" cssClass="error"/></p>
    <label>Email <form:input path="email"/></label>
    <p><form:errors path="email" cssClass="error"/></p>
    <label>Phone <form:input path="phone"/></label><<br>
    <input type="submit" value="Add">
</form:form>



<%@include file="/resources/footer.jsp" %>

