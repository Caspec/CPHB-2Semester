<%-- 
    Document   : view
    Created on : 27-02-2017, 19:47:48
    Author     : auron
--%>

<%@page import="data.CustomerMapper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.entity.Bottom"%>
<%@page import="domain.entity.Topping"%>
<%@page import="data.CupCakeMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View/Shop - JSP</title>
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

                    <div id="kurv">
                       <form name="formOrder" action="ControlOrder" method="POST">
                       <table id="kurvtable">
                <thead>
                    <tr>
                        <th>Top</th>
                        <th>&nbsp;Bottom</th>
                        <th>&nbsp;Price</th>
                        <th>&nbsp;Quantity</th>
                        <th>&nbsp;SubTotal</th>
                    </tr>
                </thead>
                <tbody id="orderlines">                    
                </tbody>
            </table>            
            
            <div id="cakes">
            </div>
            
            <p>&nbsp;Total: <span id="total"></span></p>
            
            &nbsp;<input id="ButtonOrderCakes" type="submit" value="Order">
                       </form>
                    </div>

                    <br /><br />Menu: 
                    <jsp:include page='menu.html'></jsp:include>
                        <br /><br />                                        
                        <h1>Welcome to the shop</h1>
                        <h2>The place where you can order on-the-go!</h2>
                        <br />
                        <p>You are now logged in.</p>
                    <% out.print(session.getAttribute("user"));%><br />
                    Today is <%= (new java.util.Date())%><br />
                    Copyright Lone's &copy;
                </div>
            </header>

            <div class="container">
            <div class="container-fluid">
                    
            <form id="order" method="post">
            
            <input type="hidden" name="origin" value="order">
            <% CupCakeMapper cm = new CupCakeMapper(); %>
            <h2>Tops</h2>
            <div id="tops">
                <%
                    ArrayList<Topping> thetops = cm.getAllTopping();
                    for (Topping top : thetops)
                    {
                        out.print("<div>");
                        out.print("<img src='img/" + top.getTopping_img() + "'>");
                        out.print("<p>" + top.getTopping_name() + "</p>");
                        out.print("<p>" + top.getTopping_price() + "</p>");
                        out.print("<input name='Top' class='cakepart' type='radio'>");
                        out.print("<input type='hidden' value='" + top.getTopping_id() + "'>");
                        out.print("</div>");
                    }
                %>
            </div>
            
            <h2>Bottoms</h2>        
            <div id="bottoms">
                <%
                    ArrayList<Bottom> thebottoms = cm.getAllBottom();
                    for (Bottom bottom : thebottoms)
                    {
                        out.print("<div>");
                        out.print("<img src='img/" + bottom.getBottom_img() + "'>");
                        out.print("<p>" + bottom.getBottom_name() + "</p>");
                        out.print("<p>" + bottom.getBottom_price() + "</p>");
                        out.print("<input name='Bottom' class='cakepart' type='radio'>");
                        out.print("<input type='hidden' value='" + bottom.getBottom_id() + "'>");
                        out.print("</div>");
                    }
                %>
            </div>
            
            <p>CakePrice: <span id="CakePrice">0</span>$    </p>
            <label>Quantity</label>
            <select id="quantity" name="quantity">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select>
            
            <br>
            
            <input id="ButtonAddCakes" type="button" value="Add cakes">
            
            <br>
                     
      
        </form>

     </div></div></div>
    </body>
</html>
