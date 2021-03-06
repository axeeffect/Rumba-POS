<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="el"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Master Item</title>

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
				<li class="current">
					<a onclick="return false">
					<span class="icon icon-shirt"></span>Item</a>
				</li>
				<li>
					<a onclick="return false">
					<span class="icon icon-book"></span>Order</a>
				</li>
				<li>
					<a onclick="return false">
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
			<form id="form1" onkeypress="return event.keyCode != 13;" class="stdform" method="post" action="<c:url value="/item"/>">
			<input type="hidden" name="mode" value="${mode}"/>

			<!-- ADD ITEM -->
			<c:if test="${mode == 0}">
			<p>
			<label>Kode Item</label>
				<span class="field">
					<input id="kode" class="smallinput" type="text" name="kode" maxlength="5" />
				</span>
			</p>
			<p>
			<label>Nama Item</label>
				<span class="field">
					<input id="nama" class="longinput" type="text" name="nama" />
				</span>
			</p>
			<p>
			<label>Jenis Item</label>
				<span class="field">
					<input id="jenis" class="mediuminput" type="text" name="jenis" />
				</span>
			</p>
			<p>
			<label>Jumlah Item</label>
				<span class="field">
					<input id="jumlah" class="smallinput" type="text" name="jumlah" maxlength="3" />
				</span>
			</p>
			<p>
			<label>Harga Satuan</label>
				<span class="field">
					<input id="harga" class="mediuminput" type="text" name="harga" maxlength="9" />
				</span>
			</p>
			</c:if>

			<!-- UPDATE ITEM -->
			<c:if test="${mode == 1}">
			<p>
			<label>Kode Item</label>
				<span class="field">
					<input id="kode" class="smallinput" type="text" name="kode" value="${item.kode}" readonly="readonly" />
				</span>
			</p>
			<p>
			<label>Nama Item</label>
				<span class="field">
					<input id="nama" class="longinput" type="text" name="nama" value="${item.nama}" />
				</span>
			</p>
			<p>
			<label>Jenis Item</label>
				<span class="field">
					<input id="jenis" class="mediuminput" type="text" name="jenis" value="${item.jenis}" />
				</span>
			</p>
			<p>
			<label>Jumlah Item</label>
				<span class="field">
					<input id="jumlah" class="smallinput" type="text" name="jumlah" value="${item.jumlah}" maxlength="3" />
				</span>
			</p>
			<p>
			<label>Harga Satuan</label>
				<span class="field">
					<input id="harga" class="mediuminput" type="text" name="harga" value="${item.harga}" maxlength="9" />
				</span>
			</p>
			</c:if>

			<!-- BUTTON ACTION -->
			<br />
			<!-- Item Page -->
			<c:if test="${mode == 0}">
			<p class="stdformbutton">
				<button class="submit radius2">Simpan</button>
				<input class="reset radius2" type="reset" value="Keluar" onclick="window.location='<c:url value="/menu"/>'" />
			</p>
			</c:if>

			<!-- Item Edit Page -->
			<c:if test="${mode == 1}">
			<p class="stdformbutton">
				<button class="submit radius2">Ubah</button>
				<input class="reset radius2" type="reset" value="Batal" onclick="window.location='<c:url value="/item/cancel"/>'" />
			</p>
			</c:if>
			</form>
			<br clear="all" />

			<!-- DISPLAY TAG TABLE -->
			<c:if test="${mode == 0}">
			<table id="dtag" style="margin-left: 135px;" width="75%">
			<tr>
			<td colspan="3">
				<display:table id="data" name="item" requestURI="" pagesize="10">
					<display:column property="kode"   title="Kode Item"    sortable="true" />
					<display:column property="nama"   title="Nama Item"    sortable="true" />
					<display:column property="jenis"  title="Jenis Item"   sortable="true" />
					<display:column property="jumlah" title="Jumlah Item"  sortable="true" />
					<display:column property="harga"  title="Harga Satuan" sortable="true" />
					<display:column title="Action">
					<c:set var="id" value="${data.kode}" />
						<button class="action radius2" style="margin-right: 20px" onclick="window.location='<c:url value="item/edit?kode=${id}"/>'">Ubah</button>
						<button class="action radius2" onclick="window.location='<c:url value="item/delete?kode=${id}"/>'">Hapus</button>
					</display:column>
				</display:table>
			</td>
			</tr>
			</table>
			</c:if>
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
</body>
</html>