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
    public class TestUpdateRating
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
            clientMock.Setup(x => x.findByUsername(It.IsAny<String>()));
            clientMock.Setup(x => x.handle(It.IsAny<Message>()));

            messageMock = new Mock<IMessageHandler>();
            messageMock.Setup(x => x.sendMessage(It.IsAny<Message>()));
            messageMock.Setup(x => x.receiveMessage());

            serverMock = new Mock<server.IMessageHandler>();

            messageControllerMock = new Mock<IMessageController>();
            messageControllerMock.Setup(x => x.showMessage(It.IsAny<String>()));

            user = new User
            {
                email = "denisaurcan@icloud.com",
                password = "1234",
                firstName = "Denisa",
                lastName = "Urcan",
                country = "Romania",
                address = "str.Lunii 22B, nr. 15",
                city = "Cluj-Napoca",
                state = "Cluj"
            };
        }

        [Test]
        public void TestCase1()
        {

            BaseHandler baseHandler = new BaseHandler(messageControllerMock.Object, messageMock.Object);
            UserHandler userHandler = new UserHandler(messageControllerMock.Object, messageMock.Object);
            userHandler.updateRating("Gadget's Go Coaster", "4");

            expectedMessage = new Message
            {
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
                messageType = MessageType.UPDATE_RATING
            };

            serverMock.Setup(x => x.handleAsync(It.IsAny<Message>())).Returns(expectedMessage);
            baseHandler.handle(expectedMessage);

            Assert.That(expectedMessage.activityContent != null);
        }

        [Test]
        public void TestCase2()
        {

            BaseHandler baseHandler = new BaseHandler(messageControllerMock.Object, messageMock.Object);
            UserHandler userHandler = new UserHandler(messageControllerMock.Object, messageMock.Object);
            userHandler.updateRating("Haunted Mansion", "3");

            expectedMessage = new Message
            {
                activityContent = new Activity
                {
                    name = "Haunted Mansion",
                    type = "Entertainment",
                    hours = "10-12, 14-16",
                    location = "Disneyland Park, New Orleans Square",
                    available = true,
                    maxNumber = 2,
                    pricePerPerson = 10,
                    rate = 4
                },
                messageType = MessageType.UPDATE_RATING
            };

            serverMock.Setup(x => x.handleAsync(It.IsAny<Message>())).Returns(expectedMessage);
            baseHandler.handle(expectedMessage);

            Assert.That(expectedMessage.activityContent.rate == 4);
        }
    }
}
