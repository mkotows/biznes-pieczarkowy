<%@include file="/resources/header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>



<form:form method="post" modelAttribute="expense">
    <label>Nazwa <form:radiobuttons path="name" items="${expenses}"/></label>
    <p><form:errors path="name" cssClass="error"/> </p>
    <label>Data <form:input path="date" type="date"/></label>
    <p><form:errors path="date" cssClass="error"/></p>
    <label>Koszt <form:input path="cost" type="number" step="0.01" min="0" /></label>
    <p><form:errors path="cost" cssClass="error"/></p>

    <label>Hala pieczarkowa<form:select path="mushroomHall">
        <form:option value="0" label="Wszystkie"/>
        <form:options items="${mushroomHalls}" itemValue="id" itemLabel="name"/>
    </form:select></label>
    <br><br>
    <label>Dodatkowy opis <form:input path="description"/></label>
    <br><br>
    <input type="submit" value="Dodaj">
</form:form>



<%@include file="/resources/footer.jsp" %>