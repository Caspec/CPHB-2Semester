<%-- 
    Document   : vismateriale
    Created on : 18-04-2017, 11:21:44
    Author     : auron
--%>

<%@page import="domain.entity.Item"%>
<%@page import="data.ItemMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vis materiale</title>
    </head>
    <body>

        <% ItemMapper im = new ItemMapper(); %>
        
        <% 
            
            int materialeid = Integer.parseInt(request.getParameter("id"));
        
        %>

        <%

            Item item = im.getItem(materialeid);
            
            out.print("<h1>Materiale</h1>");
            out.print("<table class='table table-striped table-hover'>");
            out.print("<tr>");
            out.print("<td>Materiale ID: " + item.getItem_id() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>Materiale Navn: " + item.getItem_name() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>Materiale pris: " + item.getItem_price() + "</td>");
            out.print("</tr>");
            out.print("</table>");
            
      


        %>



    </body>
</html>
