<%-- 
    Document   : redigerordre
    Created on : 03-04-2017, 15:51:23
    Author     : auron
--%>

<%@page import="domain.entity.getOrder"%>
<%-- 
    Document   : ordre
    Created on : 30-03-2017, 11:35:32
    Author     : auron
--%>

<%@page import="domain.entity.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.OrderMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Fog Admin | Rediger Ordre</title>
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link rel="icon" href="pics/geekfav.png" sizes="32x32" />
        <script src="http://cdn.ckeditor.com/4.6.1/standard/ckeditor.js"></script>

    </head>
    <body>

        <% OrderMapper om = new OrderMapper(); %>


        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp">Fog Admin</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp">Oversigt</a></li>
                        <li class="active"><a href="ordre.jsp">Ordre</a></li>
                        <li><a href="lager.jsp">Lager</a></li>
                        <li><a href="tilbud.jsp">Tilbud</a></li>
                        <li><a href="afdeling.jsp">Afdeling</a></li>
                    </ul>
                    <!-- Logout -->
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">Velkommen, <% out.print(session.getAttribute("username")); %></a></li>
                        <li><a href="../login.jsp">Logud</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <header id="header">
            <div class="container">
                <div class="row">
                    <div class="col-md-10">
                        <h1><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Fog Oversigt <small>Hold styr på din forretning</small></h1>
                    </div>
                    <div class="col-md-2">

                    </div>
                </div>
            </div>
        </header>

        <section id="breadcrumb">
            <div class="container">
                <ol class="breadcrumb">
                    <li class="active">Fog Rediger ordre</li>
                </ol>
            </div>
        </section>

        <section id="main">
            <div class="container">
                <div class="row">

                    <div class="col-md-3">

                        <div class="list-group">
                            <a href="index.html" class="list-group-item active main-color-bg">
                                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Oversigt
                            </a>
                            <a href="index.jsp" class="list-group-item"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> Oversigt</a>
                            <a href="ordre.jsp" class="list-group-item"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Ordre</a>
                            <a href="lager.jsp" class="list-group-item"><span class="glyphicon glyphicon-list" aria-hidden="true"></span> Lager</a>
                            <a href="tilbud.jsp" class="list-group-item"><span class="glyphicon glyphicon-usd" aria-hidden="true"></span> Tilbud</a>
                            <a href="afdeling.jsp" class="list-group-item"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Afdeling</a>
                        </div>

                        <div class="list-group">
                            <a href="index.jsp" class="list-group-item active main-color-bg">
                                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Tilføj indhold
                            </a>
                            <span class="list-group-item">
                                <div class="dropdown create">
                                    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                        Tilføj indhold
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                        <li><a type="button" data-toggle="modal" data-target="#addPage">Tilføj bruger</a></li>
                                        <li><a href="#">Tilføj materiale</a></li>
                                        <li><a href="#">Tilføj tilbud</a></li>
                                    </ul>
                                </div>
                            </span>
                        </div>

                    </div>
                    <div class="col-md-9">
                        <!-- Website Overview -->
                        <div class="panel panel-default">
                            <div class="panel-heading main-color-bg">
                                <h3 class="panel-title">Kunde infomation</h3>



                            </div>
                            <div class="panel-body">
                                <%
                                    int ordreid = Integer.parseInt(request.getParameter("oid"));
                                    getOrder oneOrder = om.getOrderPopup(ordreid);
                                %>
                                <table class="table table-striped table-hover"> 
                                    <tr>
                                        <td> <b>Kunde navn:</b> <% out.print(oneOrder.getUser_name()); %></td>
                                    </tr>
                                    <tr>
                                        <td> <b>Kunde email: </b><% out.print(oneOrder.getUser_email()); %> </td>
                                    </tr>
                                    <tr>
                                        <td> <b>Kunde adresse: </b><% out.print(oneOrder.getUser_adress()); %> </td>
                                    </tr>
                                    <tr>
                                        <td> <b>Kunde telefon: </b><% out.print(oneOrder.getUser_phone()); %> </tr>
                                    </tr>
                                    <tr>
                                        <td> <b>Kunde postnummer: </b><% out.print(oneOrder.getUser_zip()); %> </td>
                                    </tr>
                                </table>
                            </div>
                        </div>

                        <!-- Edit order data -->
                        <div id="cik" class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Rediger Ordre Data</h3>  
                            </div>
                            <div class="panel-body">
                                <div class="panel-body">

                                    <form class="form-inline" method="POST" action="../ControlEditData">
                                         <input type="hidden" id="orderId" name="orderId" value="<% out.print(oneOrder.getOrder_id()); %>">
                                        <table>            
                                            <div class="form-group">
                                                <tr>
                                                    <td><label for="lenght">Order Længde: </label></td>

                                                    <td><input type="text" class="form-control" name="lenght" value="<% out.print(oneOrder.getOrderdata_lenght()); %>"></td>
                                                </tr>
                                            </div>
                                            <div class="form-group">
                                                <tr>
                                                    <td><label  for="width">Order Brede: </label></td>

                                                    <td><input type="text" class="form-control" name="width" value="<% out.print(oneOrder.getOrderdata_width()); %>"></td>
                                                </tr>
                                            </div>
                                            <div class="form-group">
                                                <tr>
                                                    <td><label  for="height">Order Højde: </label></td>

                                                    <td> <input type="text" class="form-control" name="height" value="<% out.print(oneOrder.getOrderdata_height()); %>"></td>
                                                </tr>
                                            </div>
                                            <div class="form-group">
                                                <tr>
                                                    <td><label  for="floor">Order Gulv: </label></td>

                                                    <td><input type="text" class="form-control" name="floor" value="<% out.print(oneOrder.getOrderdata_floor()); %>"></td>
                                                </tr>
                                            </div>
                                            <div class="form-group">
                                                <tr>
                                                    <td><label  for="roof">Tag: </label></td>

                                                    <td><input type="text" class="form-control" name="roof" value="<% out.print(oneOrder.getOrderdata_roof()); %>"></td>
                                                </tr>
                                            </div>
                                            <div class="form-group">
                                                <tr>
                                                    <td><label  for="side">Side: </label></td>

                                                    <td><input type="text" class="form-control" name="side" value="<% out.print(oneOrder.getOrderdata_side()); %>"></td>
                                                </tr>
                                            </div>
                                            <tr>

                                                <td><button type="submit" class="btn btn-default">Rediger</button></td>

                                                <td><button type="submit" class="btn btn-default">Opdater</button></td>

                                            </tr>
                                        </table>

                                    </form>
                                </div>
                            </div>
                        </div>

                        <div id="cik" class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Rediger Ordre</h3>  
                            </div>
                            <div class="panel-body">
                                <div class="panel-body">

                                    <form class="form-inline" method="post" action="../ControlEditOrder">
                                        <table>            
                                            <div class="form-group">
                                                <tr>
                                                    <td><label for="orderId">Order Id: </label></td>
                                                <input type="hidden" id="orderId" name="orderId" value="<% out.print(oneOrder.getOrder_id()); %>">
                                                    <td><% out.print(oneOrder.getOrder_id()); %></td>
                                                </tr>
                                            </div>
                                            <div class="form-group">
                                                <tr>
                                                   <td><label  for="status">Order Status: </label></td>
                                                   
                                                   <td><select class="form-control" id="status" name="status">
                                                        <option value="<% out.print(oneOrder.getOrder_status()); %>"><% out.print(oneOrder.getOrder_status()); %></option>
                                                        <option value="Ikke godkendt">Ikke godkendt</option>
                                                        <option value="Godkendt">Godkendt</option>
                                                        <option value="Pakket">Pakket</option>
                                                        <option value="Afsendt">Afsendt</option>
                                                       </select></td>

                                                   <!-- <td><input type="status" class="form-control" id="status" value="<% out.print(oneOrder.getOrder_status()); %>"></td> -->
                                                </tr>
                                            </div>
                                            <div class="form-group">
                                                <tr>
                                                    <td><label  for="logi">Order Logicstic: </label></td>

                                                    <td><% out.print(oneOrder.isOrder_logistic()); %></td>
                                                </tr>
                                            </div>
                                            <div class="form-group">
                                                <tr>
                                                    <td><label  for="orderRecived">Order Modtaget: </label></td>

                                                    <td><% out.print(oneOrder.getOrder_recived()); %></td>
                                                </tr>
                                            </div>
                                            <div class="form-group">
                                                <tr>
                                                    <td><label  for="orderDelivered">Order Færdiggjordt: </label></td>

                                                    <td><% out.print(oneOrder.getOrder_delivered()); %></td>
                                                </tr>
                                            </div>
                                            
                                            <tr>

                                                <td><button type="submit" class="btn btn-default">Rediger</button></td>

                                                <td><button type="submit" class="btn btn-default">Opdater</button></td>

                                            </tr>
                                        </table>
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </section>

        <footer id="footer">
            <p>Copyright Sjov med skæg &copy; 2017</p>
        </footer>

        <!-- Modals -->

        <!-- Modal -->


        <script>
            CKEDITOR.replace('editor1');
        </script>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/sorterorder.js" type="text/javascript"></script>
    </body>
</html>
