using System;
using System.Collections.Generic;
using System.Linq;
using Foundation;
using AppKit;

namespace client.View
{
    public partial class AdministratorWindow : AppKit.NSWindow
    {
        #region Constructors

        // Called when created from unmanaged code
        public AdministratorWindow(IntPtr handle) : base(handle)
        {
            Initialize();
        }

        // Called when created directly from a XIB file
        [Export("initWithCoder:")]
        public AdministratorWindow(NSCoder coder) : base(coder)
        {
            Initialize();
        }

        // Shared initialization code
        void Initialize()
        {
        }

        #endregion
    }
}
