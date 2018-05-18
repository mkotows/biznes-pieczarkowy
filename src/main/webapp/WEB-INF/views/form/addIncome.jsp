<%@include file="/resources/header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<form:form method="post" modelAttribute="income">
    <label>Rodzaj grzyba <form:radiobuttons path="mushroom" items="${mushroomNames}"/></label>
    <p><form:errors path="mushroom" cssClass="error"/> </p>

    <label>Data <form:input path="date" type="date"/></label>
    <p><form:errors path="date" cssClass="error"/></p>

    <label>Cena za kg <form:input path="pricePerKg" id="pricePerKg" type="number" step="0.01" min="0" /></label>
    <p><form:errors path="pricePerKg" cssClass="error"/></p>

    <label>Ilośc kg <form:input path="weight" id="weight" type="number" step="0.5" min="0" /></label>
    <p><form:errors path="weight" cssClass="error"/></p>

    <label>Przychód całkowity <form:input path="totalIncome" id="totalIncome" type="number" readonly="true" /></label><br>

    <label>Hala pieczarkowa<form:select path="mushroomHall">
        <form:option value="0" label="Wszystkie"/>
        <form:options items="${mushroomHalls}" itemValue="id" itemLabel="name"/>
    </form:select></label>
    <br><br>
    <label>Dodatkowy opis <form:input path="description"/></label>
    <br><br>
    <input type="submit" value="Dodaj">
</form:form>


<script>

    var a = $('#weight').val();
    var b = $('#pricePerKg').val();
    $('#totalIncome').val(a*b);


    $('#weight').add('#pricePerKg').change(function () {
        var a = $('#weight').val();
        var b = $('#pricePerKg').val();

        $('#totalIncome').val(a*b);
    })

</script>


<%@include file="/resources/footer.jsp" %>