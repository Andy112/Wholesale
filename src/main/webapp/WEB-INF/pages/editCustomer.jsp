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
                <li><a href="#" class="active">Manage Customer</a></li>
                <li><a href="/allEmployees">Manage Employee</a></li>
                <li><a href="/allProducts">Manage Products</a></li>
                <li><a href="#">Manage Warehouse</a></li>
                <li><a href="#">Schedule Transfer</a></li>
                <li><a href="#">Logout</a></li>
            </ul>
        </div>

    </div>
</div>

<div class="container" id="main">


    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h1>Edit Employee</h1>
            <form:form method="post" action="../editEmployee/{id}" commandName="employee" class="form-horizontal">
                <div class="form-group">

                    <form:input class="form-control" path="id" readonly="true"></form:input>

                    <div class="form-group">
                        <form:label cssClass="control-label"
                                    path="customer.firstName">First Name:</form:label>
                        <div class="controls">
                            <form:input class="form-control" path="customer.firstName"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <form:label cssClass="control-label"
                                    path="customer.lastName">Last Name:</form:label>
                        <div class="controls">
                            <form:input class="form-control" path="customer.lastName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label class="control-label" path="customer.address">Address:</form:label>
                        <div class="controls">
                            <form:textarea cols="12" rows="3" path="customer.address" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label cssClass="control-label"
                                    path="customer.telephone">Telephone:</form:label>
                        <div class="controls">
                            <form:input class="form-control" path="customer.telephone"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <form:label class="control-label" path="customer.dob">Date of Birth:</form:label>
                        <div class="controls">
                            <form:input path="customer.dob" type="text" class="form-control" placeholder="YYYY-MM-DD"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label class="control-label" path="customer.gender">Gender:</form:label>
                        <div class="controls">
                            <form:select path="customer.gender" class="form-control">
                                <form:option value="Male" label="Male"/>
                                <form:option value="Female" label="Female"/>
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:hidden path="role.id" value="1" />
                        <form:label class="control-label"
                                    path="email">Email:</form:label>
                        <div class="controls">
                            <form:input class="form-control" path="email" type="email"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <form:label class="control-label" path="password">Password:</form:label>
                        <div class="controls">
                            <form:input path="password" class="form-control" type="password"/>
                        </div>
                    </div>

                <div class="form-group pull-right">
                    <div class="controls">
                        <input type="submit" value="Edit Customer" class="btn btn-danger"/>
                    </div>
                </div>
            </form:form>


        </div>
    </div>

</div>
<div id="footer" class="fixed">
    Copyright &copy; 2015 Buy the box. All rights reserved.
</div>
</body>
</html>