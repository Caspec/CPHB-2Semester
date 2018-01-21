<%-- 
    Document   : visbrugere
    Created on : Apr 5, 2017, 1:48:37 PM
    Author     : Makemewant
--%>

<%@page import="domain.entity.User"%>
<%@page import="data.UserMapper"%>
<%@page import="data.RegionMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vis Bruger</title>
    </head>
    <body>
        
        <% RegionMapper rm = new RegionMapper(); %>
        <% UserMapper um = new UserMapper(); %>
        
        <% int user_id = Integer.parseInt(request.getParameter("id")); %>
        
        
        <% 

        User user = um.getUser(user_id);
        
        out.print("<h1>Kunde information</h1>");
            out.print("<table class='table table-striped table-hover'>");
            out.print("<tr>");
            out.print("<td>Kunde navn: " + user.getName() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td> Kunde email: " + user.getEmail() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td> Kunde adresse: " + user.getAdress() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td> Kunde telefon: " + user.getPhone() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>Kunde postnummer: " + user.getZip() + "</td>");
            out.print("</tr>");
            out.print("</table>");
        
        
        
        
        
        
        
        %>
        
        
        
        
        
        
        
        
        
    </body>
</html>
