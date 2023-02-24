<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>

<h2>Home Page</h2>
<hr>

Welcome to home page

<form:form action="${pageContext.request.contextPath}/logout"
           method="post">

    <input type="submit" value="Logout">

</form:form>

</body>
</html>
