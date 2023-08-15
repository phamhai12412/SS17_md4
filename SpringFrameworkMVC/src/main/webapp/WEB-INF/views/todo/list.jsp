<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1>Danh sách công việc</h1>
<a href="TodoController/add">add</a>

<form action="/TodoController/search/" method="get">
    <input type="text" name="tk">
    <button type="submit">Search</button>
</form>


<table border="10" cellpadding="10" cellspacing="10">
    <thead>
    <tr>
        <th>STT</th>
        <th>Content</th>
        <th>Status</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${todolist}" var="t" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${t.content}</td>
            <td>${t.status}</td>
            <td><a href="TodoController/edit/${t.id}">Edit</a></td>
            <td><a onclick="return confirm('Are u sure to delete this item?')" href="TodoController/delete/${t.id}">Delete</a></td>
        </tr>
    </c:forEach >

    </tbody>
</table>
</body>
</html>
