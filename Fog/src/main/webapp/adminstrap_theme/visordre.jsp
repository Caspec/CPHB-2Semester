

<%@page import="domain.business.Calc"%>
<%@page import="domain.entity.Item"%>
<%@page import="domain.entity.OrderDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.DBFacade"%>
<%@page import="domain.entity.getOrder"%>
<%@page import="domain.entity.Order"%>
<%@page import="data.OrderMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <title>Vis ordre</title>
    </head>
    <body>
        
        <% 
            DBFacade dbf = new DBFacade();
            Calc c = new Calc();
        %>

        <%

            int ordreid = Integer.parseInt(request.getParameter("id"));

        %>

        <form id="form1">
            <div id="dvContainer">
        <input type="button" value="Print Ud" id="btnPrint" />
        
        <%            getOrder oneOrder = dbf.getOrderPopup(ordreid);

            out.print("<h1>Kunde information</h1>");
            out.print("<table class='table table-striped table-hover'>");
            out.print("<tr>");
            out.print("<td>Kunde navn: " + oneOrder.getUser_name() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td> Kunde email: " + oneOrder.getUser_email() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td> Kunde adresse: " + oneOrder.getUser_adress() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td> Kunde telefon: " + oneOrder.getUser_phone() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>Kunde postnummer: " + oneOrder.getUser_zip() + "</td>");
            out.print("</tr>");
            out.print("</table>");

            out.print("<h1>Ordren</h1>");
            out.print("<table class='table table-striped table-hover'>");
            out.print("<tr>");
            out.print("<td>Ordre ID: " + oneOrder.getOrder_id() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>Ordre status: " + oneOrder.getOrder_status() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>Ordre logistik: " + oneOrder.isOrder_logistic() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>Ordre modtaget: " + oneOrder.getOrder_recived() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>Ordre afleveret: " + oneOrder.getOrder_delivered() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>Ordre længde: " + oneOrder.getOrderdata_lenght() + " cm" + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>Ordre bredde: " + oneOrder.getOrderdata_width() + " cm" + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>Ordre højde: " + oneOrder.getOrderdata_height() + " cm" + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>Ordre gulv: " + oneOrder.getOrderdata_floor() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>Ordre tag: " + oneOrder.getOrderdata_roof() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>Ordre vægge: " + oneOrder.getOrderdata_side() + "</td>");
            out.print("</tr>");
            out.print("</table>");

            
            ArrayList<OrderDetail> alod = dbf.getAllOrderDetailById(ordreid);
            double price = 0.0;
            double tax = 0.0;
            double totalPrice = 0.0;
            
            System.out.println(alod);
            
            out.print("<h1>Genereret stykliste</h1>");
            out.print("<table class='table table-striped table-hover'>");
            
            out.print("<tr><th>Vare ID</th>");
            out.print("<th>Vare Navn</th>");
            out.print("<th>Vare Info</th>");
            out.print("<th>Vare Antal</th>");
            out.print("<th>Vare Mål</th>");
            out.print("<th>Pris pr. stk.</th></tr>");
            
            for(int i = 0; i < alod.size(); i++){
                Item item = dbf.getItem(alod.get(i).getFkItemId());
                
                out.print("<tr>");
                    out.print("<td>" + alod.get(i).getFkItemId() + "</td>");
                    out.print("<td>" + item.getItem_name()  + "</td>");
                    out.print("<td>" + item.getItem_info()  + "</td>");
                    out.print("<td>" + alod.get(i).getOrderQuantity()  + "</td>");
                    out.print("<td>" + alod.get(i).getOrderMeasurement()  + "</td>");
                    double p = (double) (item.getItem_price())*(alod.get(i).getOrderQuantity());
                    out.print("<td>" + p + "</td>");
                    price += p;
                out.print("</tr>");
                
                
            }
            
            tax = c.getMomsPrice(price);
            totalPrice = price + tax;
            out.print("<tr><td></td><td></td><td></td><td></td><td>Pris ex. moms: </td><td>" + price  + "</td></tr>");
            out.print("<tr><td></td><td></td><td></td><td></td><td>Moms: </td><td>" + tax  + "</td></tr>");
            out.print("<tr><td></td><td></td><td></td><td></td><td>Total Pris: </td><td>" + totalPrice  + "</td></tr>");
            
            out.print("</table>");
            out.print("<br><br>");
            
            out.print("<h1>Plantegning set oppefra</h1>");
            out.print("<div style='margin-left: " + oneOrder.getOrderdata_lenght()/2  +  "px;'> Længde: " + oneOrder.getOrderdata_lenght()  + " cm.</div>");
            out.print("<svg width='" + oneOrder.getOrderdata_width() + "' height='" + oneOrder.getOrderdata_lenght() + "'>");
            out.print("<rect width='" + oneOrder.getOrderdata_width() + "' height='" + oneOrder.getOrderdata_lenght() + "' style='fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)'" + ">");
            out.print("<br><br>");
            out.print("<div> Bredde: " + oneOrder.getOrderdata_width()  + " cm.</div>" );
            out.print("</svg>");
        %>

            </div>
            
        </form>


    </body>
</html>
