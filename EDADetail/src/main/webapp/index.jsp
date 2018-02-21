<%@page import="java.util.ArrayList"%>
<%@page import="EDA.Model.Disaster"%>
<html>
<title> Welcome : EDA </title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <meta name="theme-color" content="#ffffff" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="manifest" href="./../manifest.json">
    <script src="js/sweetalert2.all.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 <style>
        body {
            background-color: #48773e;
        }

        #picOne {
            position: absolute;
            display: none;
            width: 250px;
            height: 250px; 
            margin-top: 45%;
            margin-left: 20%;
        }
        #message{
            position: absolute;
            display: none;
            margin-top: 95%;
            margin-left: 30%;
            color: white;
            
        }
    </style>
<script src="http://code.jquery.com/jquery-1.4.4.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#picOne").fadeIn(0).delay(1500).fadeOut(1000);
            $("#message").fadeIn(0).delay(1500).fadeOut(1000);
        });
        function Redirect() {
               window.location="main.jsp";};
               setTimeout('Redirect()', 8000);
    </script>
	<body>

 <div id="pics">
        <img src="icon/logo.png" width="100" height="100" id="picOne" />
    </div>
    <div id="message">
        <h1> &nbsp; &nbsp; EDA</h1>
        <p >Emergency Disaster Alert</p>
    </div>
		<script>
			function showNoti() {
                           
                     ${scriptNoti}
                               
}
		</script>
 		<script src="app.js"></script>
        <script src="js/push.min.js"></script>
	</body>

</html>