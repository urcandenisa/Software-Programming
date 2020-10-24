using client;
using client.ObjectHandler;
using core;
using core.Models;
using Moq;
using NUnit.Framework;
using server.Service;

namespace testing
{
    [TestFixture]
    public class CreateDatabase
    {
        private Mock<IUserService> userServiceMock;
        private Mock<IActivityService> activityServiceMock;

        /* check if the database is being created */
        [SetUp]
        public void SetUpMocks()
        {
            userServiceMock = new Mock<IUserService>();
            activityServiceMock = new Mock<IActivityService>();
        }
        [Test()]
        public void CheckUserCase()
        {
            //arrange
            var obj = new UserService();
            var user = obj.findById(1);
            userServiceMock.Setup(x => x.findById(It.IsAny<int>())).Returns(user);
            //act
            var res = userServiceMock.Object.findById(1);
            //assert
            Assert.That(res, !Is.Null);
        }

        [Test()]
        public void CheckActivityCase()
        {
            //arrange
            var obj = new ActivityService();
            var activity = obj.findById(1);
            activityServiceMock.Setup(x => x.findById(It.IsAny<int>())).Returns(activity);
            //act
            var res = activityServiceMock.Object.findById(1);
            //assert
            Assert.That(res, !Is.Null);
        }
    }
}
