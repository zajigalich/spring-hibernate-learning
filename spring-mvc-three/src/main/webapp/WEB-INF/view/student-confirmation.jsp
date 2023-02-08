<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="student" scope="request" type="com.my.mvc.models.Student"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>

<h2>Confirmed, ${student.firstName} ${student.lastName}</h2>
<h2>Country: ${student.country}</h2>
<h2>Favorite Language: ${student.favoriteLanguage}</h2>
<h2>Operating Systems:
    <br>
    <ul>
        <c:forEach items="${student.operatingSystems}" var="temp">
            <li>${temp}</li>
        </c:forEach>
    </ul>
</h2>
</body>
</html>
