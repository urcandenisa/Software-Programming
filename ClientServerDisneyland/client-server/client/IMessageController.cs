using System;
using System.Collections.Generic;
using AppKit;
using core.Models;

namespace client
{
    public interface IMessageController
    {
        void showMessage(String message);
        void openWindow();
        void showActivity(Activity activity);
        void showUser(User user);
        void showAlert();
        void showList(List<Activity> activites);
    }
}
