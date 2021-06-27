<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 27.06.2021
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <a href='<c:url value="/book-form/add"/>'>Dodaj pojazd</a>
</p>
<table>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>publisher</th>
        <th>rating</th>
        <th>description</th>
        <th>action</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.publisher.name}</td>
            <td>${book.rating}</td>
            <td>${book.description}</td>
            <td>
                <a href='<c:url value="/book-form/delete?id=${book.id}"/>'>usuń</a>
                <a href='<c:url value="/book-form/edit?id=${book.id}"/>'>edytuj</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
