<%-- 
    Document   : login
    Created on : 24-03-2017, 11:47:53
    Author     : auron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Fog Admin | Konto Login</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link rel="icon" href="img/geekfav.png" sizes="32x32" />
    <script src="http://cdn.ckeditor.com/4.6.1/standard/ckeditor.js"></script>
  </head>
  <body>

    <nav class="navbar navbar-default">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Fog Admin</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">

        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <header id="header">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1 class="text-center"> Fog Admin <small>Konto Login</small></h1>
          </div>
        </div>
      </div>
    </header>

    <section id="main">
      <div class="container">
        <div class="row">
          <div class="col-md-4 col-md-offset-4">
              <form id="login" action="ControlLogin" method="POST" class="well">
                  <div class="form-group">
                    <label>Email</label>
                    <input type="text" class="form-control" name="email" placeholder="Indtast email">
                  </div>
                  <div class="form-group">
                    <label>Kodeord</label>
                    <input type="password" class="form-control" name="password" placeholder="Indtast kodeord">
                  </div>
                  <button type="submit" class="btn btn-default btn-block">Login</button>
              </form>
              <%  
                  String msg = (String)request.getAttribute("msg");
                    if(msg != null){
                        out.print(msg);        
                    }                                                       
              %>
          </div>
        </div>
      </div>
    </section>

    <footer id="footer">
      <p>Copyright Sjov med skæg &copy; 2017</p>
    </footer>

  <script>
     CKEDITOR.replace( 'editor1' );
 </script>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>

