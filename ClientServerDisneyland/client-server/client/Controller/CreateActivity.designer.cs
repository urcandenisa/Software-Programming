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
	[Register ("CreateActivity")]
	partial class CreateActivity
	{
		[Outlet]
		AppKit.NSTextField available { get; set; }

		[Outlet]
		AppKit.NSTextField hours { get; set; }

		[Outlet]
		AppKit.NSTextField location { get; set; }

		[Outlet]
		AppKit.NSTextField messageLog { get; set; }

		[Outlet]
		AppKit.NSTextField name { get; set; }

		[Outlet]
		AppKit.NSTextField price { get; set; }

		[Outlet]
		AppKit.NSLevelIndicator rate { get; set; }

		[Outlet]
		AppKit.NSTextField spots { get; set; }

		[Outlet]
		AppKit.NSTextField type { get; set; }

		[Action ("available_clicked:")]
		partial void available_clicked (Foundation.NSObject sender);

		[Action ("back:")]
		partial void back (Foundation.NSObject sender);

		[Action ("checked:")]
		partial void @checked (Foundation.NSObject sender);

		[Action ("createActivity_clicked:")]
		partial void createActivity_clicked (Foundation.NSObject sender);

		[Action ("delete:")]
		partial void delete (Foundation.NSObject sender);

		[Action ("hours_clicked:")]
		partial void hours_clicked (Foundation.NSObject sender);

		[Action ("location_clicked:")]
		partial void location_clicked (Foundation.NSObject sender);

		[Action ("name_clicked:")]
		partial void name_clicked (Foundation.NSObject sender);

		[Action ("price_clicked:")]
		partial void price_clicked (Foundation.NSObject sender);

		[Action ("quickLook:")]
		partial void quickLook (Foundation.NSObject sender);

		[Action ("spots_clicked:")]
		partial void spots_clicked (Foundation.NSObject sender);

		[Action ("type_clicked:")]
		partial void type_clicked (Foundation.NSObject sender);
		
		void ReleaseDesignerOutlets ()
		{
			if (available != null) {
				available.Dispose ();
				available = null;
			}

			if (hours != null) {
				hours.Dispose ();
				hours = null;
			}

			if (location != null) {
				location.Dispose ();
				location = null;
			}

			if (messageLog != null) {
				messageLog.Dispose ();
				messageLog = null;
			}

			if (name != null) {
				name.Dispose ();
				name = null;
			}

			if (price != null) {
				price.Dispose ();
				price = null;
			}

			if (spots != null) {
				spots.Dispose ();
				spots = null;
			}

			if (type != null) {
				type.Dispose ();
				type = null;
			}

			if (rate != null) {
				rate.Dispose ();
				rate = null;
			}
		}
	}
}
