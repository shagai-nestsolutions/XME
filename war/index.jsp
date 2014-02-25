<!DOCTYPE html public "-//W3C//DTD HTML 4.0 Transitional//en" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href='http://fonts.googleapis.com/css?family=Roboto:400,300,700' rel='stylesheet' type='text/css'>
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600,700&amp;lang=en" rel="stylesheet">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<!--[if IE 7]>
<link rel="stylesheet" href="/css/font-awesome-ie7.min.css">
<![endif]-->

<link href="/css/bootplus.css" rel="stylesheet">
<link href="/css/bootplus-responsive.css" rel="stylesheet">

<link href="/css/docs.css" rel="stylesheet">
<link href="/css/google-code-prettify/prettify.css" rel="stylesheet">

<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.3/angular.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.3/angular-resource.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.3/angular-route.js"></script>
<script src="//maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&language=mn&region=MN&libraries=visualization"></script>
<title>XME Tracking</title>
<style>
#contact {
	font-family: 'Open Sans', sans-serif;
	line-height: 23px;
}

.contact-icon {
	border-radius: 44px;
	display: inline-block;
	float: left;
	height: 87px;
	overflow: hidden;
	text-indent: -999px;
	width: 87px;
	background-color: #148CD3;
	background-image: linear-gradient(to bottom, #148CD3, #0D7BCB);
	border: 1px solid #0F6BBA;
	box-shadow: none;
}

.contact-item {
	float: left;
	font-weight: 100;
	min-height: 86px;
	width: 300px;
	display: inline-block;
	font-size: 14px;
	margin: 0px 0 0 20px;
	text-align: left;
}

.contact-line {
	color: #3E4C58;
	display: block;
	font-size: 14px;
	margin: 5px 0 0 20px;
	vertical-align: top;
	margin: 0px 0 0 110px;
}

.contact-item .large {
	display: inline-block;
	font-size: 18px;
	margin: 0px 0 0 21px;
}

.contact-item .small {
	font-size: 11px;
	display: block;
	margin: -5px 0 0 110px;
}

.contact-line a {
	color: #3369E8;
}

.help-sprite {
	background: url("/img/help_sprite.png") no-repeat scroll 0 0;
	display: block;
	overflow: hidden;
	text-align: left !important;
	text-indent: -999px;
}

.help-sprite-phone {
	background-position: -65px -3px; height : 46px;
	margin: 20px 0 0 31px;
	width: 28px;
	height: 46px;
}

.help-sprite-email {
	background-position: -98px -3px;
	height: 26px;
	margin: 29px 0 0 24px;
	width: 42px;
}

.help-sprite-chat {
	background-position: -143px -3px;
	height: 31px;
	margin: 29px 0 0 24px;
	width: 42px;
}

#contact {
	-moz-box-sizing: border-box;
	background-color: #FFFFFF;
	border: 1px solid #D7E1E8;
	border-radius: 15px;
	margin-bottom: 50px;
	padding: 25px 35px 35px;
	width: 100%;
	text-align: center;
	box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.15);
}

.mid {
	width: auto;
	display: inline-block;
	margin: 0 auto;
}
.container{
	padding: 0 20px;
	background: #FFFFFF;
}
.form-control:focus{
	border-color: #66AFE9;
	box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(102, 175, 233, 0.6);
	outline: 0 none;
}
</style>
</head>

<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="brand" href="">XME Tracking</a>
				<div class="nav-collapse">
					<ul class="nav">
						<li class=""><a href="#services">Services & Prices</a></li>
						<li class=""><a href="#contact">Questions & Answers</a></li>
						<li class=""><a href="#contact">Contact</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div id="services" class="container">
		<h1>Discover our services</h1>
		<div class="row-fluid">
			<div class="span6">
				<h2>Personal Delivery</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
					magna mollis euismod. Donec sed odio dui.</p>
				<p>
				<form>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">Pick up :</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="inputEmail3" placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">Deliver to :</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="inputEmail3" placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">Phone :</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="inputEmail3" placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<a href="#" class="btn btn-success">Submit »</a>
					</div>
				</form>
					
				</p>
			</div>
			<div class="span6">
				<h2>Bussiness to Bussiness</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
					magna mollis euismod. Donec sed odio dui.</p>
				<p>
					<a href="#" class="btn btn-success">View details »</a>
				</p>
			</div>
		</div>
	</div>
	<div class="container">
		<h1>We're here for you</h1>
		<div id="contact" class="clearfix">
			<div class="mid">
				<div class="contact-item">
					<span class="contact-icon"><em class="help-sprite help-sprite-phone">phone</em></span>
					<div class="contact-text">
						<span class="contact-line large">Call us</span> <span class="contact-line"> <a href="tel:8667777550"> 866-777-7550</a>
						</span> <span class="contact-line small">Open 24 hours/day, 7 days/week</span>
					</div>
				</div>
				<div class="contact-item">
					<span class="contact-icon"><em class="help-sprite help-sprite-email">phone</em></span>
					<div class="contact-text">
						<span class="contact-line large">Email us</span> <span class="contact-line"> <a href="tel:8667777550">contact@ubdelivery.com</a>
						</span> <span class="contact-line small">Open 24 hours/day, 7 days/week</span>
					</div>
				</div>
				<div class="contact-item">
					<span class="contact-icon"><em class="help-sprite help-sprite-chat">phone</em></span>
					<div class="contact-text">
						<span class="contact-line large">Chat</span> <span class="contact-line"> <a href="tel:8667777550"> 866-777-7550</a>
						</span> <span class="contact-line small">Open 24 hours/day, 7 days/week</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
