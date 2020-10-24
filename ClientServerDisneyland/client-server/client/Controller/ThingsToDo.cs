// This file has been autogenerated from a class added in the UI designer.

using System;

using Foundation;
using AppKit;
using client.ObjectHandler;
using core.Models;
using System.Linq;
using System.Collections.Generic;
using System.Threading;

namespace client
{
	public partial class ThingsToDo : NSViewController, IMessageController
	{
        public static bool closed = false;
        public static bool registering = false;
        private BaseHandler baseHandler;
        private UserHandler userHandler;
        public static bool viewRegistrations = false;
		public ThingsToDo (IntPtr handle) : base (handle)
		{
            baseHandler = new BaseHandler(this);
            this.userHandler = new UserHandler(this);
		}

        public override void ViewDidLoad()
        {
            base.ViewDidLoad();
            baseHandler = new BaseHandler(this);
            this.userHandler = new UserHandler(this);
        }

        public override void ViewDidAppear()
        {
            base.ViewDidAppear();
            baseHandler = new BaseHandler(this);
            this.userHandler = new UserHandler(this);
        }

        partial void entertainment_clicked(NSObject sender)
        {
            entertainment.ContentTintColor = NSColor.SystemGrayColor;
            character.ContentTintColor = NSColor.SystemBlueColor;
            recreation.ContentTintColor = NSColor.SystemBlueColor;
            fitness.ContentTintColor = NSColor.SystemBlueColor;
            atractions.ContentTintColor = NSColor.SystemBlueColor;
           
            userHandler.handleActivities("Entertainment");
            
        }

        partial void attractions_clicked(NSObject sender)
        {
            entertainment.ContentTintColor = NSColor.SystemBlueColor;
            character.ContentTintColor = NSColor.SystemBlueColor;
            recreation.ContentTintColor = NSColor.SystemBlueColor;
            fitness.ContentTintColor = NSColor.SystemBlueColor;
            atractions.ContentTintColor = NSColor.SystemGrayColor;
            userHandler.handleActivities("Attractions");
            
        }

        partial void character_clicked(NSObject sender)
        {
            entertainment.ContentTintColor = NSColor.SystemBlueColor;
            character.ContentTintColor = NSColor.SystemGrayColor;
            recreation.ContentTintColor = NSColor.SystemBlueColor;
            fitness.ContentTintColor = NSColor.SystemBlueColor;
            atractions.ContentTintColor = NSColor.SystemBlueColor;
            this.InvokeOnMainThread(() =>
            {
                userHandler.handleActivities("Character");
            });
        }

        partial void recreation_clicked(NSObject sender)
        {
            entertainment.ContentTintColor = NSColor.SystemBlueColor;
            character.ContentTintColor = NSColor.SystemBlueColor;
            recreation.ContentTintColor = NSColor.SystemGrayColor;
            fitness.ContentTintColor = NSColor.SystemBlueColor;
            atractions.ContentTintColor = NSColor.SystemBlueColor;
            this.InvokeOnMainThread(() =>
            {
                userHandler.handleActivities("Recreation");
            });
        }

        partial void fitness_clicked(NSObject sender)
        {
            entertainment.ContentTintColor = NSColor.SystemBlueColor;
            character.ContentTintColor = NSColor.SystemBlueColor;
            recreation.ContentTintColor = NSColor.SystemBlueColor;
            fitness.ContentTintColor = NSColor.SystemGrayColor;
            atractions.ContentTintColor = NSColor.SystemBlueColor;
            this.InvokeOnMainThread(() =>
            {
                userHandler.handleActivities("Entertainment");
            });
        }

        partial void activities_clicked(NSObject sender)
        {
            if (BaseHandler.username != null)
            {
                if (BaseHandler.username.CompareTo("administrator") == 0)
                {
                    this.View.Window!.Close();
                    closed = true;
                    var storyboard = NSStoryboard.FromName("Main", null);
                    var controller = storyboard.InstantiateControllerWithIdentifier("CreateActivity") as NSWindowController;
                    controller.ShowWindow(this);
                }
            }
        }

        partial void secondActivity_clicked(NSObject sender)
        {
            BaseHandler.activityName = secondAct.StringValue;
            registering = true;
            var storyboard = NSStoryboard.FromName("Main", null);
            var controller = storyboard.InstantiateControllerWithIdentifier("Register") as NSWindowController;
            controller.ShowWindow(Self);
        }

        partial void thirdActivity_clicked(NSObject sender)
        {
            BaseHandler.activityName = thirdAct.StringValue;
            registering = true;
            var storyboard = NSStoryboard.FromName("Main", null);
            var controller = storyboard.InstantiateControllerWithIdentifier("Register") as NSWindowController;
            controller.ShowWindow(this);
        }

        partial void firstActivity_clicked(NSObject sender)
        {
            BaseHandler.activityName = firstAct.StringValue;
            registering = true;
            var storyboard = NSStoryboard.FromName("Main", null);
            var controller = storyboard.InstantiateControllerWithIdentifier("Register") as NSWindowController;
            controller.ShowWindow(Self);
        }

        partial void view(NSObject sender)
        {
            //view all registrated activities for this account
            if (viewMy.Title.CompareTo("View my registrations") == 0)
            {
                viewRegistrations = true;
                var storyboard = NSStoryboard.FromName("Main", null);
                var controller = storyboard.InstantiateControllerWithIdentifier("ViewRegistrations") as NSWindowController;
                controller.ShowWindow(Self);
            }
        }

        public void showMessage(string message)
        {
            
        }

        public void openWindow()
        {
         
        }

        public void showActivity(Activity activity)
        {
            
        }

        public void showUser(User user)
        {
           
        }

        public void showList(List<Activity> activities)
        {
            this.InvokeOnMainThread(() => {
                if(activities != null)
                {
                    firstImage.Image = null;
                    secondImage.Image = null;
                    thirdImage.Image = null;
                    viewMy.Title = "View my registrations";
                    firstActivity.StringValue = "";
                    secondActivity.StringValue = "";
                    thirdActivity.StringValue = "";
                    firstAct.Hidden = false;
                    secondAct.Hidden = false;
                    thirdAct.Hidden = false;
                    if (activities.Count > 0)
                    {
                        firstAct.StringValue = activities.ElementAt(0).name;
                        secondAct.StringValue = "";
                        thirdAct.StringValue = "";
                        if (activities.Count > 1)
                        {
                            secondAct.StringValue = activities.ElementAt(1).name;
                            if (activities.Count > 2)
                            {
                                thirdAct.StringValue = activities.ElementAt(2).name;

                            }
                        }
                    }
                }
            });
        }

        public void showAlert()
        {
            InvokeOnMainThread(() =>
            {
                var storyboard = NSStoryboard.FromName("Main", null);
                var controller = storyboard.InstantiateControllerWithIdentifier("Alert") as NSWindowController;
                controller.ShowWindow(Self);
            });
            
        }
    }
}