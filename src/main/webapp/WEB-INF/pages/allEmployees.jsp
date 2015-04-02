<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Buy the Box</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css"/>
</head>

<body>

<div id="header">

    <div id="header_inner" class="fixed">

        <div id="menu">
            <ul>
                <li><a href="/admin">Home</a></li>
                <li><a href="/allOrder">Order</a></li>
                <li><a href="/allCustomers">Manage Customer</a></li>
                <li><a href="#" class="active">Manage Employee</a></li>
                <li><a href="/allProducts">Manage Products</a></li>
                <li><a href="#">Manage Warehouse</a></li>
                <li><a href="#">Schedule Transfer</a></li>
                <li><a href="/adminlogin">Logout</a></li>
            </ul>
        </div>

    </div>
</div>

<div class="container" id="main">


    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h3 class="fixed">Add User</h3>
            <form:form method="post" action="/addEmployee" commandName="employee" class="form-horizontal">
                <div class="form-group">
                    <form:label class="control-label"
                                path="employee.firstName">First Name:</form:label>
                    <div class="controls">
                        <form:input class="form-control" path="employee.firstName"/>
                    </div>
                </div>

                <div class="form-group">
                    <form:label class="control-label"
                                path="employee.lastName">Last Name:</form:label>
                    <div class="controls">
                        <form:input class="form-control" path="employee.lastName"/>
                    </div>
                </div>
                <div class="form-group">
                    <form:hidden path="role.id" value="2"/>
                    <form:label class="control-label"
                                path="email">Email:</form:label>
                    <div class="controls">
                        <form:input class="form-control" path="email" type="email"/>
                    </div>
                </div>
                <div class="form-group">
                    <form:label class="control-label"
                                path="password">Password:</form:label>
                    <div class="controls">
                        <form:input class="form-control" path="password" type="password"/>
                    </div>
                </div>
                <div class="form-group">

                    <form:label class="control-label"
                                path="employee.location">Location:</form:label>
                    <div class="controls">
                        <form:select class="form-control" path="employee.location">
                            <c:forEach items="${warehouseList}" var="warehouse">
                            <form:option  path="employee.location" value="${warehouse.location}" label="${warehouse.location}"/>
                            </c:forEach>
                                </form:select>
                    </div>
                </div>

                <div class="form-group pull-right">
                    <div class="controls">
                        <input type="submit" value="Create User" class="btn btn-danger"/>
                    </div>
                </div>
            </form:form>


        </div>
    </div>


    <div class="row">
        <div class="span8 offset2">
            <!-- All Employees -->
            <c:if test="${!empty accountsList}">
                <h3>All Users</h3>
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Location</th>
                        <th>Email</th>
                        <th style="width: 8%" class="center">&nbsp;</th>
                        <th style="width: 5%" class="center">&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${accountsList}" var="accounte" varStatus="loopStatus">
                        <tr>
                            <td>${accounte.employee.firstName} ${accounte.employee.lastName}</td>
                            <td>${accounte.employee.location}</td>
                            <td>${accounte.email}</td>
                            <td>
                               <form action="/deleteEmployee/${accounte.id}" method="post"><input type="submit"
                                                                                                   class="btn btn-danger btn-mini"
                                                                                                   value="Delete"/>
                                </form>
                            </td>
                            <td>
                                <form action="${pageContext.request.contextPath}/editEmployee/${accounte.id}" method="get"><input type="submit"
                                                                                                   class="btn btn-success btn-mini"
                                                                                                   value="Edit"/>
                                </form>
                            </td>
                        </tr>


                    </c:forEach>


                    </tbody>
                </table>
            </c:if>


        </div>
    </div>
</div>
<div id="footer" class="fixed">
    Copyright &copy; 2015 Buy the box. All rights reserved.
</div>
</body>
</html>