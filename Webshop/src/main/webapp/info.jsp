<%-- 
    Document   : view
    Created on : 27-02-2017, 19:47:48
    Author     : auron
--%>

<%@page import="domain.entity.Order"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.entity.Bottom"%>
<%@page import="domain.entity.Topping"%>
<%@page import="data.CupCakeMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Info - JSP</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="img/geekfav.png" sizes="32x32" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="script/basket_new.js" type="text/javascript"></script>
        
    </head>
    <body>


        <div id="wrapper">
            <header class="container">
                <div class="jumbotron">

                    <img src="img/logo.png" alt="logo" class="img">

                    <br /><br />Menu: 
                    <jsp:include page='menu.html'></jsp:include>
                        <br /><br />                                        
                        <h1>Welcome to the shop</h1>
                        <h2>The place where you can order on-the-go!</h2>
                        <br />
                        <p>You are now logged in.</p>
                    <% out.print(session.getAttribute("customer"));%><br />
                    Today is <%= (new java.util.Date())%><br />
                    Copyright Lone's &copy;
                </div>
            </header>

            <div class="container">
                
            <div class="container-fluid">
                    
           <% 
          
            //List myList = (List) session.getAttribute("basket");
            
            //for (Object item : myList) 
            //{
            //    out.print(item.toString());
            //}
            
            
           
          %>

     </div></div></div>
    </body>
</html>
