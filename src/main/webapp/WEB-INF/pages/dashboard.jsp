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
    <link rel="stylesheet" type="text/css" href="assets/css/style.css" />
</head>

<body>
<div id="header">

    <div id="header_inner" class="fixed">

        <div id="menu">
            <ul>
                <li><a href="#" class="active">Home</a></li>
                <li><a href="/allOrder">Order</a></li>
                <li><a href="/allCustomers">Manage Customer</a></li>
                <li><a href="/allEmployees">Manage Employee</a></li>
                <li><a href="/allProducts">Manage Product</a></li>
                <li><a href="#">Manage Warehouse</a></li>
                <li><a href="#">Schedule Transfer</a></li>
                <li><a href="/adminlogin">Logout</a></li>
            </ul>
        </div>

    </div>
</div>

<div class="container" id ="main">

</div>
<div id="footer" class="fixed">
    Copyright &copy; 2015 Buy the box. All rights reserved.
</div>
</body>
</html>