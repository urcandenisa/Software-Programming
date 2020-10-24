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
	[Register ("SearchUser")]
	partial class SearchUser
	{
		[Outlet]
		AppKit.NSTextField address { get; set; }

		[Outlet]
		AppKit.NSTextField city { get; set; }

		[Outlet]
		AppKit.NSTextField country { get; set; }

		[Outlet]
		AppKit.NSTextField firstName { get; set; }

		[Outlet]
		AppKit.NSTextField lastName { get; set; }

		[Outlet]
		AppKit.NSTextField state { get; set; }
		
		void ReleaseDesignerOutlets ()
		{
			if (firstName != null) {
				firstName.Dispose ();
				firstName = null;
			}

			if (lastName != null) {
				lastName.Dispose ();
				lastName = null;
			}

			if (country != null) {
				country.Dispose ();
				country = null;
			}

			if (address != null) {
				address.Dispose ();
				address = null;
			}

			if (city != null) {
				city.Dispose ();
				city = null;
			}

			if (state != null) {
				state.Dispose ();
				state = null;
			}
		}
	}
}
