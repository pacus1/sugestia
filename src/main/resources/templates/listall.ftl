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
    <link href="css/custom.css" rel="stylesheet/less">
    <link href="css/login.css" rel="stylesheet/less">
    <link rel="stylesheet" href="css/footer-basic-centered.css">
    <link href="less/navbar.less" rel="stylesheet/less">
    <link href="less/navs.less" rel="stylesheet/less">
    <link href="less/dropdowns.less" rel="stylesheet/less">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/theme.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/starter-template.css" rel="stylesheet">

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
  <div class="panel-heading">SUGESTII</div>
  <div class="panel-body">
  </div>

 
  <table class="table">
	<tr>
		<th></th>
		<th>Status</th>
		<th>Tipul institutiei</th>
		<th>Numele institutiei</th>
		<th>Titlul sugestiei</th>
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
						<form> 
						<input type="radio" name="complaintStatusType" value="PENDING" checked> PENDING<br>
 						<input type="radio" name="complaintStatusType" value="APPROVED"> APPROVED<br>
 						<input type="radio" name="complaintStatusType" value="REJECT"> REJECT<br>
 						<input type="radio" name="complaintStatusType" value="SOLVED"> SOLVED</td>
 						</form>
				<td>${complaint.complaintPartnerType}</td>
				<td>${complaint.complaintPartnerAsigneeName}</td>
				<td>${complaint.complaintTitle}</td>
				<td>${complaint.complaintBody}</td>
				<td>${complaint.complaintTimeStamp}</td>
				<td><img src = file:///C:\Users\Petronia\Desktop\${complaint.complaintPicture} /></td>
				<td>${complaint.complaintPicture}</td>
				
			</tr>
		[/#list]
	[/#if]
	
	<!-- end iteration -->

</table>
</div>
<div> <a href="/save">SAVE</a></div>

[/#escape]
