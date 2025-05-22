<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h2>User List</h2>
<a href="/users/new">Add New User</a>
<table>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Password</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>
                <a href="/users/${user.id}/edit">Edit</a>
                <a href="/users/${user.id}/delete">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
