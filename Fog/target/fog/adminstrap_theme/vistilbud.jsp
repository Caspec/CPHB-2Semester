<%-- 
    Document   : vistilbud
    Created on : 12-04-2017, 11:04:46
    Author     : auron
--%>



<%@page import="domain.business.DOFacade"%>
<%@page import="domain.entity.Offer"%>
<%@page import="data.OfferMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vis Bruger</title>
    </head>
    <body>

        <% DOFacade dof = new DOFacade(); %>

        <% int offer_id = Integer.parseInt(request.getParameter("id")); %>


        <%

            Offer offer = dof.getOffer(offer_id);

            out.print("<h1>Tilbuds information</h1>");
            out.print("<table class='table table-striped table-hover'>");
            out.print("<tr>");
            out.print("<td>Tilbud navn: " + offer.getTilbud_name() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td> Tilbud billede: " + offer.getTilbud_img() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td> Tilbud tekst: " + offer.getTilbud_info() + "</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td> Tilbud rabat: " + offer.getTilbud_rabat() + "</td>");
            out.print("</tr>");
            out.print("</table>");


        %>


    </body>
</html>
