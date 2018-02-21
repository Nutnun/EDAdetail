<%@page import="EDA.Model.Alert"%>
<%@page import="EDA.Model.Disaster"%>
<html>
	<head>
		<title></title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		
	</head>
	<style>
		.bg-white{
			background: white;
		}
	</style>
	<body> 
            <% 
               String disasterNo = request.getParameter("disasterid");

        int id = Integer.parseInt(disasterNo);
        Alert alert = new Alert();

        Disaster dist = alert.getDisaster(id);
            %>
            
           

	<!-- Head -->
		<div class="jumbotron" style="padding-top: 10px; padding-bottom: 10px; margin-bottom: 10px; background: white">
			<div class= "">
		  	
			</div>

			<div class="text-center">
				
	  			<img src="alert-icon/flood.svg" class="rounded-circle" style="width:80px">
	  			<br>
	  			<b> <% out.println(dist.getDisasterName()); %> </b>
			</div>
		</div>
		<hr style="width:80%">
	
		<div class="container">
	  		<div class="row">

	    		<div class="col-6">
	    			<div class="jumbotron text-center" style="padding: 20px; margin-bottom: 10px" >
	      				<b>Disaster Category</b>
	      				<p style="margin-top: 10px"> <% out.println(dist.getCatName()); %></p>
	      			</div>
	    		</div>

	   			 <div class="col-6">
	    			<div class="jumbotron text-center" style="padding: 20px; margin-bottom: 10px">
	    				<img src="icon/placeholder.svg" style="width:25px"><br>
	      				<p style="margin-top: 10px"><% out.println(dist.getLocation());%></p>
	  				</div>
	    		</div>
	  		</div>

	  		<b>Info</b>
	  		<p> <% out.println(dist.getDisasDesp()); %></p>
	  		<br><br>
		  	
		</div>

	</body>
</html>