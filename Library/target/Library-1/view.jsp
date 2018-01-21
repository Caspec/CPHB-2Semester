<%-- 
    Document   : view
    Created on : 23-02-2017, 23:30:04
    Author     : auron
--%>


<%@page import="domain.entity.BookInfo"%>
<%@page import="domain.entity.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.BookMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View - JSP</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="img/geekfav.png" sizes="32x32" />
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
        $(function() 
        {
            //$( "#datepicker_from" ).datepicker({ dateFormat: 'yy-mm-dd'});
            //$( "#datepicker_to" ).datepicker({ dateFormat: 'yy-mm-dd'});
            //$("#datepicker").datepicker({minDate:-1,maxDate:-2}).attr('readonly','readonly');   
            $( "#datepicker_from" ).datepicker({ dateFormat: 'yy-mm-dd', defaultDate: new Date(), minDate: new Date(), maxDate: new Date(), gotoCurrent: true }).datepicker("setDate", new Date()).attr('readonly','readonly');
            $( "#datepicker_to" ).datepicker({ dateFormat: 'yy-mm-dd', defaultDate: '+1d', minDate: '+1d', gotoCurrent: true });
            
        });
        
        
        
        </script>
    </head>
    <body>
        <a href="index.jsp"><img src="img/geeklogo.png" alt="userloggedin" class="imgzindex" /></a> &nbsp;&nbsp; <a href="index.jsp">log af</a> 
        <h1>Data fra login oplysninger:</h1>
       Du er logget ind som<br /> 
       <% out.print(session.getAttribute("login")); %><br />
       Today is <%= (new java.util.Date())%>
       
        <br /><br />
        <h1>Søg på ISBN nummeret efter en bog:</h1>
        <ul>
        <% 
            BookMapper bm = new BookMapper(); 
                
                for (Book book : bm.getAllBooks()) 
                {
                   out.print("<li>"+ "ISBN: " + book.getIsbn() + "</li>");
                }
        %>
        </ul>
        <br />
        <form name="form" action="ControlSearch" method="POST">
        <table>
        <tr>
        <td>Søg: </td><td><input type="text" name="search" maxlength="9" id="search" class="search" value="0" oninput="this.value=this.value.replace(/[^0-9]/g,'');" /></td><td><input type="submit" value="Søg" name="submit" /></td>
        </tr>
        </table>
        </form>
        
        <table>
        <tr>
        <td><%
                if(session.getAttribute("search") == null)
                {
                    session.setAttribute("search", "");
                    out.print(session.getAttribute("search"));
                }
                else 
                {
                    out.print(session.getAttribute("search"));
                }
              %> </td><td></td>
        </tr>   
        </table>
        
        <br />
        <hr /> 
        <h1>Lav en reservation af en bog</h1>
        
        <img src="img/owl.png" alt="owl" />
        
        <form name="form2" action="ControlReserve" method="POST">
        <table>
        <tr>
        <td>ISBN: </td><td><input type="text" maxlength="9" name="ISBN" oninput="this.value=this.value.replace(/[^0-9]/g,'');" id="ISBN" /></td>
        </tr>
        <tr>
        <td>Dato fra: </td><td><input type="text" name="datepicker_from" id="datepicker_from" readonly="readonly"></td>
        </tr>
        <tr>
        <td>Dato til: </td><td><input type="text" name="datepicker_to" id="datepicker_to" readonly="readonly"></td>
        </tr>
        <tr>
        <td>Bog kopi nr: </td><td><input type="number" name="copyno" readonly="readonly" value="7" /></td>
        </tr>
        <tr>
        <td>SSN: </td><td><input type="text" name="SSN" maxlength="4" value="1111" oninput="this.value=this.value.replace(/[^0-9]/g,'');" id="SSN" /></td>
        </tr>
        <tr>
        <td></td><td></td>
        </tr>
        <tr>
        <td></td><td><input type="submit" name="submit" value="Opret reservation"></td>
        </tr>
        </table>
        </form>
        
        <table>
        <tr>
        <td><% out.print(session.getAttribute("done")); %></td><td></td>
        </tr>   
        </table>
        
        <br /><br />
        
        
    </body>
</html>
