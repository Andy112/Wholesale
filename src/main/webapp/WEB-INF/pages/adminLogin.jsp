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
</head>

<body>


<div id="header">

    <div id="header_inner" class="fixed">

        <div id="logo">
            <h1>Buy The Box</h1>
        </div>

        <div id="menu">
                <ul>
                    <li><a href="#" class="active">Login</a></li>
                </ul>
        </div>

    </div>
</div>


<div class="container"  id="main">

    <!--Slider -->
    <div class="row">
        <div class="col-md-8">
            <form method="post" action="<c:url value='/j_spring_security_check'/>" class="form-horizontal">


            <div class="form-group">
               <br/><br/> <label>Email:</label>
                    <input type="email" name="email" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Password:</label>
                    <input name="password" class="form-control" type="password"/>
            </div>

            <div class="form-group">
                <div class="controls">
                    <input type="submit" value="Login" class="btn btn-danger"/>
                </div>
                </div>
                    </form>

                </div>
            </div>

        </div>
    <!-- Products -->
    <div class="row">
            <div class="col-md-4" col-md-offset-4>

            <div/>
    </div>
</div>
<div id="footer" class="fixed">
    Copyright &copy; 2015 Buy the box. All rights reserved.
</div>
</body>
</html>