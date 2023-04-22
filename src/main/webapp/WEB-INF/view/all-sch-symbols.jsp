<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sabr
  Date: 19.04.2023
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All SCH Symbols</title>
</head>
<body>
<h2>All SCH Symbols</h2>

<input type="button" value="Add" onclick="window.location.href = '/ilec/addNewSchSymbol'"/>

<br>

<table>
    <tr>
        <th>ID</th>
        <th>SCH Symbol name</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="schSymbol" items="${allSchSymbols}">
        <c:url var="updateButton" value="/updateSchSymbol">
            <c:param name="schSymbolId" value="${schSymbol.id}"/>
        </c:url>
        <c:url var="deleteButton" value="/deleteSchSymbol">
            <c:param name="schSymbolId" value="${schSymbol.id}"/>
        </c:url>
        <tr>
            <td>${schSymbol.id}</td>
            <td>${schSymbol.name}</td>
            <td>
                <input type="button" value="Update" onClick="window.location.href = '${updateButton}'"/>
                <input type="button" value="Delete" onClick="window.location.href = '${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>
</table>

<br>

</body>
</html>
