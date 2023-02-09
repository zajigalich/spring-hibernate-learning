<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Form</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/customer-error.css">
<%-- 2 variants to add css to html --%>
    <style>
        .error1{
            color: deeppink;
        }
    </style>
</head>
<body>

<i>Fill out the form. Asterisk (*) means required</i>
<br>

<form:form action="/customer/processForm" modelAttribute="customer">
    Firstname: <form:input path="firstName"/>
    <br>
    Lastname(*): <form:input path="lastName"/>
    <form:errors cssClass="error1" path="lastName"/>
    <br>
    Free Passes: <form:input path="freePasses"/>
    <form:errors path="freePasses" cssClass="error"/>
    <br>
    Postal Code: <form:input path="postalCode"/>
    <form:errors path="postalCode" cssClass="error"/>
    <br>
    Course Code: <form:input path="courseCode"/>
    <form:errors path="courseCode" cssClass="error"/>
    <br>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>
