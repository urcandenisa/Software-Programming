using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using core.Models;
using server.ConnectionHandler;

namespace server
{
    class Program
    {
        //public static List<Socket> listObservers = new List<Socket>();
        public static Dictionary<Socket, Activity> listObservers = new Dictionary<Socket, Activity>();
        static void Main(String[] args)
        {

            var host = Dns.GetHostEntry("localhost");
            var ipAddress = host.AddressList.First();
            var localEndPoint = new IPEndPoint(ipAddress, 9000);
            var serverSocket = new Socket(ipAddress.AddressFamily, SocketType.Stream, ProtocolType.Tcp);
            serverSocket.Bind(localEndPoint);
            serverSocket.Listen(10);

            while (true)
            {
                Console.WriteLine("Waiting for client...");
                Socket clientSocket = serverSocket.Accept();
                //listObservers.Add(clientSocket);
                var _ = new Connection(clientSocket);
            }
        }
        
    }
}
