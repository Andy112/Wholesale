<%@ page import="com.andy.model.Cart" %>
<%@ page import="java.util.List" %>
<%@ page import="com.andy.model.ProductEntity" %>
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

        <div id="logo">
            <h1>Buy The Box</h1>
            <h2>Best Wholesalers</h2>
        </div>

        <div id="menu">
            <ul>
                <li><a href="/">Home</a></li>
                <li><a href="/">Products</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="/account">My Account</a></li>
                <li><a href="#">Contact Us</a></li>
            </ul>

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

        <div class="row">
            <div class="span8 offset2">
                <br/><br/><h5><strong>My Cart<strong/><h5/><br/>
                <!-- All Customers -->
                <%--      <%
                                      if (request.getSession().getAttribute("boxCart") != null){
                                          List<Cart> cart = (List<Cart>)request.getSession().getAttribute("boxCart");

                                          for(int i = 0; i< cart.size(); i++){

                                              if( cart.get(i).getQty() > 1 cart.get(i).getProduct().getItemId() ==  ){
                                                  cart.get(i).setQty(cart.get(i).getQty() + 1);
                                              }else  {
                                                  cart.get(i).setQty(1);

                                              }


                                          }
                                      }
                                  %>--%>


                <c:if test='<%= request.getSession().getAttribute("boxCart") != null%>'>
                    <table class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th>Item ID</th>
                            <th>Product Name</th>
                            <th>Weight</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Image</th>
                                <%--<th class="center">&nbsp;</th>--%>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items='<%= request.getSession().getAttribute("boxCart")%>' var="item" varStatus="loopStatus">
                            <tr>
                                <td>${loopStatus.index+1}</td>
                                <td>${item.product.itemName}</td>
                                <td>${item.product.itemWeight}</td>
                                <td>${item.product.itemPrice*item.qty}</td>

                                <td>${item.qty}</td>
                                    <%--<td class="center">
                                        <form action="/deleteFromCart/${product.id}" method="post"><input type="submit" class="btn btn-danger btn-mini" value="Delete"/></form>
                                    </td>--%>
                                <td><img width="50w%" src="${item.product.imageurl}"/></td>
                            </tr>
                        </c:forEach>
                        <tr >
                            <td colspan="5"><strong>Total Price: &pound;<%=
                            request.getSession().getAttribute("totalPrice")
                            %></stong></td>
                            <td class="pull-right"><strong><a href="/">Check Out</a></stong></td>
                            <td class="pull-right"><strong><a href="/">Continue Shopping</a></strong></td>
                        </tr>
                        <tr >
                            <td colspan="5"><strong>Choose Warehouse:</stong>
                                <form:form commandName="warehouseChosen" action="/checkout" method="get">
                            <form:select path="warehouseId">
                                    <c:forEach items="${warehousesList}" var="warehouse">
                                    <form:option value="${warehouse.warehouseId}" label="${warehouse.location}"/>
                                </c:forEach>
                                </form:select>
                                <button class="btn btn-danger" type="submit">Checkout</button>
                                </form:form>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </c:if>
            </div>
        </div>
    </div>
</div>

</body>
</html>