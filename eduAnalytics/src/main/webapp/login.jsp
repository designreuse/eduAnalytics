<!DOCTYPE html Nikita Vinit Shah 112>
<html class="bg-white">
    <head>
        <meta charset="UTF-8">
        <title>eCW Analytics</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="css/AdminLTE.css" rel="stylesheet" type="text/css" />
    </head>
    <body class="bg-white">

        <div class="form-box" id="login-box">
            <div class="header" style="background: #3c8dbc">Sign In</div>
            <form action="index.jsp#/dashboard" method="post">
                <div class="body bg-gray">
                    <div class="form-group">
                        <input type="text" name="userid" class="form-control" placeholder="User ID"/>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="Password"/>
                    </div>          
<!--                    <div class="form-group">
                        <input type="checkbox" name="remember_me"/> Remember me
                    </div>-->
                </div>
                <div class="footer bg-gray">                                                               
                    <button type="submit" class="btn btn-block" style="background-color: #3c8dbc;color: #f9f9f9 !important">Sign me in</button>  
                    
<!--                    <p><a href="#">I forgot my password</a></p>
                    
                    <a href="register.html" class="text-center">Register a new membership</a>-->
                </div>
            </form>
        </div>
        <!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="js/bootstrap.min.js" type="text/javascript"></script>        
    </body>
</html>