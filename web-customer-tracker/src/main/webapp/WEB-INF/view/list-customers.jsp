<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.my.util.SortUtil" %>
<html>
<head>
    <title>Customer List</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/static/css/style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relational Manager</h2>
    </div>
</div>

<div id="container">
    <div id="content">

        <input type="button"
               value="Add Customer"
               onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"
        />

        <form:form action="search" method="get">
            Search Customer: <input name="searchName" type="text"/>

            <input type="submit" value="Search" class="add-button"/>
        </form:form>

        <c:url var="sortLinkFirstName" value="/customer/list">
            <c:param name="sort" value="${SortUtil.FIRST_NAME}"/>
        </c:url>
        <c:url var="sortLinkLastName" value="/customer/list">
            <c:param name="sort" value="${SortUtil.LAST_NAME}"/>
        </c:url>
        <c:url var="sortEmail" value="/customer/list">
            <c:param name="sort" value="${SortUtil.EMAIL}"/>
        </c:url>

        <table>
            <tr>
                <th><a href="${sortLinkFirstName}">First Name</a> </th>
                <th><a href="${sortLinkLastName}">Last Name</a></th>
                <th><a href="${sortEmail}">Email</a></th>
                <th>Action</th>
            </tr>
            <c:forEach var="tempCustomer" items="${customers}">

                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>

                <c:url var="deleteLink" value="/customer/delete">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>

                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>
                    <td><a href="${updateLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                           onclick="if (!(confirm('Are you sure you want to delete?'))) return false;">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
