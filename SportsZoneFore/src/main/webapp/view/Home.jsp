<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="width=device-width, initial-scale=1; charset=ISO-8859-1">
<title>Sports cart</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>



<section>
<nav class="navbar navbar-default navbar-fixed-top top-nav-collapse">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"><img src="D:\cart.png" width="35px" class="img-circle" alt="logo"></a>
                </div>
                <div class="collapse navbar-collapse text-center" id="bs-example-navbar-collapse-1">
                    <div class="col-md-8 col-xs-12 nav-wrap">
                        <ul class="nav navbar-nav">
                            <li class=""><a href="" class="page-scroll">Home</a></li>
                            <li class=""><a href="" class="page-scroll">Services</a></li>
                            <li class=""><a href="" class="page-scroll">Works</a></li>
                            <li class=""><a href="" class="page-scroll">About</a></li>
                            <li><a href="#contact" class="page-scroll">Contact</a></li>
                            <li ><a href="Login">Login</a>
                            <c:if test="${userClickLoginHere}==true">
                           <jsp:include page="Login.jsp"></jsp:include>
                           </c:if></li>
                           <li><a href="Registration">Register</a>
                           <c:if test="${userClickRegisterHere}==true"> 
							<jsp:include page="Registration.jsp"></jsp:include>
							</c:if></li>
                        </ul>
                    </div>
        		<div class="col-sm-3 col-md-3">
        			<form class="navbar-form" role="search">
        			<div class="input-group">
            		<input type="text" class="form-control" placeholder="Search" name="q">
            		<div class="input-group-btn">
             	   		<button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
            		</div>
        			</div>
        			</form>
        			
    			</div>
                    <div class="social-media hidden-sm hidden-xs">
                        <ul class="nav navbar-nav">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
</section>

<a href="Login">Login </a>
<a href="Registration"> New user</a>
<hr color="blue">
<c:if test="${userClickLoginHere}==true">
<jsp:include page="Login.jsp"></jsp:include>
</c:if>
<c:if test="${userClickRegisterHere}==true"> 
<jsp:include page="Registration.jsp"></jsp:include>
</c:if>

</body>
</html>