<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Ganti Password</title>

<!-- CSS -->
<link rel="stylesheet" href="<c:url value="/RES-INF/styles/default.css"/>" type="text/css" />

<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="<c:url value="/RES-INF/styles/ie9.css"/>" type="text/css" />
<![endif]-->

<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="<c:url value="/RES-INF/styles/ie8.css"/>" type="text/css" />
<![endif]-->
</head>
<body class="loginpage">

	<!--loginbox-->
	<div class="loginbox">

		<!--loginboxinner-->
		<div class="loginboxinner">

			<!--logo-->
			<div class="logo">
				<h1>
					<span>Ganti&nbsp;</span>Password
				</h1>
			</div>
			<br clear="all" />

			<!--nopassword-->
			<div class="nopassword">
				<div class="loginmsg">Input password lama dan baru Anda.</div>
			</div>

			<div class="nousername">
				<div class="loginmsg">Password lama dan baru tidak boleh sama.</div>
			</div>

			<form id="changepass" action="<c:url value="/"/>" method="post">
				<div class="password">
					<div class="passwordinner">
						<input type="password" name="password" id="oldpassword" />
					</div>
				</div>
				<div class="password">
					<div class="passwordinner">
						<input type="password" name="password" id="newpassword" />
					</div>
				</div>
				<button>Update Password</button>
			</form>
		</div>
	</div>

	<!-- JS -->
	<script src="<c:url value="/RES-INF/scripts/plugins/jquery.js"/>" 			type="text/javascript"></script>
	<script src="<c:url value="/RES-INF/scripts/plugins/jquery-ui.custom.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/RES-INF/scripts/plugins/jquery.cookie.js"/>" 	type="text/javascript"></script>
	<script src="<c:url value="/RES-INF/scripts/plugins/jquery.uniform.js"/>" 	type="text/javascript"></script>
	<script src="<c:url value="/RES-INF/scripts/general.js"/>" 					type="text/javascript"></script>
	<script src="<c:url value="/RES-INF/scripts/setting.js"/>" 					type="text/javascript"></script>

	<!--[if lt IE 9]>
		<script src="<c:url value="/RES-INF/scripts/plugins/css3-mediaqueries.js"/>" type="text/javascript"></script>
	<![endif]-->
</body>
</html>