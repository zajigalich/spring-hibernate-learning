<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Leaders Page</title>
</head>
<body>

<h3>Leaders Page</h3>

<hr>

<p>
  User: <security:authentication property="principal.username"/>
  <br>
  Role(s): <security:authentication property="principal.authorities"/>
</p>

<hr>
<p>
  This information is only available for managers
</p>

<hr>

<a href="${pageContext.request.contextPath}/">Home</a>

</body>
</html>
