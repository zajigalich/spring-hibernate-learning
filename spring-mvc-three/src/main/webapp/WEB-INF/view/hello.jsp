<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<h2>Hello World of Spring</h2>

<br/>

<%--<h2>Student Name: ${param.studentName}</h2>--%>
<h2>Student Name: ${param.get("studentName")}</h2>

<h2>Message: ${message}</h2>

</body>
</html>
