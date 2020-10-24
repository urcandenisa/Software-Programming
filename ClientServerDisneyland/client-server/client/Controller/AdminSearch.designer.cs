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
	[Register ("AdminSearch")]
	partial class AdminSearch
	{
		[Outlet]
		AppKit.NSTextField available { get; set; }

		[Outlet]
		AppKit.NSTextField hours { get; set; }

		[Outlet]
		AppKit.NSTextField location { get; set; }

		[Outlet]
		AppKit.NSTextField maxNumber { get; set; }

		[Outlet]
		AppKit.NSTextField name { get; set; }

		[Outlet]
		AppKit.NSTextField type { get; set; }
		
		void ReleaseDesignerOutlets ()
		{
			if (name != null) {
				name.Dispose ();
				name = null;
			}

			if (type != null) {
				type.Dispose ();
				type = null;
			}

			if (hours != null) {
				hours.Dispose ();
				hours = null;
			}

			if (location != null) {
				location.Dispose ();
				location = null;
			}

			if (available != null) {
				available.Dispose ();
				available = null;
			}

			if (maxNumber != null) {
				maxNumber.Dispose ();
				maxNumber = null;
			}
		}
	}
}
