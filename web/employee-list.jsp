<%--
  Created by IntelliJ IDEA.
  User: Fariha Nawaz
  Date: 3/10/2020
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: #ff0088 ">
        <div style="color:#fbf6ff">
            <a class="navbar-brand"> Employee Management Application </a>
        </div>

        <ul class="navbar-nav">
            <li style="color:#fbf6ff"><a href="<%=request.getContextPath()%>/all"
                                         class="nav-link">Employees</a></li>
            <li style="color:#fbf6ff"><a href="<%=request.getContextPath()%>/new"
                                         class="nav-link">Add New Employee</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">

    <div class="container">
        <h3 class="text-center">List of Employee</h3>
        <hr>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>User Name</th>
                <th>Password</th>
                <th>Address</th>
                <th>Contact</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${listUser}">

                <tr>
                    <td>
                        <c:out value="${user.id}" />
                    </td>
                    <td>
                        <c:out value="${user.firstName}" />
                    </td>
                    <td>
                        <c:out value="${user.lastName}" />
                    </td>
                    <td>
                        <c:out value="${user.username}" />
                    </td>
                    <td>
                        <c:out value="${user.password}" />
                    </td>
                    <td>
                        <c:out value="${user.address}" />
                    </td>
                    <td>
                        <c:out value="${user.contact}" />
                    </td>
                    <td><a href="edit?id=<c:out value='${user.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/delete?id=<c:out value='${user.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
    </div>
</div>

<body>

</body>
</html>
