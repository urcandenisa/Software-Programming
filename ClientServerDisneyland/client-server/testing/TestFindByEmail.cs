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
    public class TestFindByEmail
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

        [Test()]
        public void TestCase()
        {
            BaseHandler baseHandler = new BaseHandler(messageControllerMock.Object, messageMock.Object);
            baseHandler.handleSearch("denisaurcan@icloud.com");

            expectedMessage = new Message
            {
                messageType = MessageType.FIND_BY_EMAIL,
                userContent = user,
                Content = "denisaurcan@icloud.com"

            };
            serverMock.Setup(x => x.handleAsync(It.IsAny<Message>())).Returns(expectedMessage);
            baseHandler.handle(expectedMessage);

            Assert.That(expectedMessage.userContent.Equals(user));
        }

        [Test()]
        public void TestCaseReverse()
        {
            BaseHandler baseHandler = new BaseHandler(messageControllerMock.Object, messageMock.Object);
            baseHandler.handleSearch("alabalaportocala@yahoo.com");

            expectedMessage = new Message
            {
                messageType = MessageType.FIND_BY_EMAIL,
                userContent = null,
                Content = "alabalaportocala@yahoo.com"

            };
            serverMock.Setup(x => x.handleAsync(It.IsAny<Message>())).Returns(expectedMessage);

            baseHandler.handle(expectedMessage);

            Assert.That(expectedMessage.userContent == null);
        }
    }

}

