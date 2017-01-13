<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Courses</title>
</head>
<body>
<div>
    <br>Base for all courses: USD (as 1)
    <br>For latest courses: /latest
    <br><a href="/currencies/latest">/latest</a>
    <br>For specific date: /onDate={onDate} /where {onDate} like dd-mm-yyyy (e.g. 05-04-2010)/
    <br><a href="/currencies/onDate=12-05-2010">/onDate=12-05-2010</a>
    <br>For results from one date to another date: /fromDate={fromDate}&toDate={toDate} /where {fromDate} and {toDate} like dd-mm-yyyy (e.g. 05-04-2010)/
    <br><a href="/currencies/fromDate=12-05-2010&toDate=22-05-2010">/fromDate=12-05-2010&toDate=22-05-2010</a>
</div>
</body>
</html>