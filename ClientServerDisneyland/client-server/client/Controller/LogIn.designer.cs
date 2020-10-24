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
	[Register ("LogIn")]
	partial class LogIn
	{
		[Outlet]
		AppKit.NSTextField messageLog { get; set; }

		[Outlet]
		AppKit.NSSecureTextField password { get; set; }

		[Outlet]
		AppKit.NSTextField username { get; set; }

		[Action ("createAccount_clicked:")]
		partial void createAccount_clicked (Foundation.NSObject sender);

		[Action ("password_clicked:")]
		partial void password_clicked (Foundation.NSObject sender);

		[Action ("signIn_clicked:")]
		partial void signIn_clicked (Foundation.NSObject sender);

		[Action ("username_clicked:")]
		partial void username_clicked (Foundation.NSObject sender);
		
		void ReleaseDesignerOutlets ()
		{
			if (messageLog != null) {
				messageLog.Dispose ();
				messageLog = null;
			}

			if (password != null) {
				password.Dispose ();
				password = null;
			}

			if (username != null) {
				username.Dispose ();
				username = null;
			}
		}
	}
}
