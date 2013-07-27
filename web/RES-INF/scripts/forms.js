/*
 * 	Additional function for forms.html
 *	Written by ThemePixels	
 *	http://themepixels.com/
 *
 *	Copyright (c) 2012 ThemePixels (http://themepixels.com)
 *	
 *	Built for Amanda Premium Responsive Admin Template
 *  http://themeforest.net/category/site-templates/admin-templates
 */

jQuery(document).ready(function() {

					// FORM TRANSFORMATION //
					jQuery('input:checkbox, input:radio, select.uniformselect, input:file').uniform();

					// DUAL BOX //

					// get arrows of dual select
					var db = jQuery('#dualselect').find('.ds_arrow .arrow');

					// first select element
					var sel1 = jQuery('#dualselect select:first-child'); // get

					// second select element
					var sel2 = jQuery('#dualselect select:last-child'); // get

					// empty it first from dom.
					sel2.empty();

					db.click(function() {

						// arrow prev otherwise arrow next
						var t = (jQuery(this).hasClass('ds_prev')) ? 0 : 1; // 0 if

						if (t) {
							sel1.find('option').each(function() {
								if (jQuery(this).is(':selected')) {
									jQuery(this).attr('selected', false);
									var op = sel2.find('option:first-child');
									sel2.append(jQuery(this));
								}
							});
						} else {
							sel2.find('option').each(function() {
								if (jQuery(this).is(':selected')) {
									jQuery(this).attr('selected', false);
									sel1.append(jQuery(this));
								}
							});
						}
					});

					// FORM VALIDATION //
					jQuery("#form1").validate({
						rules : {
							kode  	: "required",
							nama  	: "required",
							jenis 	: "required",
							//stok 	: "required",
							harga 	: "required"
						},
						messages : {
							kode  	: "Kode item kosong",
							nama  	: "Nama item kosong",
							jenis  	: "Jenis item kosong",
							//stok	: "Jumlah/Stok item kosong",
							harga 	: "Harga satuan kosong"
						}
					});

					// TAG INPUT //
					jQuery('#tags').tagsInput();

					// SPINNER //
					jQuery("#spinner").spinner({
						min : 0,
						max : 100,
						increment : 2
					});

					// CHARACTER COUNTER //
					jQuery("#textarea2").charCount({
						allowed : 120,
						warning : 20,
						counterText : 'Characters left: '
					});

					// SELECT WITH SEARCH //
					jQuery(".chzn-select").chosen();
				});