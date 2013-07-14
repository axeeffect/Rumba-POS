<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="el"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Master Data</title>

<!-- CSS -->
<link rel="stylesheet" href="<c:url value="/RES/styles/default.css"/>" type="text/css" />
<link rel="stylesheet" href="<c:url value="/RES/styles/displaytag.css"/>" type="text/css">

<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="<c:url value="/RES/styles/ie9.css"/>" type="text/css" />
<![endif]-->

<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="<c:url value="/RES/styles/ie8.css"/>" type="text/css" />
<![endif]-->
</head>
<body class="withvernav">

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
					<img alt="" src="<c:url value="/RES/images/sales.png"/>" />
					<span>Rumba Sales</span>
				</div>

				<!--userinfodrop-->
				<div class="userinfodrop">

					<!--avatar-->
					<div class="avatar">
						<a href=""><img alt="" src="<c:url value="/RES/images/salesbig.png"/>" /></a>
					</div>

					<!--userdata-->
					<div class="userdata">
						<h4>Rumba Sales</h4>
						<ul>
							<li><a href="<c:url value="setting"/>">Ganti Password</a></li>
							<li><a href="<c:url value="/"/>">Logout</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<!--header-->
		<div class="header">
			<ul class="headermenu">
				<li class="current">
					<a onclick="return false">
					<span class="icon icon-shirt"></span>Item</a>
				</li>
				<li>
					<a href="#order-item">
					<span class="icon icon-book"></span>Order</a>
				</li>
				<li>
					<a href="#laporan-penjualan">
					<span class="icon icon-author"></span>Laporan</a>
				</li>
			</ul>
		</div>

		<!--pageheader-->
		<div class="pageheader">
			<h1 class="pagetitle">Master Item</h1>
		</div>

		<!--contentwrapper-->
		<div id="validation" class="contentwrapper">
			<form id="form1" class="stdform" method="post" action="">
				<p>
					<label>Nama Barang</label>
					<span class="field">
						<input type="text" name="itemname" id="itemname" class="longinput" />
					</span>
				</p>
				<p>
					<label>Jenis Barang</label>
					<span class="field">
						<input type="text" name="itemkind" id="itemkind" class="longinput" />
					</span>
				</p>
				<p>
					<label>Jumlah</label>
					<span class="field">
						<input type="text" name="itemstock" id="itemstock" class="longinput" />
					</span>
				</p>
				<p>
					<label>Harga Satuan</label>
					<span class="field">
						<input type="text" name="itemprice" id="itemprice" class="longinput" />
					</span>
				</p>
				<br />
				<p class="stdformbutton">
					<button class="submit radius2">Simpan</button>
					<button class="submit radius2">Ubah</button>
					<button class="submit radius2">Hapus</button>
				</p>
				<br clear="all" />

				<table id="dtag" style="margin-left: 50px" width="85%">
					<tr>
					<td colspan="3">
						<display:table name="user" id="data" requestURI="" pagesize="10">
							<display:column property="username" title="Username" sortable="true" />
							<display:column property="password" title="Password" sortable="true" />
							<display:column property="role" title="Role" sortable="true" />
						</display:table>
					</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<!-- JS -->
	<script src="<c:url value="/RES/scripts/jquery.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/RES/scripts/jquery-ui.custom.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/RES/scripts/jquery.cookie.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/RES/scripts/jquery.uniform.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/RES/scripts/jquery.validate.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/RES/scripts/jquery.tagsinput.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/RES/scripts/charCount.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/RES/scripts/ui.spinner.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/RES/scripts/chosen.jquery.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/RES/scripts/general.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/RES/scripts/forms.js"/>" type="text/javascript"></script>

	<!--[if lte IE 8]>
		<script src="<c:url value="/RES/scripts/excanvas.js"/>" type="text/javascript"></script>
	<![endif]-->

	<!--[if lt IE 9]>
		<script src="<c:url value="/RES/scripts/css3-mediaqueries.js"/>" type="text/javascript"></script>
	<![endif]-->
</body>
</html>