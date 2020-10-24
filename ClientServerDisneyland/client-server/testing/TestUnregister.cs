using client.ObjectHandler;
using core;
using core.Models;
using Moq;
using NUnit.Framework;
using System;
using client;

namespace testing
{
    [TestFixture]
    public class TestUnregister
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
        public void TestCase()
        {
            BaseHandler baseHandler = new BaseHandler(messageControllerMock.Object, messageMock.Object);
            UserHandler userHandler = new UserHandler(messageControllerMock.Object, messageMock.Object);
            userHandler.unregister("denisaurcan", "Gadget's Go Coaster");

            expectedMessage = new Message
            {
                messageType = MessageType.UNREGISTER,
                Content = "unregistered"
            };

            serverMock.Setup(x => x.handleAsync(It.IsAny<Message>())).Returns(expectedMessage);
            baseHandler.handle(expectedMessage);

            Assert.That(expectedMessage.Content.CompareTo("unregistered") == 0);
        }

        [Test]
        public void TestCase2()
        {
            BaseHandler baseHandler = new BaseHandler(messageControllerMock.Object, messageMock.Object);
            UserHandler userHandler = new UserHandler(messageControllerMock.Object, messageMock.Object);
            userHandler.unregister("denisaurcan", "ALA BALA");

            expectedMessage = new Message
            {
                messageType = MessageType.UNREGISTER,
                Content = "failed"
            };

            serverMock.Setup(x => x.handleAsync(It.IsAny<Message>())).Returns(expectedMessage);
            baseHandler.handle(expectedMessage);

            Assert.That(expectedMessage.Content.CompareTo("unregistered") != 0);
        }
    }

}
