<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="el"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Cetak Laporan</title>

<!-- CSS -->
<link rel="stylesheet" href="<c:url value="/RES-INF/styles/default.css"/>" 	  type="text/css" />
<link rel="stylesheet" href="<c:url value="/RES-INF/styles/displaytag.css"/>" type="text/css">

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
		<div class="topheader">

			<!--left-->
			<div class="left">
				<h1 class="logo">
					Rumba <span>Collection</span>
				</h1>
				<br clear="all" />
			</div>

			<!--right-->
			<div class="right">

				<!--userinfo-->
				<div class="userinfo">
					<img alt="" src="<c:url value="/RES-INF/images/icons/sales.png"/>" />
					<span>Rumba Sales</span>
				</div>

				<!--userinfodrop-->
				<div class="userinfodrop">

					<!--avatar-->
					<div class="avatar">
						<a href=""><img alt="" src="<c:url value="/RES-INF/images/icons/salesbig.png"/>" /></a>
					</div>

					<!--userdata-->
					<div class="userdata">
						<h4>Rumba Sales</h4>
						<ul>
							<li><a onclick="return false">Ganti Password</a></li>
							<li><a href="<c:url value="/"/>">Logout</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<!--header-->
		<div class="header">
			<ul class="headermenu">
				<li>
					<a onclick="return false">
					<span class="icon icon-shirt"></span>Item</a>
				</li>
				<li>
					<a onclick="return false">
					<span class="icon icon-book"></span>Order</a>
				</li>
				<li class="current">
					<a onclick="return false">
					<span class="icon icon-author"></span>Laporan</a>
				</li>
			</ul>
		</div>

		<!--pageheader-->
		<div class="pageheader">
			<h1 class="pagetitle">Cetak Laporan</h1>

			<ul class="hornav">
				<li>
					<a href="<c:url value="/report/sales"/>">Laporan Penjualan</a>
				</li>
				<li class="current">
					<a onclick="return false">Laporan Stok Barang</a>
				</li>
			</ul>
		</div>

		<!--subcontent-->
		<div class="subcontent">
			<form class="stdform" method="get" action="report/stock">

				<!-- DISPLAY TAG TABLE -->
				<br clear="all" />
				<table id="dtag" style="margin-left: 10px;" width="98%">
				<tr>
				<td colspan="3">
					<display:table id="item" name="stock" requestURI="" export="true" pagesize="25">
						<display:column property="nama"   title="Nama Item" />
						<display:column property="jenis"  title="Kategori Item" />
						<display:column property="jumlah" title="Stok Item" />
					</display:table>
				</td>
				</tr>
				</table>

				<!-- BUTTON ACTION -->
				<p class="stdformbutton" style="margin: 10px 0 10px 10px;">
					<input class="reset radius2" type="reset" value="Keluar" onclick="window.location='<c:url value="/menu"/>'" />
				</p>
			</form>
		</div>
	</div>

	<!-- JS -->
	<script src="<c:url value="/RES-INF/scripts/plugins/jquery.js"/>" 			type="text/javascript"></script>
	<script	src="<c:url value="/RES-INF/scripts/plugins/jquery-ui.custom.js"/>"	type="text/javascript"></script>
	<script	src="<c:url value="/RES-INF/scripts/plugins/jquery.cookie.js"/>"	type="text/javascript"></script>
	<script	src="<c:url value="/RES-INF/scripts/plugins/jquery.uniform.js"/>"	type="text/javascript"></script>
	<script	src="<c:url value="/RES-INF/scripts/plugins/jquery.validate.js"/>"	type="text/javascript"></script>
	<script	src="<c:url value="/RES-INF/scripts/plugins/jquery.tagsinput.js"/>"	type="text/javascript"></script>
	<script src="<c:url value="/RES-INF/scripts/plugins/charCount.js"/>"		type="text/javascript"></script>
	<script src="<c:url value="/RES-INF/scripts/plugins/ui.spinner.js"/>"		type="text/javascript"></script>
	<script	src="<c:url value="/RES-INF/scripts/plugins/chosen.jquery.js"/>"	type="text/javascript"></script>
	<script src="<c:url value="/RES-INF/scripts/general.js"/>"					type="text/javascript"></script>
	<script src="<c:url value="/RES-INF/scripts/forms.js"/>"					type="text/javascript"></script>

	<!--[if lte IE 8]>
		<script src="<c:url value="/RES-INF/scripts/plugins/excanvas.js"/>" 		 type="text/javascript"></script>
	<![endif]-->

	<!--[if lt IE 9]>
		<script src="<c:url value="/RES-INF/scripts/plugins/css3-mediaqueries.js"/>" type="text/javascript"></script>
	<![endif]-->
</body>
</html>