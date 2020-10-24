using System;
using client;
using client.ObjectHandler;
using core;
using core.Models;
using Moq;
using NUnit.Framework;

namespace testing
{
    [TestFixture()]
    public class TestCreateActivity
    {
        private Mock<IBaseHandler> baseMock;
        private Mock<IAdminHandler> clientMock;
        private Mock<IMessageHandler> messageMock;
        private Mock<server.IMessageHandler> serverMock;
        private Mock<client.IMessageController> messageControllerMock;
        private Message expectedMessage;
        private Activity activity;

        [SetUp]
        public void SetUpMocks()
        {
            baseMock = new Mock<IBaseHandler>();
            baseMock.Setup(x => x.handle(It.IsAny<Message>()));

            clientMock = new Mock<IAdminHandler>();
            clientMock.Setup(x => x.createActivity(It.IsAny<Activity>()));

            messageMock = new Mock<IMessageHandler>();
            messageMock.Setup(x => x.sendMessage(It.IsAny<Message>()));
            messageMock.Setup(x => x.receiveMessage());

            serverMock = new Mock<server.IMessageHandler>();

            
            activity  = new Activity
            {
                name = "1",
                type = "Entertainment",
                hours = "10-12, 14-16, 18-20",
                location = "test",
                available = true,
                maxNumber = 29,
                pricePerPerson = 4
            };

            messageControllerMock = new Mock<IMessageController>();
            messageControllerMock.Setup(x => x.showMessage(It.IsAny<String>()));
        }

        [Test()]
        public void TestCase()
        {
            BaseHandler baseHandler = new BaseHandler(messageControllerMock.Object, messageMock.Object);
            AdminHandler adminHandler = new AdminHandler(messageControllerMock.Object, messageMock.Object);
            adminHandler.createActivity(activity);

            expectedMessage = new Message
            {
                messageType = MessageType.CREATE_ACTIVITY,
                Content = "created",
                activityContent = activity
            };
            serverMock.Setup(x => x.handleAsync(It.IsAny<Message>())).Returns(expectedMessage);

            baseHandler.handle(expectedMessage);

            Assert.That(expectedMessage.activityContent.Equals(activity));
        }

        [Test()]
        public void TestCaseReverse()
        {
            BaseHandler baseHandler = new BaseHandler(messageControllerMock.Object, messageMock.Object);
            AdminHandler adminHandler = new AdminHandler(messageControllerMock.Object, messageMock.Object);
            adminHandler.createActivity(activity);

            expectedMessage = new Message
            {
                messageType = MessageType.CREATE_ACTIVITY,
                Content = "updated",
                activityContent = activity
            };
            serverMock.Setup(x => x.handleAsync(It.IsAny<Message>())).Returns(expectedMessage);

            baseHandler.handle(expectedMessage);

            Assert.That(expectedMessage.Content.CompareTo("created")!= 0);
        }
    }
}
