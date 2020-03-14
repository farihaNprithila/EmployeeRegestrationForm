<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Fariha Nawaz
  Date: 3/10/2020
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Employee Management Application </title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: #ff0088 ">
        <div >
            <a href="https://www.javaguides.net" class="navbar-brand"> Employee Management Application </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/all"
                   class="nav-link">Employees</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${user != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${user == null}">
                <form action="insert" method="post">
                    </c:if>



                        <caption>
                            <h2>
                                <c:if test="${user != null}">
                                    Edit User
                                </c:if>
                                <c:if test="${user == null}">
                                    Add New User
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${user != null}">
                            <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                        </c:if>
                    <fieldset class="form-group">
                        <label>User First Name</label> <input type="text"
                                                        value="<c:out value='${user.firstName}' />" class="form-control"
                                                        name="firstName" required="required">
                    </fieldset>
                        <fieldset class="form-group">
                            <label>User Last Name</label> <input type="text"
                                                            value="<c:out value='${user.lastName}' />" class="form-control"
                                                            name="lastName" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>User Name</label> <input type="text"
                                                            value="<c:out value='${user.username}' />" class="form-control"
                                                            name="username" required="required">
                        </fieldset>
                    <fieldset class="form-group">
                        <label>User Password</label> <input type="text"
                                                         value="<c:out value='${user.password}' />" class="form-control"
                                                         name="password">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>User Address</label> <input type="text"
                                                           value="<c:out value='${user.address}' />" class="form-control"
                                                           name="address">
                    </fieldset>
                        <fieldset class="form-group">
                            <label>User contact</label> <input type="text"
                                                               value="<c:out value='${user.contact}' />" class="form-control"
                                                               name="contact">
                        </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>