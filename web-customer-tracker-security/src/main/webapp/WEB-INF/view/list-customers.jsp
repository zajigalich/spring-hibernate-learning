<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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
                <th><a href="${sortLinkFirstName}">First Name</a></th>
                <th><a href="${sortLinkLastName}">Last Name</a></th>
                <th><a href="${sortEmail}">Email</a></th>
                <security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
                    <th>Action</th>
                </security:authorize>
            </tr>
            <c:if test="${customers != null}">
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
                        <security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">

                            <td>
                                <security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
                                    <a href="${updateLink}">Update</a>
                                </security:authorize>

                                <security:authorize access="hasRole('ADMIN')">
                                    |
                                    <a href="${deleteLink}"
                                       onclick="if (!(confirm('Are you sure you want to delete?'))) return false;">Delete</a>
                                </security:authorize>
                            </td>

                        </security:authorize>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </div>
</div>
<form:form action="${pageContext.request.contextPath}/logout"
           method="post">

    <input type="submit" value="Logout">

</form:form>

</body>
</html>
