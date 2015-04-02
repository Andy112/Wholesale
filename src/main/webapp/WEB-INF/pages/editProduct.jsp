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
    <link rel="stylesheet" type="text/css" href="assets/css/style.css" />
</head>

<body>

<div id="header">

    <div id="header_inner" class="fixed">

        <div id="menu">
            <ul>
                <li><a href="/admin">Home</a></li>
                <li><a href="/allCustomers">Manage Customer</a></li>
                <li><a href="/allEmployees">Manage Employee</a></li>
                <li><a href="#" class="active">Manage Products</a></li>
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
            <h3>Edit User</h3>
            <form:form method="post" action="../editEmployee/{id}" commandName="employee" class="form-horizontal">
                <div class="form-group">

                    <form:input class="form-control" path="id" readonly="true"></form:input>

                    <div class="col-md-4" .col-md-offset-4>

                        <div class="form-group">
                            <form:label class="control-label" path="itemName">Product Name:</form:label>
                            <div class="controls">
                                <form:input class="form-control" path="itemName"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label class="control-label"
                                        path="itemDescription">Product Description:</form:label>
                            <div class="controls">
                                <form:input class="form-control" path="itemDescription"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <form:label class="control-label"
                                        path="itemWeight">Weight:</form:label>
                            <div class="controls">
                                <form:input class="form-control" path="itemWeight"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <form:label class="control-label"
                                        path="itemPrice">Price:</form:label>
                            <div class="controls">
                                <form:input class="form-control" path="itemPrice"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <form:label class="control-label"
                                        path="itemStatus">Status:</form:label>
                            <div class="controls">
                                <form:input class="form-control" path="itemStatus"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label class="control-label"
                                        path="totalStock">Total Stock:</form:label>
                            <div class="controls">
                                <form:label  path="totalStock"> </form:label>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label class="control-label"
                                        path="imageurl">Select Image:</form:label>
                            <div class="controls">
                                <form:input class="form-control" path="imageurl"/>
                            </div>
                        </div>

                <div class="form-group pull-right">
                    <div class="controls">
                        <input type="submit" value="Edit Product" class="btn btn-danger"/>
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