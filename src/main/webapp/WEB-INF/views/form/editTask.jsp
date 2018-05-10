<%@include file="/resources/header.jsp" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<form:form method="post" modelAttribute="task">

    <label>Task <form:select path="name" items="${tasks}"/></label>
    <p><form:errors path="name" cssClass="error"/> </p>
    <label>Description <form:textarea path="description"/></label><br><br>
    <label>Date <form:input path="date" type="date"/></label>
    <p><form:errors path="date" cssClass="error"/> </p>
    <label>Salary <form:input path="salary" id="salary" min="0" type="number" step="0.5"/></label>
    <p><form:errors path="salary" cssClass="error"/> </p>
    <label>Duration <form:input path="duration" id="duration" min="0" type="number" step="0.5"/></label>
    <p><form:errors path="duration" cssClass="error"/> </p>
    Salary per hour:
    <label id="lab">0</label>
    <br><br>
    <label>Employees<form:checkboxes path="employees" items="${employees}" id="checkboxes1" itemValue="id" itemLabel="surname"/>
    </label>
    <br><br>
    <label>Cost <form:input path="cost" min="0" readonly="true"/></label>
    <p><form:errors path="cost" id="cost" value="5" cssClass="error"/> </p>
    <br>
    <label>Mushroom Hall<form:select path="mushroomHall">
        <form:option value="0" label="All"/>
        <form:options items="${mushroomHalls}" itemValue="id" itemLabel="name"/>
    </form:select></label>

    <br><br>
    <input type="submit" value="Save">

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

