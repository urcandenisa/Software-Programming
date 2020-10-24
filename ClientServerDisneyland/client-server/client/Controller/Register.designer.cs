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
	[Register ("Register")]
	partial class Register
	{
		[Outlet]
		AppKit.NSTextField messageLog { get; set; }

		[Outlet]
		AppKit.NSTextField numberOfPeople { get; set; }

		[Outlet]
		AppKit.NSTextField price { get; set; }

		[Outlet]
		AppKit.NSLevelIndicator rate { get; set; }

		[Action ("back:")]
		partial void back (Foundation.NSObject sender);

		[Action ("register_clicked:")]
		partial void register_clicked (Foundation.NSObject sender);
		
		void ReleaseDesignerOutlets ()
		{
			if (messageLog != null) {
				messageLog.Dispose ();
				messageLog = null;
			}

			if (numberOfPeople != null) {
				numberOfPeople.Dispose ();
				numberOfPeople = null;
			}

			if (price != null) {
				price.Dispose ();
				price = null;
			}

			if (rate != null) {
				rate.Dispose ();
				rate = null;
			}
		}
	}
}
