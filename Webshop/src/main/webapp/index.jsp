<%-- 
    Document   : index
    Created on : 27-02-2017, 07:56:03
    Author     : auron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index - JSP</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="img/geekfav.png" sizes="32x32" />
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div id="wrapper">
        <div id="content">
        <img src="img/logo.png" alt="logo" class="img">
        <br><br>
        <h1>Welcome to My little CupCake</h1>
        <p>The place where you can order on-the-go!</p>
        

        <div class="login-page">
            <div class="form">
                <form class="register-form" action="ControlNewUser" method="POST">
                    <h2 class="h2">Create user</h2>
                    <input type="text" name="customer_name" placeholder="name" maxlength="40"/>
                    <input type="text" name="customer_password" placeholder="password" maxlength="40"/>
                    <input type="text" name="balance" placeholder="balance" maxlength="40" class="balance" value="Get 10 $ free when registration" readonly="readonly"/>
                    <button type="submit">create</button>
                    <p class="message">Already registered? <a href="#">Sign In</a></p>
                </form>
                <form class="login-form" action="ControlLogin" method="POST">
                    <h2 class="h2">Login</h2>
                    <input type="text" name="username" placeholder="username" maxlength="40" />
                    <input type="text" name="password" placeholder="password" maxlength="40" />
                    <button type="submit">login</button>
                    <p class="message">Not registered? <a href="#">Create an account</a></p>
                </form>
            </div>
        </div>
        <%
            if (session.getAttribute("msg") == null)
            {
                session.setAttribute("msg", "");
                out.print(session.getAttribute("msg"));
            } else
            {
                out.print(session.getAttribute("msg"));
            }
        %>
        </div>
        </div>
        <script src="script/switch.js"></script>
        
    </body>
</html>


