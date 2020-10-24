using System;
using client.ConnectionHandler;
using core;

namespace client.ObjectHandler
{
    public class MessageHandler : IMessageHandler
    {
        private Connection connection;
        private BaseHandler baseHandler;

        public MessageHandler(BaseHandler baseHandler, Connection connection = null)
        {
            this.baseHandler = baseHandler;
            this.connection = connection ?? new Connection(baseHandler);
        }

        public void sendMessage(Message message)
        {
            connection.SendMessage(message);
        }

        public void receiveMessage()
        {
            connection.receiveMessage();
        }
    }
}
