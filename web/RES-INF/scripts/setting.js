jQuery(document).ready(function() {

			// TRANSFORM CHECKBOX //
			jQuery('input:checkbox').uniform();

			// CHANGE PASSWORD FORM SUBMIT //
			jQuery('#changepass').submit(function() {
						if (jQuery('#oldpassword').val() == ''	&& jQuery('#newpassword').val() == ''
						 || jQuery('#oldpassword').val() == ''	&& jQuery('#newpassword').val() != ''
						 || jQuery('#oldpassword').val() != ''	&& jQuery('#newpassword').val() == '') {
							jQuery('.nopassword').fadeIn();
							jQuery('.nousername').hide();

							return false;
						}
						if (jQuery('#oldpassword').val() == jQuery('#newpassword').val()) {
							jQuery('.nousername').fadeIn();
							jQuery('.nopassword').hide();

							return false;
						}
					});

			// ADD PLACEHOLDER //
			jQuery('#oldpassword').attr('placeholder', 'Password Lama');
			jQuery('#newpassword').attr('placeholder', 'Password Baru');
		});