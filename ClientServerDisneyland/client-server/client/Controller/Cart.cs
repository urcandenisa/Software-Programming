// This file has been autogenerated from a class added in the UI designer.

using System;

using Foundation;
using AppKit;
using client.ObjectHandler;
using core.Models;
using System.Threading;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace client
{
	public partial class Cart : NSViewController, IMessageController
	{
        private BaseHandler baseHandler;
		public Cart (IntPtr handle) : base (handle)
		{
            this.baseHandler = new BaseHandler(this);
		}

      
        [Export("initWithCoder:")]
        public Cart(NSCoder coder) : base(coder)
        {
            this.baseHandler = new BaseHandler(this);
        }

        // Call to load from the XIB/NIB file
        public Cart() : base("Cart", NSBundle.MainBundle)
        {
     
            this.baseHandler = new BaseHandler(this);
        }

     

        public void openWindow()
        {
            
        }

        public override void ViewDidAppear()
        {
            base.ViewDidAppear();
         
            this.baseHandler = new BaseHandler(this);
            
        }

        public void showMessage(string message)
        {
            this.InvokeOnMainThread(() =>
            {
                content.StringValue = message;
            });
        }

        public override void ViewDidLoad()
        {
            base.ViewDidLoad();
         
            this.baseHandler = new BaseHandler(this);
            String username = BaseHandler.username;
            if (username != null)
            {
                if (username != "administrator")
                {
                    baseHandler.findByUsername(username);
                }
                else
                {
                    content.StringValue = "administrator";
                }
            }
        }

        public void showActivity(Activity activity)
        {
            
        }

        public void showList(List<Activity> activites)
        {
            
        }

        public void showUser(User user)
        {
            
        }

        public void showAlert()
        {
           
        }
    }
}
