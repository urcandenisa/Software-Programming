using client;
using client.ObjectHandler;
using core;
using core.Models;
using Moq;
using NUnit.Framework;
using System;
using System.Collections.Generic;

namespace testing
{
    public class TestSearchStars
    {
        private Mock<IBaseHandler> clientMock;
        private Mock<IMessageHandler> messageMock;
        private Mock<server.IMessageHandler> serverMock;
        private Mock<client.IMessageController> messageControllerMock;
        private Message expectedMessage;
        private User user;

        [SetUp]

        public void SetUpMocks()
        {
            clientMock = new Mock<IBaseHandler>();
       
            clientMock.Setup(x => x.handle(It.IsAny<Message>()));

            messageMock = new Mock<IMessageHandler>();
            messageMock.Setup(x => x.sendMessage(It.IsAny<Message>()));
            messageMock.Setup(x => x.receiveMessage());

            serverMock = new Mock<server.IMessageHandler>();
            

            messageControllerMock = new Mock<IMessageController>();
            messageControllerMock.Setup(x => x.showMessage(It.IsAny<String>()));
            messageControllerMock.Setup(x => x.showList(It.IsAny<List<Activity>>()));
        }

        [Test()]
        public void TestCase()
        {
            BaseHandler baseHandler = new BaseHandler(messageControllerMock.Object, messageMock.Object);
            baseHandler.handleSearch("4 stars");

            expectedMessage = new Message
            {
                messageType = MessageType.HANDLE_SEARCH,
                activities = new List<Activity>
                {
                    new Activity{
                    name = "Gadget's Go Coaster",
                    type = "Entertainment",
                    hours = "10-12, 14-16, 18-20",
                    location = "Disneyland Park, Mickey's town",
                    available = true,
                    maxNumber = 29,
                    pricePerPerson = 4,
                    rate = 4
                    }
                }

            };
            serverMock.Setup(x => x.handleAsync(It.IsAny<Message>())).Returns(expectedMessage);
            baseHandler.handle(expectedMessage);

            Assert.That(expectedMessage.activities != null);
        }

        [Test()]
        public void TestCaseReverse()
        {
            BaseHandler baseHandler = new BaseHandler(messageControllerMock.Object, messageMock.Object);
            baseHandler.handleSearch("2 stars");

            expectedMessage = new Message
            {
                messageType = MessageType.HANDLE_SEARCH,
                activities = null

            };
            serverMock.Setup(x => x.handleAsync(It.IsAny<Message>())).Returns(expectedMessage);

            baseHandler.handle(expectedMessage);

            Assert.That(expectedMessage.activities == null);
        }
    }
}