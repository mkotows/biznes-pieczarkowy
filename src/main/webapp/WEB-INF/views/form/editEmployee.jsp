<%@include file="/resources/header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>




<form:form method="post" modelAttribute="employee">
    <label>Imię <form:input path="name"/></label>
    <p><form:errors path="name" cssClass="error"/> </p>
    <label>Nazwisko <form:input path="surname"/></label>
    <p><form:errors path="surname" cssClass="error"/></p>
    <label>Email <form:input path="email"/></label>
    <p><form:errors path="email" cssClass="error"/></p>
    <label>Telefon <form:input path="phone"/></label>
    <input type="submit" value="Zapisz">
</form:form>



<%@include file="/resources/footer.jsp" %>

