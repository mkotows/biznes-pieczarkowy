<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 09.05.18
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <%--<meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8"/>--%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mushroom Company</title>
    <link rel="stylesheet" type="text/css" href="/resources/styles.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

</head>
<body style="background-color: lightgray">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

<div class="menu" >
    <a href="/mushroomHall"><button class="btn btn-primary"> Hale pieczarkowe </button> </a>
    <a href="/employee"><button class="btn btn-primary"> Pracownicy </button> </a>
    <a href="/expense"><button class="btn btn-primary"> Wydatki </button> </a>
    <a href="/task"><button class="btn btn-primary"> Wynagrodzenia </button> </a>
    <a href="/income"><button class="btn btn-primary"> Przychody </button> </a>
    <a href="/raport/expenses"> <button class="btn btn-danger"> Raport wydatków</button></a>
    <a href="/raport/incomes"> <button class="btn btn-success"> Raport przychodów </button></a>
    <a href="/raport"> <button class="btn btn-primary"> Raport finansowy </button></a> <br>
</div>
<br>
<div>



