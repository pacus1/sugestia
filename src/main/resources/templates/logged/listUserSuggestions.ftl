[#ftl]

[#import "/spring.ftl" as spring /]

<html lang="en">
  <head><meta http-equiv="Content-Type" content="text/html; charset=gb18030">
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>SUGESTIA.RO</title>

 <!-- Bootstrap core CSS -->
<link href="[@spring.url '/css/custom.css' /]" rel="stylesheet/less" media="screen" /> 
<link href="[@spring.url '/css/login.css' /]" rel="stylesheet/less" media="screen" /> 
<link href="[@spring.url '/css/footer-basic-centered.css' /]" rel="stylesheet" media="screen" />    
<link href="[@spring.url '/less/navbar.less' /]" rel="stylesheet/less" media="screen" />  
<link href="[@spring.url '/less/navs.less' /]" rel="stylesheet/less" media="screen" />
<link href="[@spring.url '/less/dropdowns.less' /]" rel="stylesheet/less" media="screen" />
<link href="[@spring.url '/css/bootstrap.css' /]" rel="stylesheet"/>
<link href="[@spring.url '/css/theme.css' /]" rel="stylesheet" media="screen" />
<link href="[@spring.url '/css/bootstrap.min.css' /]" rel="stylesheet" media="screen" />


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="[@spring.url '/css/ie10-viewport-bug-workaround.css' /]" rel="stylesheet" media="screen" /> 

    <!-- Custom styles for this template -->
    <link href="[@spring.url '/css/starter-template.css' /]" rel="stylesheet"/> 

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
[#escape x as x?html]

<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">SUGESTIILE SI RECLAMATIILE DEPUSE DE DUMNEAVOASTRA</div>
  <div class="panel-body">
  </div>

 
  <table class="table">
	<tr>
		<th></th>
		<th>Status</th>
		<th>Id</th>
		<th>Numele Companiei</th>
		<th>Titlu Sugestie</th>
		<th>Continut</th>
		<th>Time stamp</th>
		<th>Poze</th>
		<th>Poze</th>
		<th></th>
	</tr>

	<!-- begin iteration -->
	[#if complaints??]
	
		[#list complaints as complaint] 
		
			<tr>
				<td>${complaint.complaintType}</td>
				<td>${complaint.complaintStatusType} <br>  
 				[#if complaint.complaintId??] <td>${complaint.complaintId}</td>[/#if]
				[#if complaint.complaintPartnerType??]<td>${complaint.partnerT}</td>[/#if]
				[#if complaint.complaintPartnerAsigneeName??]<td>${complaint.complaintPartnerAsigneeName}</td>[/#if]
				[#if complaint.complaintTitle??]<td>${complaint.complaintTitle}</td>[/#if]
				[#if complaint.complaintBody??]<td>${complaint.complaintBody}</td>[/#if]
			[#if complaint.complaintTimeStamp??]<td>${complaint.complaintTimeStamp}</td>[/#if]
		
				
			</tr>
		[/#list]
		
	[/#if]
	<!-- end iteration -->
	
</table>
</div>
<a href="/" class="btn btn-primary"><span class="glyphicon glyphicon-arrow-left"></span> Back</a>


  <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
 	<script src="[@spring.url '/js/bootstrap.min.js' /] "></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    <script src="[@spring.url '/js/contact.js' /] "></script>
    <script> $('.message a').click(function(){
   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
}); </script>
  </body>
</html>
[/#escape]
