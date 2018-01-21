<%-- 
    Document   : newuser
    Created on : 25-02-2017, 14:09:07
    Author     : auron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NewUser - JSP </title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="img/geekfav.png" sizes="32x32" />
    </head>
    <body>
        <a href="index.jsp"><img src="img/geekboynewuser.png" alt="geekboynewuser" class="imgzindex" /></a> &nbsp;&nbsp; <a href="index.jsp">index</a>
        <h1>Lav en ny bruger</h1>
        
        <form name="form1" action="ControlNewUser" method="POST">
        <table>
        <tr>
        <td>SSN: </td><td><input type="text" name="SSN" maxlength="4" value="" oninput="this.value=this.value.replace(/[^0-9]/g,'');" id="SSN" /></td>
        </tr>
        <tr>
        <td>Navn: </td><td><input type="text" name="name" maxlength="45" /></td>
        </tr>
        <tr>
        <td>Adresse: </td><td><input type="text" name="address" maxlength="90" /></td>
        </tr>
        <tr>
        <td>Telefon: </td><td><input type="text" name="phone" maxlength="8" value="" oninput="this.value=this.value.replace(/[^0-9]/g,'');" id="phone" /></td>
        </tr>
        <tr>
        <td>Mail: </td><td><input type="text" name="mail" maxlength="90" /></td>
        </tr>
        <tr>
        <td></td><td></td>
        </tr>
        <tr>
        <td></td><td><input type="submit" name="submit" value="Opret bruger"></td>
        </tr>
        </table>
        </form>
        
    </body>
</html>
