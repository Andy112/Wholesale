<%@ page import="com.andy.model.Cart" %>
<%@ page import="java.util.List" %>
<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
    <meta name="keywords" content="" />
    <link rel="stylesheet" type="text/css" href="assets/css/style.css" />

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

        <div id="logo">
            <h1>Buy The Box</h1>
            <h2>Best Wholesalers</h2>
        </div>

        <div id="menu">
            <ul>
                <li><a href="/" class="active">Home</a></li>
                <li><a href="/">Products</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="/account">My Account</a></li>
                <li><a href="#">Contact Us</a></li>
            </ul>
        </div>

    </div>
</div>




<div class="container"  id="main">


    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <div class="pull-right">
                <form:form commandName="search" action="/search">
                <form:input path="searchterm" class="form-control" type="text" placeholder="Search"/>
                </form:form>
            </div>
        </div>
    </div>
    <!-- Products -->
    <div class="row">
        <c:if test="${!empty productsList}">
            <c:forEach items="${productsList}" var="product">
                <div class="col-md-4">

                   <br/> <img src="${product.imageurl}" width="45%" height="45%"/>
                    <h5>Product Name: ${product.itemName}<h5/><br/>
                        Price: &pound;${product.itemPrice}<br/>
                    Weight: ${product.itemWeight}g<br/>
                   Status:  <c:if test="${product.itemStatus == true}">
                        <strong>In Stock</strong><br/>
                    </c:if>
                    <c:if test="${product.itemStatus == false}">
                        <strong>Out of Stock</strong><br/>
                    </c:if>
                        Description: ${product.itemDescription}<br/><br/>
                    <form:form commandName="boxCart" action="/cart/addToCart/${product.itemId}" method="post">

                     <form:hidden path="qty" value="1"/>
                        <a  href="javascript:;" onclick="parentNode.submit();" role="button" class="btn btn-danger">Add to Cart</a><br/>
                    </form:form>


                </div>
                <div class="clearfix visible-xs-block"></div>
            </c:forEach>
        </c:if>
    </div>
</div>
<div id="footer" class="fixed">
    Copyright &copy; 2015 Buy the box. All rights reserved.
</div>
</body>
</html>