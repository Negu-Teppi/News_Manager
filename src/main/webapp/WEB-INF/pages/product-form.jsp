<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/16/2021
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${action=='add'}">
        <h3>Add Product</h3>
    </c:if>
    <mvc:form action="${pageContext.request.contextPath}/result" method="post" modelAttribute="product"
        enctype="multipart/form-data">
        <table>
            <tr>
                <td><mvc:label path="">Name</mvc:label></td>
                <td><mvc:input path="name"/></td>
            </tr>
            <tr>
                <td><mvc:label path="description">Description</mvc:label></td>
                <td><mvc:textarea path="description"/></td>
            </tr>
            <tr>
                <td><mvc:label path="category.id">Category</mvc:label></td>
                <td><mvc:select path="category.id">
                        <c:forEach items="${categories}" var="category">
                            <mvc:option value="${category.id}">${category.name}</mvc:option>
                        </c:forEach>
                    </mvc:select>
                </td>
            </tr>
            <tr>
                <td><label for="image">Image</label></td>
                <td><input type="file" name="files" id="image" multiple="multiple"/></td>
            </tr>
<%--            <tr>--%>
<%--                <td><label for="files">Product Images: </label></td>--%>
<%--                <td><input type="file" id="files" name="files" multiple="multiple"/></td>--%>
<%--            </tr>--%>
            <tr>
                <td colspan="2"><mvc:button type="submit">Submit</mvc:button></td>
            </tr>
        </table>
    </mvc:form>
</body>
</html>
