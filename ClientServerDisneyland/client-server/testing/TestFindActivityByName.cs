using System;
using client.ObjectHandler;
using core;
using core.Models;
using Moq;
using NUnit.Framework;
using client;
using System.Collections.Generic;

namespace testing
{
    [TestFixture]
    public class TestFindActivityByName
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
            baseHandler.handleSearch("Gadget's Go Coaster");

            expectedMessage = new Message
            {
                messageType = MessageType.FIND_BY_NAME,
                activityContent = new Activity
                {
                    name = "Gadget's Go Coaster",
                    type = "Entertainment",
                    hours = "10-12, 14-16, 18-20",
                    location = "Disneyland Park, Mickey's town",
                    available = true,
                    maxNumber = 29,
                    pricePerPerson = 4,
                    rate = 4
                },
           
            };
            serverMock.Setup(x => x.handleAsync(It.IsAny<Message>())).Returns(expectedMessage);
            baseHandler.handle(expectedMessage);

            Assert.That(expectedMessage.activityContent != null);
        }

        [Test()]
        public void TestCaseReverse()
        {
            BaseHandler baseHandler = new BaseHandler(messageControllerMock.Object, messageMock.Object);
            baseHandler.handleSearch("Ala bala portocala");

            expectedMessage = new Message
            { 
                messageType = MessageType.FIND_BY_NAME,
            };
            serverMock.Setup(x => x.handleAsync(It.IsAny<Message>())).Returns(expectedMessage);

            baseHandler.handle(expectedMessage);

            Assert.That(expectedMessage.activityContent == null);
        }
    }
}
