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
    [TestFixture]
    public class TestCreateUser
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

            user = new User
            {
                email = "dragost@yahoo.com",
                password = "1234",
                firstName = "Dragos",
                lastName = "T",
                country = "Romania",
                address = "str.Panselutelor 16, nr. 15",
                city = "Cluj-Napoca",
                state = "Cluj"
            };


            messageControllerMock = new Mock<IMessageController>();
            messageControllerMock.Setup(x => x.showMessage(It.IsAny<String>()));
            messageControllerMock.Setup(x => x.showList(It.IsAny<List<Activity>>()));
        }

        [Test()]
        public void TestCase()
        {
            AdminHandler adminHandler = new AdminHandler(messageControllerMock.Object, messageMock.Object);
            
            BaseHandler baseHandler = new BaseHandler(messageControllerMock.Object, messageMock.Object);
            adminHandler.createAccount(user.email, user.password, user.firstName, user.lastName, user.country, user.address, user.city, user.state, "dragost", "2");

            expectedMessage = new Message
            {
                userContent = user,
                Content = "created"
            };
            serverMock.Setup(x => x.handleAsync(It.IsAny<Message>())).Returns(expectedMessage);
            baseHandler.handle(expectedMessage);

            Assert.That(expectedMessage.userContent != null);
        }

        [Test()]
        public void TestCaseReverse()
        {
            BaseHandler baseHandler = new BaseHandler(messageControllerMock.Object, messageMock.Object);
            AdminHandler adminHandler = new AdminHandler(messageControllerMock.Object, messageMock.Object);
            adminHandler.createAccount(user.email, user.password, user.firstName, user.lastName, user.country, user.address, user.city, user.state, "dragost", "2");

            expectedMessage = new Message
            {
                userContent = user,
                Content = "updated"
            };
            serverMock.Setup(x => x.handleAsync(It.IsAny<Message>())).Returns(expectedMessage);
            baseHandler.handle(expectedMessage);

            Assert.That(expectedMessage.userContent != null);
        }
    }
}

