using System;
using System.Collections.Generic;
using client.ObjectHandler;
using core;
using core.Models;
using Moq;
using NUnit.Framework;
using server.Service;

namespace testing
{
    public class TestDeleteUser
    {
   
        private Mock<client.IMessageHandler> messageMock;
        private Mock<server.IMessageHandler> serverMock;
        private Mock<client.IMessageController> messageControllerMock;
        private Message expectedMessage;
        [SetUp]
        public void SetUpMocks()
        {
            
            serverMock = new Mock<server.IMessageHandler>();
            messageMock = new Mock<client.IMessageHandler>();
            messageMock.Setup(x => x.sendMessage(It.IsAny<Message>()));
            messageMock.Setup(x => x.receiveMessage());
            messageControllerMock = new Mock<client.IMessageController>();
            messageControllerMock.Setup(x => x.showMessage(It.IsAny<String>()));
            messageControllerMock.Setup(x => x.showList(It.IsAny<List<Activity>>()));
        }

        [Test()]
        /* check delete user operation */
        public void DeleteUserCase()
        {
            //aarange
            
            AdminHandler adminHandler = new AdminHandler(messageControllerMock.Object, messageMock.Object);
            BaseHandler baseHandler = new BaseHandler(messageControllerMock.Object, messageMock.Object);
            expectedMessage = new Message
            {
                messageType = MessageType.DELETE_ACCOUNT,
                Content = "deleted"
            };
            serverMock.Setup(x => x.handleAsync(It.IsAny<Message>())).Returns(expectedMessage);
            baseHandler.handle(expectedMessage);
            //act
            adminHandler.deleteAccount("test@gmail.com");
            //asert
            Assert.That(expectedMessage.Content.CompareTo("deleted") == 0);
        }
    }
}