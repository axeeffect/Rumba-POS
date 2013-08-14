<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="el"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Order Item</title>

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
<body class="withnoisebg">

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
				<li>
					<a href="<c:url value="item"/>">
					<span class="icon icon-shirt"></span>Item</a>
				</li>
				<li class="current">
					<a onclick="return false">
					<span class="icon icon-book"></span>Order</a>
				</li>
				<li>
					<a href="<c:url value="report/sales"/>">
					<span class="icon icon-author"></span>Laporan</a>
				</li>
			</ul>
		</div>

		<!--pageheader-->
		<div class="pageheader">
			<h1 class="pagetitle">Order Item</h1>
		</div>

		<!--contentwrapper-->
		<div id="validation" class="contentwrapper">
			<form id="form2" onkeypress="return event.keyCode != 13;" class="stdform" method="post" action="<c:url value="order"/>">

			<!-- HIDDEN FIELD -->
			<input type="hidden" name="mode"   value="${mode}"/>
			<input type="hidden" name="kode"   value="${kode}"/>
			<input type="hidden" name="jumlah" value="${jumlah}"/>

			<!-- ORDER FIELD -->
			<p>
			<label>Tanggal Order</label>
				<span class="field">
					<input id="tanggal" class="smallinput" type="date" name="tanggal" value="${tanggal}" maxlength="10" />
				</span>
			</p>
			<p>
			<label>Nama Item</label>
				<span class="field">
					<input id="nama" class="longinput" type="text" name="nama" readonly="readonly" />
				</span>
			</p>
			<p>
			<label>Harga per Item</label>
				<span class="field">
					<input id="harga" class="mediuminput" type="text" name="harga" readonly="readonly" />
				</span>
			</p>
			<p>
			<label>Jumlah Order</label>
				<span class="field">
					<input id="pesan" class="smallinput" type="text" name="pesan" maxlength="3" />
				</span>
			</p>

			<!-- BUTTON ACTION -->
			<br />
			<p class="stdformbutton">
				<button class="submit radius2" onclick="SearchWindow('<c:url value="item/search"/>','Cari Item',600,400); return false;">Cari</button>
				<button class="submit radius2">Tambah</button>
				<c:if test="${mode == 2}">
					<button id="buttonorder" type="button" class="submit radius2">Order</button>
				</c:if>
			</p>
			</form>
			<br clear="all" />

			<!-- DISPLAY TAG TABLE -->
			<table id="dtag" style="margin-left: 135px;" width="75%">
			<tr>
			<td colspan="3">
				<display:table id="order" name="cart" requestURI="">
					<display:column property="kode"  title="Kode Item"		sortable="true" />
					<display:column property="nama"  title="Nama Item"		sortable="true" />
					<display:column property="harga" title="Harga per Item" sortable="true" />
					<display:column property="pesan" title="Jumlah Order"	sortable="true" />
					<display:column property="total" title="Total"			sortable="true" />
					<display:column title="Action">
						<button class="action radius2" onclick="window.location='<c:url value="order/delete?id=${order.kode}"/>'">Hapus</button>
					</display:column>
				</display:table>
			</td>
			</tr>
			</table>

			<!-- HIDDEN FORM -->
			<form id="submitform" style="visibility:hidden;" method="post" action="<c:url value="order/submit"/>" />
		</div>
	</div>

	<!-- JS -->
	<script src="<c:url value="/RES-INF/scripts/plugins/jquery.js"/>" 			type="text/javascript"></script>
	<script src="<c:url value="/RES-INF/scripts/plugins/jquery-ui.custom.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/RES-INF/scripts/plugins/jquery.cookie.js"/>" 	type="text/javascript"></script>
	<script src="<c:url value="/RES-INF/scripts/plugins/jquery.uniform.js"/>" 	type="text/javascript"></script>
	<script src="<c:url value="/RES-INF/scripts/plugins/jquery.validate.js"/>" 	type="text/javascript"></script>
	<script src="<c:url value="/RES-INF/scripts/plugins/jquery.tagsinput.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/RES-INF/scripts/plugins/charCount.js"/>" 		type="text/javascript"></script>
	<script src="<c:url value="/RES-INF/scripts/plugins/ui.spinner.js"/>" 		type="text/javascript"></script>
	<script src="<c:url value="/RES-INF/scripts/plugins/chosen.jquery.js"/>" 	type="text/javascript"></script>
	<script src="<c:url value="/RES-INF/scripts/general.js"/>" 					type="text/javascript"></script>
	<script src="<c:url value="/RES-INF/scripts/forms.js"/>" 					type="text/javascript"></script>

	<!--[if lte IE 8]>
		<script src="<c:url value="/RES-INF/scripts/plugins/excanvas.js"/>" 		 type="text/javascript"></script>
	<![endif]-->

	<!--[if lt IE 9]>
		<script src="<c:url value="/RES-INF/scripts/plugins/css3-mediaqueries.js"/>" type="text/javascript"></script>
	<![endif]-->

	<script>
		function SearchWindow(pageURL, title, w, h) {
			var left = (screen.width / 2)  - (w / 2);
			var top  = (screen.height / 2) - (h / 2);
			var targetWin = window.open(pageURL, title,
										'toolbar=no, location=no, directories=no, ' +
										'status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, ' +
										'width=' + w + ', height='	+ h	+ ', top=' + top + ', left=' + left);
		}

		jQuery('#buttonorder').bind('click', function(){
			jQuery('#submitform').submit();
		});
	</script>
</body>
</html>