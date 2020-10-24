// WARNING
//
// This file has been generated automatically by Visual Studio to store outlets and
// actions made in the UI designer. If it is removed, they will be lost.
// Manual changes to this file may not be handled correctly.
//
using Foundation;
using System.CodeDom.Compiler;

namespace client
{
	[Register ("UpdateDeleteAccount")]
	partial class UpdateDeleteAccount
	{
		[Outlet]
		AppKit.NSTextField address { get; set; }

		[Outlet]
		AppKit.NSButton checkedTerms { get; set; }

		[Outlet]
		AppKit.NSTextField city { get; set; }

		[Outlet]
		AppKit.NSTextField country { get; set; }

		[Outlet]
		AppKit.NSTextField email { get; set; }

		[Outlet]
		AppKit.NSTextField firstName { get; set; }

		[Outlet]
		AppKit.NSTextField lastName { get; set; }

		[Outlet]
		AppKit.NSTextField messageLog { get; set; }

		[Outlet]
		AppKit.NSTextField password { get; set; }

		[Outlet]
		AppKit.NSTextField state { get; set; }

		[Outlet]
		AppKit.NSTextField substriptions { get; set; }

		[Action ("address_clicked:")]
		partial void address_clicked (Foundation.NSObject sender);

		[Action ("back:")]
		partial void back (Foundation.NSObject sender);

		[Action ("checked:")]
		partial void @checked (Foundation.NSObject sender);

		[Action ("city_clicked:")]
		partial void city_clicked (Foundation.NSObject sender);

		[Action ("country_clicked:")]
		partial void country_clicked (Foundation.NSObject sender);

		[Action ("createAccount_clicked:")]
		partial void createAccount_clicked (Foundation.NSObject sender);

		[Action ("delete_clicked:")]
		partial void delete_clicked (Foundation.NSObject sender);

		[Action ("email_clicked:")]
		partial void email_clicked (Foundation.NSObject sender);

		[Action ("firstName_clicked:")]
		partial void firstName_clicked (Foundation.NSObject sender);

		[Action ("lastName_clicked:")]
		partial void lastName_clicked (Foundation.NSObject sender);

		[Action ("password_clicked:")]
		partial void password_clicked (Foundation.NSObject sender);

		[Action ("quickLook_clicked:")]
		partial void quickLook_clicked (Foundation.NSObject sender);

		[Action ("state_clicked:")]
		partial void state_clicked (Foundation.NSObject sender);
		
		void ReleaseDesignerOutlets ()
		{
			if (address != null) {
				address.Dispose ();
				address = null;
			}

			if (checkedTerms != null) {
				checkedTerms.Dispose ();
				checkedTerms = null;
			}

			if (city != null) {
				city.Dispose ();
				city = null;
			}

			if (country != null) {
				country.Dispose ();
				country = null;
			}

			if (email != null) {
				email.Dispose ();
				email = null;
			}

			if (firstName != null) {
				firstName.Dispose ();
				firstName = null;
			}

			if (lastName != null) {
				lastName.Dispose ();
				lastName = null;
			}

			if (messageLog != null) {
				messageLog.Dispose ();
				messageLog = null;
			}

			if (password != null) {
				password.Dispose ();
				password = null;
			}

			if (state != null) {
				state.Dispose ();
				state = null;
			}

			if (substriptions != null) {
				substriptions.Dispose ();
				substriptions = null;
			}
		}
	}
}
