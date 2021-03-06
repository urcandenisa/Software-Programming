// This file has been autogenerated from a class added in the UI designer.

using System;

using Foundation;
using AppKit;
using client.ObjectHandler;
using core.Models;
using System.Collections.Generic;

namespace client
{
    public partial class UpdateDeleteAccount : NSViewController, IMessageController
    {
        private BaseHandler baseHandler;
        private AdminHandler adminHandler;
        private bool check = false;
        public String segueFName;
        public String segueLName;
        public String segueCountry;
        public String segueAddress;
        public String segueCity;
        public String segueState;
        public UpdateDeleteAccount(IntPtr handle) : base(handle)
        {
            baseHandler = new BaseHandler(this);
            adminHandler = new AdminHandler(this);
            segueFName = "";
            segueLName = "";
            segueCity = "";
            segueAddress = "";
            segueState = "";
            segueCountry = "";
        }

        public override void ViewDidLoad()
        {
            base.ViewDidLoad();
            baseHandler = new BaseHandler(this);
            adminHandler = new AdminHandler(this);
        }

        partial void back(NSObject sender)
        {
            var storyboard = NSStoryboard.FromName("Main", null);
            this.View.Window.Close();
            var controller = storyboard.InstantiateControllerWithIdentifier("AdministratorView") as NSWindowController;
            controller.ShowWindow(this);
        }

        partial void quickLook_clicked(NSObject sender)
        {
            String searchingAfter = email.StringValue;
            adminHandler.searchUser(searchingAfter);
        }
        partial void delete_clicked(NSObject sender)
        {
            if (check == false)
            {

                messageLog.StringValue = "Please read the terms and conditions!";

            }
            else
            {
                adminHandler.deleteAccount(email.StringValue);
            }
        }

        partial void address_clicked(NSObject sender)
        {
            this.InvokeOnMainThread(() =>
            {
                messageLog.StringValue = "";
                checkedTerms.State = NSCellStateValue.Off;
            });
        }

        partial void city_clicked(NSObject sender)
        {
            this.InvokeOnMainThread(() =>
            {
                messageLog.StringValue = "";
                checkedTerms.State = NSCellStateValue.Off;
            });
        }

        partial void @checked(NSObject sender)
        {
            this.InvokeOnMainThread(() => { this.check = true; messageLog.StringValue = ""; });
        }

        partial void createAccount_clicked(NSObject sender)
        {
            if (check == false)
            {
                messageLog.StringValue = "Please read the terms and conditions!";
            }
            else
            {
                adminHandler.createAccount(email.StringValue, password.StringValue, firstName.StringValue, lastName.StringValue, country.StringValue, address.StringValue, city.StringValue, state.StringValue, BaseHandler.username, substriptions.StringValue);
            }
        }

        partial void country_clicked(NSObject sender)
        {
            this.InvokeOnMainThread(() =>
            {
                messageLog.StringValue = "";
                checkedTerms.State = NSCellStateValue.Off;
            });
        }

        partial void email_clicked(NSObject sender)
        {
            this.InvokeOnMainThread(() =>
            {
                messageLog.StringValue = "";
                checkedTerms.State = NSCellStateValue.Off;
            });
        }

        partial void lastName_clicked(NSObject sender)
        {
            this.InvokeOnMainThread(() =>
            {
                messageLog.StringValue = "";
                checkedTerms.State = NSCellStateValue.Off;
            });
        }

        partial void firstName_clicked(NSObject sender)
        {
            this.InvokeOnMainThread(() =>
            {
                messageLog.StringValue = "";
                checkedTerms.State = NSCellStateValue.Off;
            });
        }

        partial void password_clicked(NSObject sender)
        {
            this.InvokeOnMainThread(() =>
            {
                messageLog.StringValue = "";
                checkedTerms.State = NSCellStateValue.Off;
            });
        }

        partial void state_clicked(NSObject sender)
        {
            this.InvokeOnMainThread(() =>
            {
                messageLog.StringValue = "";
                checkedTerms.State = NSCellStateValue.Off;
            });
        }
        public void openWindow()
        {
            
        }

        public void showActivity(Activity activity)
        {
            
        }

        public void showList(List<Activity> activites)
        {
           
        }

        public void showMessage(string message)
        {
            this.InvokeOnMainThread(() => { messageLog.StringValue = message; });
        }

        public void showUser(User user)
        {
            this.InvokeOnMainThread(() =>
            {
                segueFName = user.firstName;
                segueLName = user.lastName;
                segueCountry = user.country;
                segueCity = user.city;
                segueAddress = user.address;
                segueState = user.state;
                PerformSegue("admin4", this);
            });
        }

        public override void PrepareForSegue(NSStoryboardSegue segue, NSObject sender)
        {
            this.InvokeOnMainThread(() =>
            {

                var destination = segue.DestinationController as SearchUser;
                destination.segueFName = segueFName;
                destination.segueAddress = segueAddress;
                destination.segueLName = segueLName;
                destination.segueCountry = segueCountry;
                destination.segueCity = segueCity;
                destination.segueState = segueState;
            });

        }

        public void showAlert()
        {
            throw new NotImplementedException();
        }
    }
}
