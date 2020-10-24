using client.ObjectHandler;
using core;
using core.Models;
using Moq;
using NUnit.Framework;
using System;
using client;

namespace testing
{
    [TestFixture()]
    public class TestLogIn
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

            serverMock = new Mock<server.IMessageHandler>();

            messageControllerMock = new Mock<IMessageController>();
            messageControllerMock.Setup(x => x.showMessage(It.IsAny<String>()));
        }

        [Test()]
        public void TestCase()
        {
            BaseHandler baseHandler = new BaseHandler(messageControllerMock.Object, messageMock.Object);
            baseHandler.logIn("denisaurcan", "1234");

            expectedMessage = new Message
            {
                messageType = MessageType.LOG_IN,
                Content = "denisaurcan" + " " + "1234",
                userContent = user //expected user
            };

            baseHandler.handle(expectedMessage);

            Assert.That(expectedMessage.userContent.Equals(user));
        }

        [Test()]
        public void TestCaseReverse()
        {
            BaseHandler baseHandler = new BaseHandler(messageControllerMock.Object, messageMock.Object);
            baseHandler.logIn("denisaurcan", "1234");

            expectedMessage = new Message
            {
                messageType = MessageType.LOG_IN,
                Content = "",
                userContent = user //expected user
            };

            baseHandler.handle(expectedMessage);

            Assert.That(expectedMessage.Content.CompareTo("") == 0);
        }
    }
}
