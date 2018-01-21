<%-- 
    Document   : ordre
    Created on : 30-03-2017, 11:35:32
    Author     : auron
--%>

<%@page import="data.DBFacade"%>
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
        <title>Fog Admin | Ordre</title>
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link rel="icon" href="pics/geekfav.png" sizes="32x32" />
        <script src="http://cdn.ckeditor.com/4.6.1/standard/ckeditor.js"></script>

    </head>
    <body>
        
            <% DBFacade dbf = new DBFacade();
            OrderMapper om = new OrderMapper(); %>


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
                    <li class="active">Fog Ordre</li>
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
                                        <li><a type="button" data-toggle="modal" data-target="#addUser">Tilføj bruger</a></li>
                                        <li><a type="button" data-toggle="modal" data-target="#addItem">Tilføj materiale</a></li>
                                        <li><a type="button" data-toggle="modal" data-target="#addOffer">Tilføj tilbud</a></li>
                                    </ul>
                                </div>
                            </span>
                        </div>

                    </div>
                    <div class="col-md-9">
                        <!-- Website Overview -->
                        <div class="panel panel-default">
                            <div class="panel-heading main-color-bg">
                                <h3 class="panel-title">Ordre</h3>
                            </div>
                            <div class="panel-body">
                                <form action="">
                                    <table class="table table-striped table-hover">
                                        <tr>
                                            <th>Kategori</th>
                                            <th>Info</th>
                                            <th>Status</th>
                                            <th>Sorter</th>
                                        </tr> 
                                        <tr>
                                            <td>Ikke godkendt</td>
                                            <td>Når ordren kommer ind fra kunden.</td>
                                            <td><div class="btn btn-danger"></div></td>
                                            <td><input type="checkbox" name="Ikke godkendt" id="CIkkegodkendt" value="Ikke godkendt" checked="true"></td>
                                        </tr>
                                        <tr>
                                            <td>Godkendt</td>
                                            <td>Når kunde og sælger er enige om ordren.</td>
                                            <td><div class="btn btn-warning"></div></td>
                                            <td><input type="checkbox" name="Godkendt" id="CGodkendt" value="Godkendt" checked="true"></td>
                                        </tr>
                                        <tr>
                                            <td>Pakket</td>
                                            <td>Når ordren er igang med at blive pakket.</td>
                                            <td><div class="btn btn-info"></div></td>
                                            <td><input type="checkbox" name="Pakket" id="CPakket" value="Pakket" checked="true"></td>
                                        </tr>
                                        <tr>
                                            <td>Afsendt</td>
                                            <td>Når ordren er afsendt.</td>
                                            <td><div class="btn btn-success"></div></td>
                                            <td><input type="checkbox" name="Afsendt" id="CAfsendt" value="Afsendt" checked="true"></td>
                                        </tr>
                                    </table>
                                </form>
                            </div>
                        </div>

                        <!-- Latest Users -->
                        <div id="cik" class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Ikke godkendt ordre</h3>
                            </div>
                            <div class="panel-body">
                                <div class="panel-body">
                                    <table class="table table-striped table-hover">
                                        <tr>
                                            <th>Ordre Status</th>
                                            <th>Ordre ID</th>
                                            <th>Ordre Modtaget</th>
                                            <th>Rediger</th>
                                            <th>Slet</th>
                                        </tr> 
                                        <%

                                            ArrayList<Order> orderListNotApprove = om.getOrderByStatusNotApprove();

                                            for (Order order : orderListNotApprove) {
                                                out.print("<tr>");
                                                out.print("<td>" + "<div class='btn btn-danger'>" + order.getOrderStatus() + "</div></td>");
                                                out.print("<td style='font-weight: bold; font-size: large;'>" + "<a href='#' data-toggle='modal' data-target='#showOrder' id='" + order.getOrderId() + "'>" + order.getOrderId() + "</a></td>");
                                                out.print("<td>" + order.getOrderRecived() + "</td>");
                                                out.print("<td>" + "<a class='btn btn-warning' href='redigerordre.jsp?oid=" + order.getOrderId() + "'>" + "Rediger" + "</a></td>");
                                                out.print("<td>" + "<a class='btn btn-danger' href='sletordre.jsp?ordreid=" + order.getOrderId() + "'>" + "Slet" + "</a></td>");
                                                out.print("</tr>");
                                            }

                                        %>
                                    </table>
                                </div>
                            </div>
                        </div>

                        <div id="cgo" class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Godkendt ordre</h3>
                            </div>
                            <div class="panel-body">
                                <table class="table table-striped table-hover">
                                    <tr>
                                        <th>Ordre Status</th>
                                        <th>Ordre ID</th>
                                        <th>Ordre Modtaget</th>
                                        <th>Rediger</th>
                                        <th>Slet</th>
                                    </tr> 
                                    <%                          ArrayList<Order> orderListApprove = om.getOrderByStatusApprove();

                                        for (Order order : orderListApprove) {
                                            out.print("<tr>");
                                            out.print("<td>" + "<div class='btn btn-warning'>" + order.getOrderStatus() + "</div></td>");
                                            out.print("<td style='font-weight: bold; font-size: large;'>" + "<a href='#' data-toggle='modal' data-target='#showOrder' id='" + order.getOrderId() + "'>" + order.getOrderId() + "</a></td>");
                                            out.print("<td>" + order.getOrderRecived() + "</td>");
                                            out.print("<td>" + "<a class='btn btn-warning' href='redigerordre.jsp?oid=" + order.getOrderId() + "'>" + "Rediger" + "</a></td>");
                                            out.print("<td>" + "<a class='btn btn-danger' href='sletordre.jsp?ordreid=" + order.getOrderId() + "'>" + "Slet" + "</a></td>");
                                            out.print("</tr>");
                                        }

                                    %>
                                </table>
                            </div>
                        </div>

                        <div id="cpo" class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Pakket ordre</h3>
                            </div>
                            <div class="panel-body">
                                <table class="table table-striped table-hover">
                                    <tr>
                                        <th>Ordre Status</th>
                                        <th>Ordre ID</th>
                                        <th>Ordre Modtaget</th>
                                        <th>Rediger</th>
                                        <th>Slet</th>
                                    </tr> 
                                    <%                          ArrayList<Order> orderListPacked = om.getOrderByStatusPacked();

                                        for (Order order : orderListPacked) {
                                            out.print("<tr>");
                                            out.print("<td>" + "<div class='btn btn-info'>" + order.getOrderStatus() + "</div></td>");
                                            out.print("<td style='font-weight: bold; font-size: large;'>" + "<a href='#' data-toggle='modal' data-target='#showOrder' id='" + order.getOrderId() + "'>" + order.getOrderId() + "</a></td>");
                                            out.print("<td>" + order.getOrderRecived() + "</td>");
                                            out.print("<td>" + "<a class='btn btn-warning' href='redigerordre.jsp?oid=" + order.getOrderId() + "'>" + "Rediger" + "</a></td>");
                                            out.print("<td>" + "<a class='btn btn-danger' href='sletordre.jsp?ordreid=" + order.getOrderId() + "'>" + "Slet" + "</a></td>");
                                            out.print("</tr>");
                                        }

                                    %>
                                </table>
                            </div>
                        </div>

                        <div id="cao" class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Afsendt ordre</h3>
                            </div>
                            <div class="panel-body">
                                <table class="table table-striped table-hover">
                                    <tr>
                                        <th>Ordre Status</th>
                                        <th>Ordre ID</th>
                                        <th>Ordre Modtaget</th>
                                        <th>Ordre Leveret til kunde</th>
                                        <th>Ordre Modtaget af kunde</th>
                                    </tr> 
                                    <%                          ArrayList<Order> orderListShipped = om.getOrderByStatusShipped();

                                        for (Order order : orderListShipped) {
                                            out.print("<tr>");
                                            out.print("<td>" + "<div class='btn btn-success'>" + order.getOrderStatus() + "</div></td>");
                                            out.print("<td style='font-weight: bold; font-size: large;'>" + "<a href='#' data-toggle='modal' data-target='#showOrder' id='" + order.getOrderId() + "'>" + order.getOrderId() + "</a></td>");
                                            out.print("<td>" + order.getOrderRecived() + "</td>");
                                            out.print("<td>" + order.getOrderDelivered() + "</td>");
                                            out.print("<td>" + order.getOrderLogicstic() + "</td>");
                                            out.print("</tr>");
                                        }

                                    %>
                                </table>
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
        <div class="modal fade" id="showOrder" tabindex="-1" role="document"
             aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title" id="myModalLabel">Vis Ordre</h4>
                    </div>
                    <div class="modal-body">
                        <div class="displayOrder"></div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Luk</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modals -->
        
        <!-- AddOffer -->
        <div class="modal fade" id="addOffer" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form action="../ControlInsertOffer" method="POST">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">Tilføj et tilbud</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>Tilbudets navn</label>
                                <input type="text" class="form-control" placeholder="Navnet på tilbuddet" name="Offer_headline">
                            </div>
                            <div class="form-group">
                                <label>Tilbudets rabat</label>
                                <input type="text" class="form-control" placeholder="Rabatten" name="Offer_discount">
                            </div>
                            <div class="form-group">
                                <label>Tekst til tilbudet</label>
                                <textarea name="editor1" class="form-control" placeholder="Tekst til tilbudet"></textarea>
                            </div>
                            <div class="form-group">
                                <label>Billede til tilbudet</label>
                                <input type="text" class="form-control" placeholder="Billedets navn + type" name="Offer_img">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Luk</button>
                            <button type="submit" class="btn btn-primary">Gem tilbud</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
        <!-- Add Item -->
       <div class="modal fade" id="addItem" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form action="../ControlInsertItem" method="POST">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">Tilføj materiale</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>Materiale navn</label>
                                <input type="text" class="form-control" placeholder="Materiale navn" name="item_name">
                            </div>
                             <div class="form-group">
                                <label>Materiale info</label>
                                <input type="text" class="form-control" placeholder="Materiale info" name="item_info">
                            </div>
                            <div class="form-group">
                                <label>Materiale pris</label>
                                <input type="text" class="form-control" placeholder="Materiale pris" name="item_price">
                            </div>
                             <label for="FK_Item_id">Materiale Type</label>
                            <select name="FK_Item_id" class="dropdown">
                                <option value="4">Gulv</option>
                                <option value="3">Sider</option>
                                <option value="2">Tag</option>
                                <option value="1">Andet</option>
                                
                            </select>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Luk</button>
                            <button type="submit" class="btn btn-primary">Tilføj materiale</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <script>
            CKEDITOR.replace('editor1');
        </script>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/showorder.js" type="text/javascript"></script>
        <script src="js/sorterorder.js" type="text/javascript"></script>
    </body>
</html>
