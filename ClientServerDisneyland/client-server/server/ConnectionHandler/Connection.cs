using System;
using System.IO;
using System.Linq;
using System.Net.Sockets;
using System.Threading;
using System.Threading.Tasks;
using core;
using core.Models;
using server.RequestHandler;

namespace server.ConnectionHandler
{
    public class Connection
    {
        private Socket socket;
        private BaseHandler baseHandler;
        private AdminHandler adminHandler;
        private UserHandler userHandler;
        private MessageHandler messageHandler;

        public Connection(Socket socket, MessageHandler messageHandler = null, AdminHandler adminHandler = null, BaseHandler baseHandler = null, UserHandler userHandler = null)
        {
            this.socket = socket;
            this.adminHandler = adminHandler ?? new AdminHandler();
            this.baseHandler = baseHandler ?? new BaseHandler();
            this.userHandler = userHandler ?? new UserHandler();
            this.messageHandler = new MessageHandler();

            Console.WriteLine($"Connected to client: {socket.RemoteEndPoint}");

            Task.Run(() => Execute(socket));
        }

        private async void Execute(Socket socket)
        {
            while (true)
            {
                var buffer = new byte[4*2048];
                var bytesCount = socket.Receive(buffer);
                if (bytesCount != 0)
                {
                    var msgReceived = (Message)Serializer.FromStream(new MemoryStream(buffer));
                    Console.WriteLine($"Received msg data type: {msgReceived.Content}");
                    //handle message
                    Message msgToSend = messageHandler.handleAsync(msgReceived);
                    if (msgToSend.Content != null)
                    {
                        if (msgToSend.Content.CompareTo("observer") == 0)
                        {
                            //Program.listObservers.Add(socket);
                            Activity activity = msgToSend.activityContent;
                            try
                            {
                                Program.listObservers.Add(socket, activity);
                            }catch(Exception exc)
                            {
                                Console.WriteLine("Registration already made");
                            }
                        }
                        if (msgToSend.messageType == MessageType.CREATE_ACTIVITY && msgToSend.Content.CompareTo("updated") == 0)
                        {
                            var list = Program.listObservers;
                            foreach (var observer in Program.listObservers)
                            {
                                if (observer.Value.Equals(msgToSend.activityContent))
                                {
                                    Console.WriteLine($"Sending message with content: {msgReceived.Content} to {observer.Key.RemoteEndPoint}");
                                    messageHandler.send(observer.Key, new Message { messageType = MessageType.NOTIFY });
                                    await Task.Delay(100);
                                }
                            }
                        }
                    }
                    Console.WriteLine($"Sending message with content: {msgReceived.Content}");
                    await Task.Delay(100);
                    messageHandler.send(socket, msgToSend);
                }

                Console.WriteLine("Trying again");
                await Task.Delay(100);
            }
        }
    }
}
