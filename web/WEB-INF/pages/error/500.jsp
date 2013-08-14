<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Internal Server Error</title>

<!-- CSS -->
<link rel="stylesheet" href="<c:url value="/RES-INF/styles/default.css"/>" type="text/css" />

<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="<c:url value="/RES-INF/styles/ie9.css"/>" type="text/css" />
<![endif]-->

<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="<c:url value="/RES-INF/styles/ie8.css"/>" type="text/css" />
<![endif]-->
</head>
<body>

	<!--bodywrapper-->
	<div class="bodywrapper">

		<!--topheader-->
		<div class="topheader orangeborderbottom5">

			<!--left-->
			<div class="left">
				<h1 class="logo">
					Rumba <span>Collection</span>
				</h1>
				<br clear="all" />
			</div>
		</div>

		<!--contentwrapper-->
		<div class="contentwrapper padding10">

			<!--errorwrapper-->
			<div class="errorwrapper error403">

				<!--errorcontent-->
				<div class="errorcontent">
					<h1>500 Internal Server Error</h1>
					<h3>The server encountered an internal error and was unable to complete your request.</h3>
					<p>Please contact the server administrator <strong>budi.oktaviyan@icloud.com</strong> and informed them of the time the error occurred.</p>
					<br clear="all" />

					<button class="stdbtn btn_black" onclick="history.back()">Go Back to Previous Page</button>
				</div>
			</div>
		</div>
	</div>

	<!-- JS -->
	<script src="<c:url value="/RES-INF/scripts/plugins/jquery.js"/>" 			type="text/javascript"></script>
	<script src="<c:url value="/RES-INF/scripts/plugins/jquery-ui.custom.js"/>" type="text/javascript"></script>
	<script	src="<c:url value="/RES-INF/scripts/plugins/jquery.cookie.js"/>" 	type="text/javascript"></script>
	<script src="<c:url value="/RES-INF/scripts/general.js"/>"					type="text/javascript"></script>

	<!--[if lt IE 9]>
		<script src="<c:url value="/RES-INF/scripts/plugins/css3-mediaqueries.js"/>" type="text/javascript"></script>
	<![endif]-->
</body>
</html>