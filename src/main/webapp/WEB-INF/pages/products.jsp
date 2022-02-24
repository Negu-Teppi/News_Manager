<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/16/2021
  Time: 5:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Page</title>
</head>
<body>
<h3>List Product</h3>
<button onclick="location.href ='<c:url value="/add-products"/>'">Add Account</button>
<table>
    <tr>
        <th>Name</th>
        <th>Image</th>
        <th>Category</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.name}</td>
            <td>
                <c:forEach items="${product.images}" var="image">
                    <table>
                        <tr>${image.imageName}</tr>
                    </table>
                </c:forEach>
            </td>
            <td>${product.category.name}</td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
