<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Sabr
  Date: 21.04.2023
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SCH Symbol info</title>
</head>
<body>

<h2>SCH Symbol info</h2>
<br>
<form:form action="saveSchSymbol" modelAttribute="schSymbol">

    <form:hidden path="id"/>

    SCH Symbol name <form:input path="name"/>
    <br><br>
    <input type="submit" value="OK">

</form:form>
</body>
</html>