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
	[Register ("UserView")]
	partial class UserView
	{
		[Action ("back:")]
		partial void back (Foundation.NSObject sender);

		[Action ("cart_clicked:")]
		partial void cart_clicked (Foundation.NSObject sender);

		[Action ("parkstickets_clicked:")]
		partial void parkstickets_clicked (Foundation.NSObject sender);

		[Action ("placesToStay_clicked:")]
		partial void placesToStay_clicked (Foundation.NSObject sender);

		[Action ("searched:")]
		partial void searched (AppKit.NSSearchField sender);

		[Action ("shop_clicked:")]
		partial void shop_clicked (Foundation.NSObject sender);

		[Action ("singOut_clicked:")]
		partial void singOut_clicked (Foundation.NSObject sender);

		[Action ("thingsToDo_clicked:")]
		partial void thingsToDo_clicked (Foundation.NSObject sender);
		
		void ReleaseDesignerOutlets ()
		{
		}
	}
}
