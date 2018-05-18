<%@include file="/resources/header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<form:form method="post" modelAttribute="task">

    <label>Nazwa <form:select path="name" items="${tasks}"/></label>
    <p><form:errors path="name" cssClass="error"/> </p>
    <label>Opis <form:textarea path="description"/></label><br><br>
    <label>Data <form:input path="date" type="date"/></label>
    <p><form:errors path="date" cssClass="error"/> </p>
    <label>Wynagrodzenie <form:input path="salary" id="salary" min="0" type="number" step="0.5"/></label>
    <p><form:errors path="salary" cssClass="error"/> </p>
    <label>Czas pracy <form:input path="duration" id="duration" min="0" type="number" step="0.5"/></label>
    <p><form:errors path="duration" cssClass="error"/> </p>
    Godzinówka:
    <label id="lab">0</label>
    <br><br>
    <label>Pracownicy<form:checkboxes path="employees" items="${employees}" id="checkboxes1" itemValue="id" itemLabel="surname"/>
    </label>
    <br><br>
    <label>Koszt całkowity <form:input path="cost" min="0" readonly="true"/></label>
    <p><form:errors path="cost" id="cost" value="5" cssClass="error"/> </p>
    <br>
    <label>hala pieczarkowa<form:select path="mushroomHall">
        <form:option value="0" label="Wszystkie"/>
        <form:options items="${mushroomHalls}" itemValue="id" itemLabel="name"/>
    </form:select></label>

    <br><br>
    <input type="submit" value="Zapisz">

</form:form>


<script>

    var a = $('#salary').val();
    var n = $("input:checked").length;

    $("#cost").val(n*a);

    var b = $('#duration').val();
    var result = (a/b).toFixed(2);
    $('#lab').text(result);

    $("#salary").add('#duration').change(function () {

        var a = $('#salary').val();
        var b = $('#duration').val();
        // var result = Math.round((a/b) *100) /100;
        var result = (a/b).toFixed(2);

        $('#lab').text(result);
    });



    // var countChecked = function() {
    //
    //     var a = $('#salary').val();
    //     var n = $("input:checked").length;
    //     $("#cost").val(n*a);
    // };
    // countChecked();

    $("input[type=checkbox]").on("click", function () {
        var a = $('#salary').val();
        var n = $("input:checked").length;
        $("#cost").val(n*a);
    });

    $("#salary").change(function () {
        var a = $('#salary').val();
        var n = $("input:checked").length;
        $("#cost").val(n*a);
    });

</script>


<%@include file="/resources/footer.jsp" %>

