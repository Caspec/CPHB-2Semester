<%-- 
    Document   : index
    Created on : 23-02-2017, 23:07:06
    Author     : auron
--%>

<%@page import="data.BorrowerMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index - JSP</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="img/geekfav.png" sizes="32x32" />
    </head>
    <body>
        <h1>Velkommen til CPHBUSINESS junior bibliotek!</h1>
        <br />
        <img src="img/geekboy.png" alt="geekboy" /> <img src="img/geekboy2.png" alt="geekboy" />
        <h1>Login</h1>
        <form name="form1" action="ControlLogin" method="POST">
            <table>
            <tr>
            <td>Brugernavn: </td><td><input type="text" name="user" value="cc" /></td>
            </tr>
            <tr>
            <td>Kodeord: </td><td><input type="text" name="SSN" value="1234" maxlength="4" oninput="this.value=this.value.replace(/[^0-9]/g,'');" id="SSN" /></td>
            </tr>
            <tr>
            <td></td><td></td>
            </tr>
            <tr>
            <td><input type="submit" value="Login" name="submit" /></td><td><input type="hidden" name="search" value="" /><input type="hidden" name="done" value="" /></td>    
            </tr>
            <tr>
            <td></td><td></td>
            </tr>
            </table>
            <input type="hidden" name="msg" value="abc" />
            <% 
                if(session.getAttribute("msg") == null)
                {
                    session.setAttribute("msg", "");
                    out.print(session.getAttribute("msg"));
                }
                else 
                {
                    out.print(session.getAttribute("msg"));
                }
                 %>
            <br /><br />
          
            <h2>Login info: </h2>
            <p>Vil gerne sikre mig, du som prøver mit system kan logge ind... Derfor har jeg sat værdier ind i input felterne: user: cc, SSN: 1234</p>
            <h2>Info: </h2>
            <p>Der er nogle ting i min reservation som ikke virker efter hensigten... Der har jeg ikke nok viden i JSP/Servlet til at kunne udføre det jeg gerne vil...</p>
    
            
        </form>
        
        <br />
        <hr />
        <h1>Lav en ny bruger</h1>

        <a href="newuser.jsp">Lav en ny bruger</a>
        <br /><br />
        <a href="newuser.jsp"><img src="img/geekboynewuser.png" alt="geekboynewuser" /></a>
        
        
    </body>
</html>
