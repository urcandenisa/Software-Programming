using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Threading;
using System.Threading.Tasks;
using client.ObjectHandler;
using core;

namespace client.ConnectionHandler
{
    public class Connection
    {
        private static Socket serverSocket;
        private BaseHandler baseHandler;
        public Connection(BaseHandler baseHandler)
        {
            this.baseHandler = baseHandler;
            IPHostEntry host = Dns.GetHostEntry("localhost");
            IPAddress ipAddress = host.AddressList.First();
            IPEndPoint serverEndpoint = new IPEndPoint(ipAddress, 9000);
            
            ThreadPool.SetMaxThreads(1, 1);
            if (serverSocket == null)
            {
                serverSocket = new Socket(ipAddress.AddressFamily, SocketType.Stream, ProtocolType.Tcp);
                serverSocket.Connect(serverEndpoint);
                Console.WriteLine($"Successfully connected to server on: {serverSocket.RemoteEndPoint}");
            }
            Task.Run(() => receiveMessage());
        }

        public async void receiveMessage()
        {
            Message receivedMessage = null;
            var buffer = new byte[2048 * 4];
            int bytesReceived = 0;
            while (true)
            {
               
                if (serverSocket.Available != 0)
                {
                    bytesReceived = serverSocket.Receive(buffer);

                    if (bytesReceived != 0)
                    {
                        receivedMessage = (Message)Serializer.FromStream(new MemoryStream(buffer));
                        Console.WriteLine($"Received message: {receivedMessage.Content}");

                        //handle message
                        baseHandler.handle(receivedMessage);
                    }
                   
                }
                await Task.Delay(100);
                //Thread.Sleep(300);
            }
        }

        public void SendMessage(Message msg)
        {
            Console.WriteLine($"Sending msg with content : {msg.Content}");
            MemoryStream stream = Serializer.ToStream(msg);
            var bytesSent = serverSocket.Send(stream.GetBuffer());

            Console.WriteLine("Waiting to receive");
        }
    }
}
