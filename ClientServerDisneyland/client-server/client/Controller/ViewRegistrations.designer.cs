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
	[Register ("ViewRegistrations")]
	partial class ViewRegistrations
	{
		[Outlet]
		AppKit.NSButton firstActivity { get; set; }

		[Outlet]
		AppKit.NSButton firstDescription { get; set; }

		[Outlet]
		AppKit.NSTextField messageLog { get; set; }

		[Outlet]
		AppKit.NSButton secondActivity { get; set; }

		[Outlet]
		AppKit.NSButton secondDescription { get; set; }

		[Action ("firstActivity_clicked:")]
		partial void firstActivity_clicked (Foundation.NSObject sender);

		[Action ("secondActivity_clicked:")]
		partial void secondActivity_clicked (Foundation.NSObject sender);

		[Action ("unregister:")]
		partial void unregister (Foundation.NSObject sender);
		
		void ReleaseDesignerOutlets ()
		{
			if (firstActivity != null) {
				firstActivity.Dispose ();
				firstActivity = null;
			}

			if (secondActivity != null) {
				secondActivity.Dispose ();
				secondActivity = null;
			}

			if (secondDescription != null) {
				secondDescription.Dispose ();
				secondDescription = null;
			}

			if (firstDescription != null) {
				firstDescription.Dispose ();
				firstDescription = null;
			}

			if (messageLog != null) {
				messageLog.Dispose ();
				messageLog = null;
			}
		}
	}
}
