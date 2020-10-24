using System;
using core;

namespace client
{
    public interface IMessageHandler
    {
        void sendMessage(Message message);

        void receiveMessage();
    }
}
