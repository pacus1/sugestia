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

<BODY style="background-color: rgb(233, 235, 238);"><NAV style="background-color: rgb(51, 122, 183);" 
class="navbar navbar-inverse navbar-fixed-top">
<DIV class="container">
<DIV class="navbar-header"><BUTTON aria-expanded="false" class="navbar-toggle collapsed" 
aria-controls="navbar" type="button" data-toggle="collapse" data-target="#navbar"><SPAN 
class="sr-only">Toggle navigation</SPAN><SPAN class="icon-bar"></SPAN><SPAN 
class="icon-bar"></SPAN><SPAN class="icon-bar"></SPAN></BUTTON><A class="navbar-brand" 
href="http://sugestia.biz/">SUGESTIA.RO</A></DIV>
<DIV id="navbar" class="collapse navbar-collapse">
<UL style="font-weight: 300; float: right;" class="nav navbar-nav">
  <LI><A href="/">Acasa</A></LI>
  <LI><A href="/sugestii-reclamatii">Vezi Sugestii si Reclamatii</A></LI>
  <LI><A href="/partnerInformation">Parteneri</A></LI>
  <LI><A href="/aboutUs">Despre Noi</A></LI>
  <LI><A href="/contact">Contact</A></LI>
  <LI>
  <DIV style="padding-top: 8px;" class="btn-group"> <BUTTON aria-haspopup="true" 
  style="color: white;" aria-expanded="false" class="btn btn-success dropdown-toggle" 
  type="button" data-toggle="dropdown">AUTENTIFICARE <SPAN 
  class="caret"></SPAN></BUTTON> 
  <UL class="dropdown-menu"> 
    <LI><A href="/login">Intra in cont</A></LI> 
    <LI><A href="/register">Inregistreaza un cont nou</A></LI> 

    <LI><A href="/partnerRegister">Inregistrare 
    partener</A></LI></UL> </DIV> </LI></UL></DIV><!--/.nav-collapse --></DIV></NAV>
<DIV class="container">
<DIV class="row"><BR><BR>
<DIV class="col-md-3">
<DIV style="text-align: center; margin-right: 0px; box-shadow: 0px 0px 3px 0px rgba(50,50,50,0.47);" 
class="list-group" align="center"><A class="list-group-item" href="http://sugestia.biz/sugestii-reclamatii#">
<H4 class="list-group-item-heading">VEZI TOATE SUGESTIILE SI RECLAMATIILE</H4>
<P class="list-group-item-text"></P></A><A class="list-group-item" href="http://sugestia.biz/sugestii-reclamatii#">
<H4 class="list-group-item-heading">INSTITUTII PUBLICE</H4>
<P class="list-group-item-text">Primaria, Consiliul Local, Politie</P></A><A 
class="list-group-item" href="http://sugestia.biz/sugestii-reclamatii#">
<H4 class="list-group-item-heading">SERVICII PUBLICE</H4>
<P class="list-group-item-text">Cluj Bike, Parcuri, ADP, RATUC</P></A><A class="list-group-item" 
href="http://sugestia.biz/sugestii-reclamatii#">
<H4 class="list-group-item-heading">SERVICII PRIVATE</H4>
<P class="list-group-item-text">Telefonie, Internet, Gunoaie/Reciclare, Taxi, 
Curierat</P></A><A class="list-group-item" href="http://sugestia.biz/sugestii-reclamatii#">
<H4 class="list-group-item-heading">UTILITATI</H4>
<P class="list-group-item-text">Apa, Gaze, Electricitate</P></A><A class="list-group-item" 
href="http://sugestia.biz/sugestii-reclamatii#">
<H4 class="list-group-item-heading">LOCALURI</H4>
<P class="list-group-item-text">Cafenele, Restaurante, Baruri</P></A><A class="list-group-item" 
href="http://sugestia.biz/sugestii-reclamatii#">
<H4 class="list-group-item-heading">CAZARE</H4>
<P class="list-group-item-text">Hotele, Pensiuni</P></A><A class="list-group-item" 
href="http://sugestia.biz/sugestii-reclamatii#">
<H4 class="list-group-item-heading">EVENIMENTE</H4>
<P class="list-group-item-text">Festivaluri, Targuri, Concerte</P></A><A class="list-group-item" 
href="http://sugestia.biz/sugestii-reclamatii#">
<H4 class="list-group-item-heading">CULTURA</H4>
<P class="list-group-item-text">Teatru, Opera, Film</P></A><A class="list-group-item" 
href="http://sugestia.biz/sugestii-reclamatii#">
<H4 class="list-group-item-heading">MAGAZINE</H4>
<P class="list-group-item-text">Mall-uri, Centre Comerciale Second-Hand, 
Outlet-uri, Electronice, Farmacii</P></A><A class="list-group-item" href="http://sugestia.biz/sugestii-reclamatii#">
<H4 class="list-group-item-heading">SANATATE</H4>
<P class="list-group-item-text">Clinici, Spitale, Cabinete 
individuale</P></A></DIV></DIV>
<DIV style="border-radius: 5px; box-shadow: 0px 0px 3px 0px rgba(50,50,50,0.47); background-color: rgb(255, 255, 255);" 
class="col-md-9" align="center"><BR><LABEL 

for="selectcategorie">Sugestii/Reclamatii:</LABEL><SELECT style="font-size: 25px;" 
id="selectcategorie" name="categorie" required=""><OPTION 
  value="volvo">Toate</OPTION><OPTION value="volvo">Sugestii</OPTION><OPTION 
  value="saab">Reclamatii</OPTION></SELECT><LABEL 
for="selectcategorie">Categoria:</LABEL><SELECT style="font-size: 25px;" id="selectcategorie" 
name="categorie" required=""><OPTION value="volvo">Toate</OPTION><OPTION 
  value="volvo">Institutii Publice</OPTION><OPTION value="saab">Servicii 
  Publice</OPTION><OPTION value="volvo">Servicii Private</OPTION><OPTION value="volvo">Utilitati</OPTION><OPTION 
  value="saab">Localuri</OPTION><OPTION value="volvo">Cazare</OPTION><OPTION 
  value="volvo">Evenimente</OPTION><OPTION value="volvo">Cultura</OPTION><OPTION 
  value="volvo">Magazine</OPTION><OPTION 
value="saab">Sanatate</OPTION></SELECT><LABEL 
for="selectcategorie">Ordoneaza:</LABEL><SELECT style="font-size: 25px;" id="selectcategorie" 
name="categorie" required=""><OPTION value="volvo">Cele mai 
  noi</OPTION><OPTION value="volvo">Cele mai vechi</OPTION></SELECT><BR><BR>
<DIV style="width: 40%;" class="input-group"> <INPUT class="form-control" type="text" 
placeholder="Cauta dupa titlu sau continut"> <SPAN class="input-group-btn"> 
<BUTTON class="btn btn-default" type="button">Cauta</BUTTON> </SPAN> </DIV>
<HR style="padding-left: 0px; margin-left: 0px;">

<DIV style="height: 610px; text-align: left; overflow: scroll; overflow-y: scroll;">
<DIV style="max-height: 610px;" class="pre-scrollable" data-example-id="panel-with-list-group" 
bs-example="">



<!-- begin iteration -->
						[#if complaints??]
						
							[#list complaints as complaint] 
								
								<div class="panel panel-default"> 
					                                   <div class=panel-heading><span class="sugestie">[#if complaint.complaintType??]${complaint.complaintType}[/#if]</span>[#if complaint.complaintTitle??]${complaint.complaintTitle}[/#if]</div>
					                                        <div class=panel-body>
					                                                <p>[#if complaint.complaintBody??]${complaint.complaintBody}[/#if]</p> 
					                                        </div> 
					           </div>
									
								</tr>
							[/#list]
							
						[/#if]
<!-- end iteration -->		




</DIV></DIV></DIV></DIV></DIV><!-- /.container -->




<footer class="footer-basic-centered">

			<p class="footer-company-motto">"Orice persoana are dreptul la libertatea de opinie si de exprimare"</p>
<hr>
			<p class="footer-links">
				<a href="./">Acasa</a>
				-
				<a href="/sugestii-reclamatii">Sugestii/Reclamatii</a>
				-
				<a href="/parteneri">Parteneri</a>
				-
				<a href="/desprenoi">Despre Noi</a>
				-
				<a href="/contact">Contact</a>
			</p>

			<p class="footer-company-name"> - SUGESTIA.RO &copy; Copyright 2016 - </p>

		</footer>

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