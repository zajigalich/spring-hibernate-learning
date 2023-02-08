<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello - Input Form</title>
</head>
<body>
<%--    <form action="<c:url value="/showForm"/>" method="get">--%>
    <form action="${pageContext.request.contextPath}/hello/processFormV3" method="get">
        <input type="text" name="studentName"
            placeholder="What`s your name?"/>
        <input type="submit"/>
    </form>

</body>
</html>
