<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Fog Admin | Vis kunde ordren</title>
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <script src="http://cdn.ckeditor.com/4.6.1/standard/ckeditor.js"></script>
        <link rel="icon" href="img/geekfav.png" sizes="32x32" />
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script type="text/javascript">
            $("#btnPrint").live("click", function () {
                var divContents = $("#dvContainer").html();
                var printWindow = window.open('', '', 'height=600,width=800, left=300, top=100');
                printWindow.document.write('<html><head><title>DIV Contents</title>');
                printWindow.document.write('</head><body >');
                printWindow.document.write(divContents);
                printWindow.document.write('</body></html>');
                printWindow.document.close();
                printWindow.print();
            });
        </script>

    </head>
    <body>

        <nav class="navbar navbar-default">
            <div class="container">

            </div>
        </nav>

        <header id="header">
            <div class="container">
                <div class="row">
                    <div class="col-md-10">
                        <h1> Fog Trælast & Byggecenter <small>Her har du alle muligheder!</small></h1>
                    </div>
                    <div class="col-md-2">

                    </div>
                </div>
            </div>
        </header>



        <section id="main">
            <div class="container">
                <div class="row">

                    <div class="col-md-3">	
                    </div>
                    <div class="col-md-9">


                        <div class="container">
                            <br />

                            <form id="form1">
                                <div id="dvContainer">
                                    <input type="button" value="Print Ud" id="btnPrint" />
                                    <br> <br>  
                                    <% double price = (double) session.getAttribute("totalPrice");%>
                                    <% double moms = (double) session.getAttribute("moms");%>
                                    <% double totalPrice = price + moms;%>
                                    
                                    <h5>Pris: </h5><% out.print(price);%>
                                    <h5>Moms: </h5><% out.print(moms);%>
                                    <hr> 
                                    <h5>Totalpris: </h5><% out.print(totalPrice);%>
                                    
                                 
                                     
                                    <br /><br />

                                    <% int length = (int) session.getAttribute("length"); %>
                                    <% int width = (int) session.getAttribute("width"); %>

                                    <%
                                        out.print("<h2>Plantegning set oppefra</h2>");
                                        out.print("<div style='margin-left: " + (length) / 2 + "px;'> Længde: " + length + " cm.</div>");
                                        out.print("<svg width='" + width + "' height='" + width + "'>");
                                        out.print("<rect width='" + width + "' height='" + length + "' style='fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)'" + ">");
                                        out.print("<br><br>");
                                        out.print("<div> Bredde: " + width + " cm.</div>");
                                        out.print("</svg>");

                                    %>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <footer id="footer">
            <p>Copyright Sjov med skæg &copy; 2017</p>
        </footer>


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>





    </body>
</html>
