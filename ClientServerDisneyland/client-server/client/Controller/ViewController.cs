using System;

using AppKit;
using Foundation;

namespace client
{
    public partial class ViewController : NSViewController
    {
        public ViewController(IntPtr handle) : base(handle)
        {
        }

        public override void ViewDidLoad()
        {
            base.ViewDidLoad();

            // Do any additional setup after loading the view.
        }

        partial void singIn(NSObject sender)
        {
            this.View.Window.Close();
            var storyboard = NSStoryboard.FromName("Main", null);
            var controller = storyboard.InstantiateControllerWithIdentifier("LogIn") as NSWindowController;
            controller.ShowWindow(Self);
        }

        public override NSObject RepresentedObject
        {
            get
            {
                return base.RepresentedObject;
            }
            set
            {
                base.RepresentedObject = value;
                // Update the view, if already loaded.
            }
        }
    }
}
