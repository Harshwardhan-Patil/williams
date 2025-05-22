<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>
    <h2>${user.id == 0 ? "Add New User" : "Edit User"}</h2>

    <form method="post" action="${user.id == 0 ? '/users' : '/users/' + user.id}">
        <input type="hidden" name="id" value="${user.id}" />

        <label for="username">Username:</label><br/>
        <input type="text" id="username" name="username" value="${user.username}" required /><br/><br/>

        <label for="password">Password:</label><br/>
        <input type="password" id="password" name="password" value="${user.password}" required /><br/><br/>

        <input type="submit" value="${user.id == 0 ? 'Create' : 'Update'}" />
        <a href="/users">Cancel</a>
    </form>
</body>
</html>
