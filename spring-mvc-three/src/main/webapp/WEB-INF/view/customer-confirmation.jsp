<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Confirmation</title>
</head>
<body>
<h2>
    Customer is confirmed: ${customer.firstName} ${customer.lastName}
    <br>
    Free Passes: ${customer.freePasses}
    <br>
    Postal Code: ${customer.postalCode}
    <br>
    Course Code: ${customer.courseCode}
    <br>
</h2>
</body>
</html>
