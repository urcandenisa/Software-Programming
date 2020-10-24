using System;
using core;

namespace server
{
    public interface IMessageHandler
    {
        Message handleAsync(Message msgReceived);
    }
}
