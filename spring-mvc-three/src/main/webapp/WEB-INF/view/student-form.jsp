<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Form</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
</head>
<body>
<h2>
    <form:form action="${pageContext.request.contextPath}/student/processForm" modelAttribute="student">
        First Name: <form:input path="firstName"/>
        <br>
        Last Name: <form:input path="lastName"/>
        <br>
        <form:select path="country">

            <form:options items="${theCountryOptions}"/>

            <%--<form:option value="India" label="India"/>
            <form:option value="Ukrane" label="Ukrane"/>--%>

        </form:select>

        Favorite Programming Language:
        <br>
        <form:radiobuttons path="favoriteLanguage" items="${student.languageOptions}"/>

        <%--<form:radiobutton path="favoriteLanguage" value="Java" label="Java"/>
        <br>
        <form:radiobutton path="favoriteLanguage" value="PHP" label="PHP"/>
        <br>
        <form:radiobutton path="favoriteLanguage" value="C#" label="C#"/>--%>
        <br>

        Operating Systems You Have Experience:
        <br>
        <form:checkboxes path="operatingSystems" items="${student.systemsOptions}"/>
        <br>
        <input type="submit" value="Submit">
    </form:form>
</h2>
</body>
</html>
