<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>

<h2>Home Page</h2>
<hr>

<p>
    Welcome to home page
</p>

<hr>

<p>
    User: <security:authentication property="principal.username"/>
    <br><br>
    Role(s): <security:authentication property="principal.authorities"/>
</p>

<security:authorize access="hasRole('MANAGER')">
    <p>
        <a href="${pageContext.request.contextPath}/leaders">Leadership meeting</a>
        (Available only for managers)
        <br>
    </p>
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
    <p>
        <a href="${pageContext.request.contextPath}/systems">IT systems meeting</a>
        (Available only for admins)
    </p>
</security:authorize>
<hr>

<form:form action="${pageContext.request.contextPath}/logout"
           method="post">

    <input type="submit" value="Logout">

</form:form>


<%--<form action="${pageContext.request.contextPath}/logout"
      method="post">

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

    <input type="submit" value="Logout">
</form>--%>

</body>
</html>
