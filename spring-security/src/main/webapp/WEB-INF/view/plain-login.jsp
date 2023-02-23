<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Custom Login Page</title>
    <style>
        .failed {
            color: red;
        }
    </style>
</head>
<body>

<h3>Custom Login Page</h3>


<form:form action="${pageContext.request.contextPath}/authenticateUser" method="post">

    <c:if test="${param.error != null}">
        <i class="failed">Sorry! You have entered wrong username/password</i>
    </c:if>

    <p>
        User name: <input name="username" type="text"/>
    </p>
    <p>
        Password: <input name="password" type="password"/>
    </p>
    <input type="submit" value="Login">
</form:form>

</body>
</html>
