<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 26.06.2021
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>decs</th>
        <th>created</th>
        <th>action</th>
    </tr>
    <c:forEach items="${cars}" var="car">
        <tr>
            <td>${car.id}</td>
            <td>${car.modelName}</td>
            <td>${car.description}</td>
            <td>${car.createdOn}</td>
            <td>
                <a href="">usuń</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
