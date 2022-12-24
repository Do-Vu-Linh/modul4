<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Addreess</th>
    </tr>
    <c:forEach items="${requestScope.customers}" var="d"  >
        <tr>
            <td><c:out value="${d.getId()}"/></td>
            <td><c:out value="${d.getName()}"/></td>
            <td><c:out value="${d.getEmail()}"/></td>
            <td><c:out value="${d.getAddress()}"/></td>
        </tr>
    </c:forEach>
</table>
<form method="post" action="/customers/demo">
    <input name="hello"type="text"  >
    <input name="id"type="number"  >
    <button type="submit" > Convert</button>
</form>
<tr>
    <td><c:out value="${customers2}"/></td>

</tr>
</body>
</html>