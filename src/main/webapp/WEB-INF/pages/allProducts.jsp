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
        <div class="span8 offset2">
            <!-- All Products -->
            <c:if test="${!empty productList}">
                <h3>All Products</h3>
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th style="width: 19%">Name</th>
                        <th style="width: 25%">Description</th>
                        <th style="width: 8%">Weight (g)</th>
                        <th style="width: 8%">Price (&pound;)</th>
                        <th style="width: 10%">Status</th>
                        <th style="width: 8%">Total Stock</th>
                        <th style="width: 25%">Image</th>
                        <th style="width: 8%" class="center">&nbsp;</th>
                        <th style="width: 5%" class="center">&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${productList}" var="product" varStatus="loopStatus">
                        <tr>
                            <td>${product.itemId}</td>
                            <td>${product.itemName}</td>
                            <td>${product.itemDescription}</td>
                            <td>${product.itemWeight}</td>
                            <td>${product.itemPrice}</td>
                            <c:if test="${product.itemStatus == true}">
                            <td>In Stock</td>
                            </c:if>
                            <c:if test="${product.itemStatus == false}">
                                <td>Out of Stock</td>
                            </c:if>
                            <td>${product.totalStock}</td>
                            <td><img width="25%" src="${product.imageurl}"/></td>
                            <td class="center">
                                <form action="/deleteProduct/${product.itemId}" method="post"><input type="submit"
                                                                                                   class="btn btn-danger btn-mini"
                                                                                                   value="Delete"/></form>
                            </td>
                            <td>
                                <form action="${pageContext.request.contextPath}/editProduct/${product.itemId}" method="get"><input type="submit"
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

    <div class="row">
        <div class="span8 offset2">
            <h3>Add New Product</h3>



            <form:form method="post" action="/addProduct" commandName="product" class="form-horizontal">
                <div class="col-md-4 col-md-offset-0">

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
                    <div class="form-group">
                        <div class="controls">
                            <input type="submit" value="Add Product" class="btn btn-danger pull-right"/>
                        </div>
                    </div>

                </div>
                <div class="col-md-4 col-md-offset-1">
                    <c:forEach  items="${warehouseList}" var="warehouse">
                    <div class="form-group">
                        <form:label class="control-label"
                                    path="imageurl">Stock ( at ${warehouse.location}):</form:label>
                        <div class="controls">
                            <form:input class="form-control" path="${product.stockEntity}"/>
                        </div>
                    </div>
                    </c:forEach>

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