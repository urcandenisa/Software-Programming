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
	[Register ("ThingsToDo")]
	partial class ThingsToDo
	{
		[Outlet]
		AppKit.NSButton atractions { get; set; }

		[Outlet]
		AppKit.NSButton character { get; set; }

		[Outlet]
		AppKit.NSButton entertainment { get; set; }

		[Outlet]
		AppKit.NSTextField firstAct { get; set; }

		[Outlet]
		AppKit.NSTextField firstActivity { get; set; }

		[Outlet]
		AppKit.NSImageView firstImage { get; set; }

		[Outlet]
		AppKit.NSButton fitness { get; set; }

		[Outlet]
		AppKit.NSButton recreation { get; set; }

		[Outlet]
		AppKit.NSTextField secondAct { get; set; }

		[Outlet]
		AppKit.NSTextField secondActivity { get; set; }

		[Outlet]
		AppKit.NSImageView secondImage { get; set; }

		[Outlet]
		AppKit.NSTextField thirdAct { get; set; }

		[Outlet]
		AppKit.NSTextField thirdActivity { get; set; }

		[Outlet]
		AppKit.NSImageView thirdImage { get; set; }

		[Outlet]
		AppKit.NSButton viewMy { get; set; }

		[Action ("activities_clicked:")]
		partial void activities_clicked (Foundation.NSObject sender);

		[Action ("attractions_clicked:")]
		partial void attractions_clicked (Foundation.NSObject sender);

		[Action ("character_clicked:")]
		partial void character_clicked (Foundation.NSObject sender);

		[Action ("entertainment_clicked:")]
		partial void entertainment_clicked (Foundation.NSObject sender);

		[Action ("firstActivity_clicked:")]
		partial void firstActivity_clicked (Foundation.NSObject sender);

		[Action ("fitness_clicked:")]
		partial void fitness_clicked (Foundation.NSObject sender);

		[Action ("recreation_clicked:")]
		partial void recreation_clicked (Foundation.NSObject sender);

		[Action ("secondActivity_clicked:")]
		partial void secondActivity_clicked (Foundation.NSObject sender);

		[Action ("thirdActivity_clicked:")]
		partial void thirdActivity_clicked (Foundation.NSObject sender);

		[Action ("view:")]
		partial void view (Foundation.NSObject sender);
		
		void ReleaseDesignerOutlets ()
		{
			if (atractions != null) {
				atractions.Dispose ();
				atractions = null;
			}

			if (character != null) {
				character.Dispose ();
				character = null;
			}

			if (entertainment != null) {
				entertainment.Dispose ();
				entertainment = null;
			}

			if (firstActivity != null) {
				firstActivity.Dispose ();
				firstActivity = null;
			}

			if (secondAct != null) {
				secondAct.Dispose ();
				secondAct = null;
			}

			if (thirdAct != null) {
				thirdAct.Dispose ();
				thirdAct = null;
			}

			if (firstImage != null) {
				firstImage.Dispose ();
				firstImage = null;
			}

			if (firstAct != null) {
				firstAct.Dispose ();
				firstAct = null;
			}

			if (fitness != null) {
				fitness.Dispose ();
				fitness = null;
			}

			if (recreation != null) {
				recreation.Dispose ();
				recreation = null;
			}

			if (secondActivity != null) {
				secondActivity.Dispose ();
				secondActivity = null;
			}

			if (secondImage != null) {
				secondImage.Dispose ();
				secondImage = null;
			}

			if (thirdActivity != null) {
				thirdActivity.Dispose ();
				thirdActivity = null;
			}

			if (thirdImage != null) {
				thirdImage.Dispose ();
				thirdImage = null;
			}

			if (viewMy != null) {
				viewMy.Dispose ();
				viewMy = null;
			}
		}
	}
}
