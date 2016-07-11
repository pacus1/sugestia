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

  <body style="background-color:#E9EBEE;">

    <nav class="navbar navbar-inverse navbar-fixed-top" style="background-color:#337AB7;">
      <div class="container" >
        <div class="navbar-header" >
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="./">SUGESTIA.RO</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav" style="float:right; font-weight:300;">
            <li><a href="/">Acasa</a></li>
            <li><a href="/sugestii-reclamatii">Vezi Sugestii si Reclamatii</a></li>
            <li><a href="/partnerInformation">Parteneri</a></li>
            <li><a href="/aboutUs">Despre Noi</a></li>
            <li><a href="/contact">Contact</a></li>
<li><div class=btn-group style="padding-top:8px;"> <button type=button class="btn btn-success dropdown-toggle" data-toggle=dropdown aria-haspopup=true aria-expanded=false style="color:white;">AUTENTIFICARE <span class=caret></span></button> <ul class=dropdown-menu> <li><a href="/login">Intra in cont</a></li> <li><a href="/register">Inregistreaza un cont nou</a></li> <li><a href="/partnerRegister">Inregistrare partener</a></li></ul> </div> </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">

      <div class="row">
</br></br>
        <div class="col-md-3">
          <div class="list-group" align="center" style="text-align:center; margin-right:0px; box-shadow: 0px 0px 3px 0px rgba(50, 50, 50, 0.47); ">
            <a href="#" class="list-group-item">
              <h4 class="list-group-item-heading">VEZI TOATE SUGESTIILE SI RECLAMATIILE</h4>
              <p class="list-group-item-text"></p>
            </a>
            <a href="#" class="list-group-item">
              <h4 class="list-group-item-heading">INSTITUTII PUBLICE</h4>
              <p class="list-group-item-text">Primaria, Consiliul Local, Politie</p>
            </a>
            <a href="#" class="list-group-item">
              <h4 class="list-group-item-heading">SERVICII PUBLICE</h4>
              <p class="list-group-item-text">Cluj Bike, Parcuri, ADP, RATUC</p>
            </a>
            <a href="#" class="list-group-item">
              <h4 class="list-group-item-heading">SERVICII PRIVATE</h4>
              <p class="list-group-item-text">Telefonie, Internet, Gunoaie/Reciclare, Taxi, Curierat</p>
            </a>
            <a href="#" class="list-group-item">
              <h4 class="list-group-item-heading">UTILITATI</h4>
              <p class="list-group-item-text">Apa, Gaze, Electricitate</p>
            </a>
             <a href="#" class="list-group-item">
              <h4 class="list-group-item-heading">LOCALURI</h4>
              <p class="list-group-item-text">Cafenele, Restaurante, Baruri</p>
            </a>
            <a href="#" class="list-group-item">
              <h4 class="list-group-item-heading">CAZARE</h4>
              <p class="list-group-item-text">Hotele, Pensiuni</p>
            </a>
            <a href="#" class="list-group-item">
              <h4 class="list-group-item-heading">EVENIMENTE</h4>
              <p class="list-group-item-text">Festivaluri, Targuri, Concerte</p>
            </a>
            <a href="#" class="list-group-item">
              <h4 class="list-group-item-heading">CULTURA</h4>
              <p class="list-group-item-text">Teatru, Opera, Film</p>
            </a>
            <a href="#" class="list-group-item">
              <h4 class="list-group-item-heading">MAGAZINE</h4>
              <p class="list-group-item-text">Mall-uri, Centre Comerciale Second-Hand, Outlet-uri, Electronice, Farmacii</p>
            </a>
            <a href="#" class="list-group-item">
              <h4 class="list-group-item-heading">SANATATE</h4>
              <p class="list-group-item-text">Clinici, Spitale, Cabinete individuale</p>
            </a>
          </div>
       </div>
       <div class="col-md-6" align="center" style="border-radius: 5px; padding-bottom:45px; background-color:#FFFFFF; box-shadow: 0px 0px 3px 0px rgba(50, 50, 50, 0.47);"></br>
       <h1>Informatii Parteneri</h1></br></br>
             <p style="text-align:left;">Sugestia.ro este o platforma care incearca sa aduca proprietarii de afaceri sau institutiile publice din Cluj-Napoca mai aproape de nevoile clientilor sau a cetatenilor, prin colectarea feedback-ului acestora sub forma de sugestii si reclamatii.</br></br>

Institutiile publice trebuie sa fie aproape de cetateni, iar optimizarea relatiei dintre acestia este esentiala pentru o comunitate mai buna. In multe cazuri, situatia de monopol si comunicarea dificila descurajeaza oferirea de feedback, platforma noastra fiind solutia la aceasta problema.</br></br>

Pentru ca un business sa reziste, realitatea zilelor noastre ne-a aratat faptul ca modul in care tratam nevoile clientilor este cel mai important aspect. De cele mai multe ori, experienta unui client cu business-ul nostru este mai importanta decat serviciul sau produsul in sine. </br></br>

Noi ne asiguram ca renumele afacerii tale este protejat, avand posibilitatea sa alegi care sunt     sugestiile  sau reclamatiile care vrei sa fie tratate in mod public si cele care vrei sa fie private. Astfel, in momentul in care primesti o reclamatie sau o sugestie vei fi notificat pe e-mail, iar noi iti vom pune la dispozitie posibilitatea de a trata rapid si usor fiecare parere sau nemultumire In cazul in care ai constatat ca reclamatia este indreptatita, iti sugeram sa utilizezi metode palpabile de a indrepta lucurile: oferirea unui discount de 15%, un produs cadou, un vouche de cumparaturi, card de membru, etc.</br></br>

Utilizarea acestui serviciu este gratuita, dar daca ti se pare ca aducem plus valoare afacerii tale, te rugam sa ne sprijini initiativa prin efectuarea unei donatii. 
</p></br></br>
<a href="/partnerRegister"><button type="button" class="btn btn-lg btn-success" style="padding: 10px 30px 10px 30px; "> INSCRIE-TE CA PARTENER </button></a>
</div>


       

        <div class="col-md-3">
             <div class="panel panel-primary" style="border-style:solid; border-color:#67BCDB; box-shadow: 0px 0px 3px 0px rgba(50, 50, 50, 0.47);"> 
                     <div class=panel-heading style="background-color:#67BCDB; border-style:solid; border-color:#67BCDB; "> 
                             <h3 class=panel-title style="text-align:center;">Cum adaug o sugestie/reclamatie noua?</h3> </div>
                                         <div class=panel-body style="padding-top:30px; padding-bottom:32px;"> 
                                                 <ol>
                                                     <li>Apasa butonul 'Adauga o sugestie/reclamatie'</li>
                                                     <li>Completeaza toate datele din formularul de sugestie/reclamatie</li>
                                                     <li>Verific corectitudinea datelor introduse</li>
                                                     <li>Gata! Sugestia sau reclamatia dvs. ajunge la cel vizat</li>
                                                 </ol>
                                    <a href="ajutor.html">Vezi mai multe informatii</a>
                         </div></div>
               <div class="panel panel-primary" style="border-style:solid; border-color:#67BCDB; box-shadow: 0px 0px 3px 0px rgba(50, 50, 50, 0.47);"> 
                     <div class=panel-heading style="background-color:#67BCDB; border-style:solid; border-color:#67BCDB;"> 
                             <h3 class=panel-title style="text-align:center;">Informatii Utile pentru Parteneri</h3> 
                                        </div> <div class=panel-body style="padding-top:32px; padding-bottom:32px;"> 
                                                 <ul>
                                                     <li>Iti pasa de clientii tai sau de cetatenii orasului?</li>
                                                     <li>Ai un renume de protejat?</li>
                                                     <li>Vrei sa afli sugestii de la clientii/utilizatori tai in mod usor si gratuit </li>
                                                     <li>Devino partenerul nostru si profita de functionalitatile pe care ti le punem la dispozitie in mod gratuit si intra in contact direct cu clientii tai si nevoile lor</li>
                                                 </ul>
                                    <a href="informatiiparteneri.html">Vezi mai multe informatii</a>
                        </div> </div>
              

</div>

      </div>
    </div><!-- /.container -->
		
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