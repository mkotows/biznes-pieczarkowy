<%@include file="/resources/header.jsp" %>


<form:form method="post" modelAttribute="expense">
    <label>Name <form:radiobuttons path="name" items="${expenses}"/></label>
    <p><form:errors path="name" cssClass="error"/> </p>
    <label>Date <form:input path="date" type="date"/></label>
    <p><form:errors path="date" cssClass="error"/></p>
    <label>Cost <form:input path="cost" type="number" step="0.01" min="0" /></label>
    <p><form:errors path="cost" cssClass="error"/></p>

    <label>Mushroom Hall<form:select path="mushroomHall">
        <form:option value="0" label="All"/>
        <form:options items="${mushroomHalls}" itemValue="id" itemLabel="name"/>
    </form:select></label>
    <br><br>
    <label>Description <form:input path="description"/></label>
    <br><br>
    <input type="submit" value="Save">
</form:form>



<%@include file="/resources/footer.jsp" %>