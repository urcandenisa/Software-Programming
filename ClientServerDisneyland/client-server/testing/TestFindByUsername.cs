using client;
using client.ObjectHandler;
using core;
using core.Models;
using Moq;
using NUnit.Framework;
using System;

namespace testing
{
    [TestFixture()]
    public class TestFindByUsername
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

            messageControllerMock = new Mock<IMessageController>();
            messageControllerMock.Setup(x => x.showMessage(It.IsAny<String>()));
        }

        [Test()]
        public void TestCase()
        {
            BaseHandler baseHandler = new BaseHandler(messageControllerMock.Object, messageMock.Object);
            baseHandler.findByUsername("denisaurcan");

            expectedMessage = new Message
            {
                messageType = MessageType.FIND_BY_USERNAME,
                Content = "denisaurcan",
                userContent = user
            };
            serverMock.Setup(x => x.handleAsync(It.IsAny<Message>())).Returns(expectedMessage);

            baseHandler.handle(expectedMessage);

            Assert.That(expectedMessage.userContent.Equals(user));
        }

        [Test()]
        public void TestCaseReverse()
        {
            BaseHandler baseHandler = new BaseHandler(messageControllerMock.Object, messageMock.Object);
            baseHandler.findByUsername("test");

            expectedMessage = new Message
            {
                messageType = MessageType.FIND_BY_USERNAME,
                Content = "",
                userContent = user
            };
            serverMock.Setup(x => x.handleAsync(It.IsAny<Message>())).Returns(expectedMessage);

            baseHandler.handle(expectedMessage);

            Assert.That(expectedMessage.Content.CompareTo("") == 0);
        }
    }
}
