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
                <li><a href="#" class="active">Order</a></li>
                <li><a href="/allCustomers">Manage Customer</a></li>
                <li><a href="/allEmployees">Manage Employee</a></li>
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
        <div class="span8 offset2">
            <!-- All Orders -->
            <c:if test="${!empty orderList}">
                <h3>All Users</h3>
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>Order Id</th>
                        <th>Order Date</th>
                        <th>Order Status</th>
                        <th>Order Item</th>
                        <th>Order Quantity</th>
                        <th>Customer Name</th>
                        <th style="width: 8%" class="center">&nbsp;</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${orderList}" var="ord" varStatus="loopStatus">
                        <tr>
                            <td>${ord.orderId}</td>
                            <td>${ord.orderDate}</td>
                            <td>${ord.orderStatus}</td>
                            <td>${ord.orderItem}</td>
                            <td>${ord.orderQuantity}</td>
                            <td>${ord.customer.firstName} ${ord.customer.lastName}</td>
                            <td>
                               <form action="/deleteOrder/${ord.orderId}" method="post"><input type="submit"
                                                                                                   class="btn btn-danger btn-mini"
                                                                                                   value="Cancel"/>
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