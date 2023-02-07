<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Main Menu</title>

    <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/resources/css/my-test.css">

    <script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>

</head>
<body>

<h2>Main Menu</h2>

<hr>

<a href="${pageContext.request.contextPath}/hello/showForm">Hello Form</a>


<br><br>

<input type="button" onclick="doSomeWork()" value="Click Me!">

<br><br>

<img src="${pageContext.request.contextPath}/resources/images/isaac.png">

</body>
</html>
