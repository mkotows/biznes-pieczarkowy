<%@include file="/resources/header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>



<form:form method="post" modelAttribute="mushroomHall">
    <label>Nazwa <form:input path="name"/></label>
    <p><form:errors path="name" cssClass="error"/> </p>
    <label>Opis dodatkowy <form:input path="description"/></label>

    <input type="submit" value="Zapisz">
</form:form>



<%@include file="/resources/footer.jsp" %>

