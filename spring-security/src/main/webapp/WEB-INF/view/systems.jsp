<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Systems Page</title>
</head>
<body>

<h3>Systems Page</h3>

<hr>

<p>
  User: <security:authentication property="principal.username"/>
  <br>
  Role(s): <security:authentication property="principal.authorities"/>
</p>

<hr>
<p>
  This information is only available for admins
</p>

<hr>

<a href="${pageContext.request.contextPath}/">Home</a>

</body>
</html>
